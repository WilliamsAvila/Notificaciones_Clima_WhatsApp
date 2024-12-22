package org.whatsapp.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/* Servicio que */
@Service
public class ScheduledTaskService {

    private final WeatherService weatherService;
    private final TwilioService twilioService;

    public ScheduledTaskService(WeatherService weatherService, TwilioService twilioService) {
        this.weatherService = weatherService;
        this.twilioService = twilioService;
    }
    @Scheduled(fixedRate = 3000)
    public void enviarMensajeClima() {
        System.out.println("Tarea ejecutada...");
        try {
            // Obtener el clima de la ciudad
            String clima = weatherService.getWeather("Madrid");
            String Mensaje = weatherService.getMessage(clima);

            // Enviar el mensaje por WhatsApp
            twilioService.enviarMensaje(Mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
