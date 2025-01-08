package br.com.mercadopago.integrator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.mercadopago.integrator.entity.PlayerPayment;
import br.com.mercadopago.integrator.entity.PlayerPaymentPK;

public interface PlayerPaymentRepository extends JpaRepository<PlayerPayment, PlayerPaymentPK> {

	@Modifying
	@Transactional
	@Query("UPDATE MPPLAYERPAYMENT pp SET pp.isPaid = :isPaid, pp.isReceived = :isReceived " +
		       "WHERE pp.playerPaymentPK.playerAccountName = :playerAccountName " +
		       "AND pp.playerPaymentPK.idPayment = :idPayment")
		void updatePaymentStatus(String playerAccountName, String idPayment, String isPaid, String isReceived);
	
	List<PlayerPayment> findByIsPaidIsNull();
	
}
