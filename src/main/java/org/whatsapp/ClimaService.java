package org.whatsapp;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class ClimaService {

    public String obtenerClima(String ciudad) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=124f9aa032d44af390e205240241712&q=" + ciudad))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Procesar la respuesta JSON
        JSONObject respondJson = new JSONObject(response.body());
        JSONObject location = respondJson.getJSONObject("location");
        String name = location.getString("name");
        String region = location.getString("region");
        String country = location.getString("country");

        JSONObject current = respondJson.getJSONObject("current");
        double temp_c = current.getDouble("temp_c");

        return "Hola en " + name + ", " + region + ", " + country + " hace " + temp_c + " ºC";
    }
}
