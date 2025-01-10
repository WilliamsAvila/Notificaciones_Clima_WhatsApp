package org.getweather.Service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonToMessageService {

    public String getMessage (String responseBody) {

        try {
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
        }catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener el clima: " + e.getMessage();
        }
    }
}
