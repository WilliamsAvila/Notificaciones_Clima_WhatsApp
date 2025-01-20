package org.getweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/* Se implementa la anotación @EnableFeignClients para habilitar la creación de clientes
 * y la conexión desde otros micro-servicios
 */
@SpringBootApplication
@EnableFeignClients
public class GetWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetWeatherApplication.class, args);

    }
}
