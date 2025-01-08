package br.com.mercadopago.integrator.service;

public enum PaymentStatusEnum {
	
	PENDING("pending"),
	APPROVED("approved");
	
	private String value;

	PaymentStatusEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
