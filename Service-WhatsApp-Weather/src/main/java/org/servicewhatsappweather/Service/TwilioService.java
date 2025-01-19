package org.servicewhatsappweather.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/* Servicio que conecta con la plataforma Twilio
 * Para esto deber crear una cuanta gratuita con Twilio
 * y obtener un ACCOUNT_SID Y TOKEN
* */
@Service
public class TwilioService {

    //Dato suministrado por la cuenta de Twilio
    @Value("${ACCOUNT_SID}")
    private String accountSid;

    //Dato suministrado por la cuenta de Twilio
    @Value("${TOKEN_WHATSAPP}")
    private String authToken;

    // Número de Whatsapp que te proporsiona Twilio para enviar cualquier mensaje gratuito
    final String fromNumber = "whatsapp:+14155238886";


    /* Método que recibe un mensaje, inicia la configuración de Twilio
    * con Twilio.init
    * Luego se crea una instancia de Message y se llama al método creator
    * y se le pasa los siguientes parámetros,
    * 1ero el número de whatsapp que se quiere enviar el mensaje (new PhoneNumber("whatsapp:+34642318353")
    * 2do el número de whatsapp que te proporciona Twilio que donde se enviara el mensaje (PhoneNumber(fromNumber)
    * 3ro el mensaje (mensaje)
    * */
    public void enviarMensaje(String number, String clima) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                new PhoneNumber("whatsapp:+34"+number),
                new PhoneNumber(fromNumber),
                clima
        ).create();
    }
}
