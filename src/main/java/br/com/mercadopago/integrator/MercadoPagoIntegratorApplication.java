package br.com.mercadopago.integrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MercadoPagoIntegratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoPagoIntegratorApplication.class, args);
	}

}
