package org.servicewhatsappweather.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageWeatherService {

    @Autowired
    private GetPhonesService getPhonesService;

    @Autowired
    private GetWeatherService getWeatherService;

    @Autowired
    private TwilioService twilioService;


    // Método para enviar el mensaje cada 3 segundos.
    @Scheduled(fixedRate = 10000)
    public void enviarMensajeClima() {
        System.out.println("Tarea ejecutada...");
        try {
            // Obtener el clima de la ciudad
//            String clima = weatherService.getWeather("Madrid");
            String clima = getWeatherService.getWeather("Madrid");
//            String Mensaje = weatherService.getMessage(clima);


            // Enviar el mensaje por WhatsApp
            twilioService.enviarMensaje(clima);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
