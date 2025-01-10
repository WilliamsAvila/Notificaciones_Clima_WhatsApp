package org.getweather;

import org.getweather.Service.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GetWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetWeatherApplication.class, args);

    }
    }
