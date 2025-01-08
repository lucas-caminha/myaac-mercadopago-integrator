package br.com.mercadopago.integrator.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "MPPLAYERPAYMENT")
public class PlayerPayment {

    @EmbeddedId
    private PlayerPaymentPK playerPaymentPK;
	private String qrCode;
	
	private Double transactionAmount;
	private String description;
	private String paymentMethodId;
	private String payerEmail;
	
	private String mercadoPagoStatusPayment;
	private String isPaid;
	private String isReceived;
	
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getPayerEmail() {
		return payerEmail;
	}
	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}
	public String getMercadoPagoStatusPayment() {
		return mercadoPagoStatusPayment;
	}
	public void setMercadoPagoStatusPayment(String mercadoPagoStatusPayment) {
		this.mercadoPagoStatusPayment = mercadoPagoStatusPayment;
	}
	public String getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}
	public String getIsReceived() {
		return isReceived;
	}
	public void setIsReceived(String isReceived) {
		this.isReceived = isReceived;
	}
	public PlayerPaymentPK getPlayerPaymentPK() {
		return playerPaymentPK;
	}
	public void setPlayerPaymentPK(PlayerPaymentPK playerPaymentPK) {
		this.playerPaymentPK = playerPaymentPK;
	}
	
}
