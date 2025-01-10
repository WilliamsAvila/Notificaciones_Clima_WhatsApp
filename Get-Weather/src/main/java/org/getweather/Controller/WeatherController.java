package org.getweather.Controller;

import org.getweather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/Weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/getWeather/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city)  {

        var findWeather = weatherService.getWeatherCity(city);
        if (findWeather != null) {
            return ResponseEntity.ok(findWeather);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
