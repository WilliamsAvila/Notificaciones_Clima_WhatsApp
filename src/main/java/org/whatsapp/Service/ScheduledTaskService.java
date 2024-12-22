package org.whatsapp.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

    private final ClimaService climaService;
    private final TwilioService twilioService;

    public ScheduledTaskService(ClimaService climaService, TwilioService twilioService) {
        this.climaService = climaService;
        this.twilioService = twilioService;
    }
    @Scheduled(fixedRate = 3000)
    public void enviarMensajeClima() {
        System.out.println("Tarea ejecutada...");
        try {
            // Obtener el clima de la ciudad
            String clima = climaService.obtenerClima("Madrid");

            // Enviar el mensaje por WhatsApp
            twilioService.enviarMensaje(clima);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
