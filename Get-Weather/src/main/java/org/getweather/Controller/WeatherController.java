package org.getweather.Controller;

import org.getweather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Weather")
public class WeatherController {


    @Autowired
    private WeatherService weatherService;

//    private final WeatherService weatherService;
//
//    public WeatherController(WeatherService weatherService) {
//        this.weatherService = weatherService;
//    }


    @GetMapping("/getWeather/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city)  {

        var findWeather = weatherService.getWeatherCity(city);
        var findMessage = weatherService.getMessage(findWeather);
        if (findMessage != null) {
            return ResponseEntity.ok(findMessage);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
