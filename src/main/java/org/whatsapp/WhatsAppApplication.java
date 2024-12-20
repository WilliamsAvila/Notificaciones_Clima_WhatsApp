package org.whatsapp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONObject;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class WhatsAppApplication {
	/* El ACCOUNT_SID en el numero que proporsiona twilio para utilizar su libreria y
	enviar mensajes a whatsapp
	 */
	public static final String ACCOUNT_SID = System.getenv("ACCOUNT_SID");
	/* se puede inyectar una variable de entorno (TOKEN_WHATSAPP) con el metodo System.geteven("literalmente como se defina")
	 */
	public static final String AUTH_TOKEN = System.getenv("TOKEN_WHATSAPP");

	public static void main(String[] args) {
		SpringApplication.run(WhatsAppApplication.class, args);


		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Runnable task1 = new Runnable() {

			public void run() {
				try {
					Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

					// Crear cliente HTTP
					HttpClient client = HttpClient.newHttpClient();

					// Crear solicitud GET
					HttpRequest request = HttpRequest.newBuilder()
							.uri(URI.create("http://api.weatherapi.com/v1/current.json?key=124f9aa032d44af390e205240241712&q=Madrid"))
							.build();

					// Enviar la solicitud y obtener la respuesta como String
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());



					JSONObject respondJson = new JSONObject(response.body());
					JSONObject location = respondJson.getJSONObject("location");
					String name = location.getString("name");
					String region = location.getString("region");
					String country = location.getString("country");

					JSONObject current = respondJson.getJSONObject("current");
					double temp_c = current.getDouble("temp_c");

					Message message = Message.creator(
									new PhoneNumber("whatsapp:+34642318353"),
									new PhoneNumber("whatsapp:+14155238886"),
									"Hola en " + name + " " + " " + country + " hace " + temp_c + " ºC"
							)
							.create();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	};
		scheduler.scheduleAtFixedRate(task1,0,30, TimeUnit.SECONDS);
	}
}


//				try {
//			// URL a la que enviamos la solicitud GET
//			URL url = new URL("http://api.weatherapi.com/v1/current.json?key=124f9aa032d44af390e205240241712&q=London&aqi=no");
//
//			// Abrir la conexión con la URL
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			connection.setRequestMethod("GET");  // Método GET para obtener datos
//
//			// Leer la respuesta del servidor
//			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			String line;
//			StringBuilder response = new StringBuilder();
//			while ((line = reader.readLine()) != null) {
//				response.append(line);
//			}
//
//			// Mostrar la respuesta
//			System.out.println("Respuesta del servidor: " + response.toString());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//				Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//		try {
//			// URL a la que enviamos la solicitud GET
//			URL url = new URL("http://api.weatherapi.com/v1/current.json?key=124f9aa032d44af390e205240241712&q=London&aqi=no");
//
//			// Abrir la conexión con la URL
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			connection.setRequestMethod("GET");  // Método GET para obtener datos
//
//			// Leer la respuesta del servidor
//			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			Message message = Message.creator(
//							new PhoneNumber("whatsapp:+34642318353"),
//							new PhoneNumber("whatsapp:+14155238886"),
//							"Hola esto es una prueba"+reader.readLine()
//					)
//					.create();
//		} catch (Exception e) {
//			System.out.println("Mensaje ERROR: " + e.getMessage());
//		}
//			}
//		};
//
//		scheduler.scheduleAtFixedRate(task1,0,5, TimeUnit.SECONDS);

