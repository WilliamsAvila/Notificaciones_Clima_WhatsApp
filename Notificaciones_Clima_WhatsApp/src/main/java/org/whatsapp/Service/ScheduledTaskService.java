package org.whatsapp.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
/* El servicio ScheduledTaskService se inyecta los servicios WeatherService y
* TwilioService para enviar el mensaje del clima con el @Scheduled cada 10 segundos,
* esto último se puede configurar en el intervalo de tiempo que se quiera enviar
* el mensaje.   */
@Service
public class ScheduledTaskService {

    private final WeatherService weatherService;
    private final TwilioService twilioService;

    public ScheduledTaskService(WeatherService weatherService, TwilioService twilioService) {
        this.weatherService = weatherService;
        this.twilioService = twilioService;
    }


    // Método para enviar el mensaje cada 10 segundos.
    @Scheduled(fixedRate = 10000)
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
