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
                Object[] numberCityArray = (Object[]) number;

                String numero = String.valueOf(numberCityArray[0]);
                String ciudad = String.valueOf(numberCityArray[1]);
//                String clima = getWeatherService.getWeather(ciudad);
//                twilioService.enviarMensaje(numero, clima);
                System.out.println(ciudad +" "+ numero);


            }



//            String clima = getWeatherService.getWeather("Madrid");
//            List<Object> numbersPhones = getPhonesService.getAllPhones();
//
//
//            for (String number : numbersPhones) {
//                // Enviar el mensaje por WhatsApp
//                twilioService.enviarMensaje(number, clima);
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
