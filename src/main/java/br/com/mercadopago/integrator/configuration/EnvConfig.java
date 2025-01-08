package br.com.mercadopago.integrator.configuration;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class EnvConfig {
    
    private final Dotenv dotenv = Dotenv.load();

    @PostConstruct
    public void init() {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("DB_DRIVER", dotenv.get("DB_DRIVER"));
        System.setProperty("INTEGRATOR_ACCESS_TOKEN", dotenv.get("INTEGRATOR_ACCESS_TOKEN"));
        System.setProperty("PAYMENT_CRON", dotenv.get("PAYMENT_CRON"));
    }
    
}