package org.servicewhatsappweather.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageWeatherService {

    @Autowired
    private GetPhonesService getPhonesService;

    @Autowired
    private GetWeatherService getWeatherService;

    @Autowired
    private TwilioService twilioService;


    // Método para enviar el mensaje cada 20 segundos.
    @Scheduled(fixedRate = 20000)
    public void enviarMensajeClima() {
        System.out.println("Tarea ejecutada...");
        try {
            List<Object> listsNumbersCities = getPhonesService.getAllPhones();
            for (Object number : listsNumbersCities) {
                if (number instanceof Map) {
                    Map<String, Object> contacto = (Map<String, Object>) number;

                    Integer phone = (Integer) contacto.get("numberPhone");
                    String city = (String) contacto.get("city");


                    String clima = getWeatherService.getWeather(city);
//                    twilioService.enviarMensaje(String.valueOf(phone), clima);

                    System.out.println(phone +" "+ clima);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
