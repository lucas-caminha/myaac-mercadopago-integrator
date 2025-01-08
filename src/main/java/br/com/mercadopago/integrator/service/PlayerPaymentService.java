package br.com.mercadopago.integrator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadopago.resources.payment.Payment;

import br.com.mercadopago.integrator.entity.PlayerPayment;
import br.com.mercadopago.integrator.entity.PlayerPaymentPK;
import br.com.mercadopago.integrator.repository.PlayerPaymentRepository;
import br.com.mercadopago.integrator.request.CreatePixPaymentRequest;

@Service
public class PlayerPaymentService {
	
	@Autowired
	private PlayerPaymentRepository repository;
	
	private static final String YES = "S";

    public List<PlayerPayment> getAllPayments() {
        return repository.findAll();
    }

    public Optional<PlayerPayment> getPaymentById(String playerAccountName, String idPayment) {
        PlayerPaymentPK paymentId = new PlayerPaymentPK(playerAccountName, idPayment);
        return repository.findById(paymentId);
    }

    public PlayerPayment savePayment(PlayerPayment payment) {
        return repository.save(payment);
    }


	public void savePlayerPayment(CreatePixPaymentRequest pixRequest, Payment payment) {
		
		PlayerPayment playerPayment = new PlayerPayment();
		
		PlayerPaymentPK pk = new PlayerPaymentPK();
		pk.setIdPayment(payment.getId().toString());
		pk.setPlayerAccountName(pixRequest.getPlayerNameAccount());
		
		playerPayment.setPlayerPaymentPK(pk);
		
		playerPayment.setQrCode(payment.getPointOfInteraction().getTransactionData().getQrCode());
		playerPayment.setTransactionAmount(pixRequest.getTransactionAmount());
		playerPayment.setDescription(pixRequest.getDescription());
		playerPayment.setPaymentMethodId(pixRequest.getPaymentMethodId());
		playerPayment.setPayerEmail(pixRequest.getPayerEmail());
		playerPayment.setMercadoPagoStatusPayment(payment.getStatus());
	
		try {
			savePayment(playerPayment);	
		} catch (Exception e) {
			throw new RuntimeException("MyAac savePlayerPayment Error" + e.getMessage());
		}
	}
	
	public List<PlayerPayment> getPlayerPaymentNoPaid() {
		return repository.findByIsPaidIsNull();
	}
	
	
	public void delete(PlayerPayment playerPayment) {
		repository.delete(playerPayment);
	}

	public void updatePaymentStatus(String accountName, String idPayment) {
		repository.updatePaymentStatus(accountName, idPayment, YES, YES);	
	}
}
