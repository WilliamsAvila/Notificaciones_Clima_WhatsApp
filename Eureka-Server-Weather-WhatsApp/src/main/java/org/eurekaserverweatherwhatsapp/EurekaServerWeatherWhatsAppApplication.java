package org.eurekaserverweatherwhatsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// Se debe establecer la anotación @EnableEurekaServer.
// Activa en servicio de Eureka en la aplicación de Spring Boot.
@EnableEurekaServer
public class EurekaServerWeatherWhatsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerWeatherWhatsAppApplication.class, args);
	}

}
