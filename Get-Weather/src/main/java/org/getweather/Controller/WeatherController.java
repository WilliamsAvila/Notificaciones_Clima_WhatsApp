package org.getweather.Controller;

import org.getweather.Service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.web.servlet.function.ServerResponse.notFound;

/* Este controlador se utiliza pra la comprobación de la obtención del clima, ádemas que habilita
 * Los end-point para la comunicación entre micro-servicios
 */
@RestController
@RequestMapping("/Weather")
public class WeatherController {


    /*
    * Si colocamos el @Autowired no es necesario colocar final en la inyección de la clase
    * Y ádemas no es necesario crear un constructor, pero tendríamos warnings en la parte
    * derecha superior */
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/getWeather/{city}")
    public String getWeather(@PathVariable String city)  {

        String findWeatherMessage = weatherService.getWeatherMessage(city);
        return Objects.requireNonNullElse(findWeatherMessage, "Not Found");

    }
}
