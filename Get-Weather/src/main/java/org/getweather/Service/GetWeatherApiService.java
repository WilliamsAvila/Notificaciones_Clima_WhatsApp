package org.getweather.Service;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
* Servicio que implementa un metodo que obtiene en JSON toda la información climática
* de una region desde una API gratuita (WeatherAPI) */
@Service
public class GetWeatherApiService {
    private static final String API_KEY = "124f9aa032d44af390e205240241712";
    private static final String BASE_URL = "http://api.weatherapi.com/v1/current.json?key=";

    public String getWeatherCity(String ciudad) {

        try {
            HttpClient cliente = HttpClient.newHttpClient();
            String url = BASE_URL + API_KEY + "&q=" + ciudad;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Error en la solicitud: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener el clima: " + e.getMessage();

        }

    }
}
