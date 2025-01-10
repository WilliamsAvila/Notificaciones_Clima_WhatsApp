package org.getweather.Service;
import org.json.JSONObject;
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
