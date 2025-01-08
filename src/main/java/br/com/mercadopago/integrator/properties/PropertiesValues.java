package br.com.mercadopago.integrator.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesValues {

	@Value("${integrator.access.token}")
	private String integratorAccessToken;

	public String getIntegratorAccessToken() {
		return integratorAccessToken;
	}

	public void setIntegratorAccessToken(String integratorAccessToken) {
		this.integratorAccessToken = integratorAccessToken;
	}
	
}
