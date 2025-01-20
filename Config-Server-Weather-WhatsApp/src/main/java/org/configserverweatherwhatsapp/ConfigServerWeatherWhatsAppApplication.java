package org.configserverweatherwhatsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
/* Se debe establecer la anotación @EnableConfigServer.
 * Activa las configuraciones del ConfigServer en la aplicación de Spring Boot.
 */
@EnableConfigServer
public class ConfigServerWeatherWhatsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerWeatherWhatsAppApplication.class, args);
	}

}
