package com.lgadetsky.patientservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;



@Configuration
public class SwaggerConfig {
	@Bean
    public OpenAPI customOpenApi() {
    	return new OpenAPI()
    			.info(
    				new Info()
    				.title("Patient Micro Service")
    				.version("1.0.0")
    				.contact(
    						new Contact()
    						.email("leonidgadetsky@yandex.ru")
    						.name("Leonid Gadetsky"))
    			);
    }
}
