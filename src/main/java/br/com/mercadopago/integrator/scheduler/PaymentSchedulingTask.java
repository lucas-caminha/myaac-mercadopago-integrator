package br.com.mercadopago.integrator.scheduler;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;

import br.com.mercadopago.integrator.entity.PlayerPayment;
import br.com.mercadopago.integrator.properties.PropertiesValues;
import br.com.mercadopago.integrator.service.AccountService;
import br.com.mercadopago.integrator.service.PaymentStatusEnum;
import br.com.mercadopago.integrator.service.PlayerPaymentService;

@Component
public class PaymentSchedulingTask {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentSchedulingTask.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private PlayerPaymentService playerPaymentService;
	
	@Autowired
	private PropertiesValues properties;
	
	@Autowired
	private AccountService accountService;
	
		
	@Scheduled(cron = "${integrator.payment.cron.expression}")
	public void run() throws MPException, MPApiException {
		log.info("Running PaymentSchedulingTask now {}", dateFormat.format(new Date()));
		
		MercadoPagoConfig.setAccessToken(properties.getIntegratorAccessToken());
		
		List<PlayerPayment> noPaidList = playerPaymentService.getPlayerPaymentNoPaid();
		
		for(PlayerPayment payment : noPaidList) {
			Long paymentId = Long.parseLong(payment.getPlayerPaymentPK().getIdPayment());
			Payment mpPayment = getMPPayment(paymentId);
			updatePayment(mpPayment, payment);
		}
		
	}
	
	private Payment getMPPayment(Long paymentId) throws MPException, MPApiException {
	    PaymentClient client = new PaymentClient();
	    return client.get(paymentId);
	}
	
	private void updatePayment(Payment mpPayment, PlayerPayment payment) {
		
		if(isPaymentExpired(mpPayment.getStatus(), mpPayment.getDateOfExpiration())) {
			playerPaymentService.delete(payment);
		}
		
		if(isPaymentApproved(mpPayment.getStatus())) {
			accountService.addCoinsTransferable(payment.getPlayerPaymentPK().getPlayerAccountName(), mpPayment.getId().toString(), payment.getTransactionAmount());
		}
		
	}

	private boolean isPaymentApproved(String status) {
		return PaymentStatusEnum.APPROVED.getValue().equals(status);
	}

	private boolean isPaymentExpired(String status, OffsetDateTime dateOfExpiration) {
		OffsetDateTime now = OffsetDateTime.now();	
		return PaymentStatusEnum.PENDING.getValue().equals(status) && dateOfExpiration.isBefore(now);
	}


}
