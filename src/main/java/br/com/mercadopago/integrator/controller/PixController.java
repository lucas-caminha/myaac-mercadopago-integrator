package br.com.mercadopago.integrator.controller;

import static java.util.Objects.nonNull;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;

import br.com.mercadopago.integrator.properties.PropertiesValues;
import br.com.mercadopago.integrator.request.CreatePixPaymentRequest;
import br.com.mercadopago.integrator.response.PixCreationResponse;
import br.com.mercadopago.integrator.service.PlayerPaymentService;

@RestController
@RequestMapping("/api/v1/pix")
public class PixController {
	
	@Autowired
	private PropertiesValues properties;
	
	@Autowired
	private PlayerPaymentService playerPaymentService;
	
	private static String BLANK = "";
		
	@PostMapping("/create")
	public PixCreationResponse createPixPayment(@RequestBody CreatePixPaymentRequest pixRequest) {
		
		MercadoPagoConfig.setAccessToken(properties.getIntegratorAccessToken());
		
	    PaymentClient client = new PaymentClient();

	    PaymentCreateRequest createRequest =
	        PaymentCreateRequest.builder()
	            .transactionAmount(new BigDecimal(pixRequest.getTransactionAmount()))
	            .token(BLANK)
	            .description(pixRequest.getDescription())
	            .installments(1)
	            .paymentMethodId(pixRequest.getPaymentMethodId())
	            .payer(PaymentPayerRequest.builder().email(pixRequest.getPayerEmail()).build())
	            .build();

	    try {
	    	Payment payment = client.create(createRequest);
	    	if(nonNull(payment)) {
	    		playerPaymentService.savePlayerPayment(pixRequest, payment);
	    		
		    	PixCreationResponse response = new PixCreationResponse();
		    	response.setQrCode(payment.getPointOfInteraction().getTransactionData().getQrCode());
		    	response.setIdPayment(payment.getId().toString());		    	
		    	return response;
	    	}
	    	
	    	throw new RuntimeException("Payment error, no have return.");
	    } catch (MPApiException ex) {
	    	throw new RuntimeException("MercadoPago Error. Status: " + ex.getApiResponse().getStatusCode() + ", Content: " + ex.getApiResponse().getContent());
	    } catch (MPException ex) {
	    	ex.printStackTrace();
	    	throw new RuntimeException("MercadoPago Error" + ex.getMessage());     
	    }	    
	    
	}

}	
