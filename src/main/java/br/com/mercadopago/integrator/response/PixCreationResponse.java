package br.com.mercadopago.integrator.response;

import java.io.Serializable;

public class PixCreationResponse implements Serializable {
	
	private static final long serialVersionUID = -6210674533852779803L;
	
	private String idPayment;
	private String qrCode;
	
	public String getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	
}
