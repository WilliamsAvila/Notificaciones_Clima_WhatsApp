package org.getweather.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    private static final String API_KEY = "124f9aa032d44af390e205240241712";
    private static final String BASE_URL = "http://api.weatherapi.com/v1/current.json?key=";

    public String getWeatherCity (String ciudad) throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        String url = BASE_URL + API_KEY + "&q=" + ciudad;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new IOException("Error en la solicitud: " + response.statusCode());
        }
    }


}
