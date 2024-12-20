package org.whatsapp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {


    @Value("${ACCOUNT_SID}")
    private String accountSid;

    @Value("${TOKEN_WHATSAPP}")
    private String authToken;

    final String fromNumber = "whatsapp:+14155238886";

    public void enviarMensaje(String mensaje) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                new PhoneNumber("whatsapp:+34642318353"),
                new PhoneNumber(fromNumber),
                mensaje
        ).create();

        System.out.println("Mensaje enviado con SID: " + message.getSid());
    }
}
