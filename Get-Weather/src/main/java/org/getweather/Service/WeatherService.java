package org.getweather.Service;
import org.springframework.stereotype.Service;

/*
 * Servicio que implementa los otros dos servicios para unificar los metodos y obtener un
 * mensaje personalizado para utilizarlo en un endpoint esto ayuda a la escalabilidad del
 * proyecto
 * */
@Service
public class WeatherService {

    private final JsonToMessageService jsonToMessageService;
    private final GetWeatherApiService getWeatherApiService;

    public WeatherService(JsonToMessageService jsonToMessageService, GetWeatherApiService getWeatherApiService) {
        this.jsonToMessageService = jsonToMessageService;
        this.getWeatherApiService = getWeatherApiService;
    }


    public String getWeatherMessage(String city) {
        String responseBody = getWeatherApiService.getWeatherCity(city);
        if (responseBody.contains("Error")){
            return "Error al obtener el clima: " + responseBody;
        } else {
            return jsonToMessageService.getMessage(responseBody);
        }

    }


}
