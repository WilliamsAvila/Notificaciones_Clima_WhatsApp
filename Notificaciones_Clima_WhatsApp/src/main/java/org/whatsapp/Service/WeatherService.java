package org.whatsapp.Service;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/* Servicio que obtiene la información del clima desde una api pública (weather api)
* y la convierte en un mensaje predeterminado utilizando 2 métodos getWeather y getMessage
* */
@Service
public class WeatherService {

    public String getWeather(String ciudad) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=124f9aa032d44af390e205240241712&q=" + ciudad))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getMessage (String responseBody) {

        // Procesar la respuesta JSON
        JSONObject respondJson = new JSONObject(responseBody);
        JSONObject location = respondJson.getJSONObject("location");
        String name = location.getString("name");
        String region = location.getString("region");
        String country = location.getString("country");

        JSONObject current = respondJson.getJSONObject("current");
        double temp_c = current.getDouble("temp_c");

         return String.format("Hola en %s, %s, %s, hace %.1f ºC", name, region, country, temp_c);
//        return "Hola en " + name + ", " + region + ", " + country + " hace " + temp_c + " ºC";
    }

}
