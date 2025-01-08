package br.com.mercadopago.integrator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("MyAac X MercadoPago Integrator API")
                .version("1.0")
                .description("API integrator between MyAac and MercadoPago with support for Pix payments."));
    }
}
