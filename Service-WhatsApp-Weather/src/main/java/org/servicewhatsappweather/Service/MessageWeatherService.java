package org.servicewhatsappweather.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

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
            String clima = getWeatherService.getWeather("Madrid");
            List<String> numbersPhones = getPhonesService.getAllPhones();


            for (String number : numbersPhones) {
                // Enviar el mensaje por WhatsApp
                twilioService.enviarMensaje(number, clima);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
