package org.getweather.Service;
import org.springframework.stereotype.Service;

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
        }
        return jsonToMessageService.getMessage(responseBody);
    }


}
