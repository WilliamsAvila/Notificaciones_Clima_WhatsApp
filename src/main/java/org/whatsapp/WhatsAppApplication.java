package org.whatsapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.whatsapp.Service.ClimaService;


@SpringBootApplication
@EnableScheduling
public class WhatsAppApplication {
//	/* El ACCOUNT_SID en el numero que proporsiona twilio para utilizar su libreria y
//	enviar mensajes a whatsapp
//	 */
//	public static final String ACCOUNT_SID = System.getenv("ACCOUNT_SID");
//	/* se puede inyectar una variable de entorno (TOKEN_WHATSAPP) con el metodo System.geteven("literalmente como se defina")
//	 */
//	public static final String AUTH_TOKEN = System.getenv("TOKEN_WHATSAPP");

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WhatsAppApplication.class, args);
//
//
//		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//		Runnable task1 = new Runnable() {
//
//			public void run() {
//				try {
//					Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//					// Crear cliente HTTP
//					HttpClient client = HttpClient.newHttpClient();
//
//					// Crear solicitud GET
//					HttpRequest request = HttpRequest.newBuilder()
//							.uri(URI.create("http://api.weatherapi.com/v1/current.json?key=124f9aa032d44af390e205240241712&q=Madrid"))
//							.build();
//
//					// Enviar la solicitud y obtener la respuesta como String
//					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//
//					JSONObject respondJson = new JSONObject(response.body());
//					JSONObject location = respondJson.getJSONObject("location");
//					String name = location.getString("name");
//					String region = location.getString("region");
//					String country = location.getString("country");
//
//					JSONObject current = respondJson.getJSONObject("current");
//					double temp_c = current.getDouble("temp_c");
//
//					String to = "whatsapp:+34642318353";
//					String from = "whatsapp:+14155238886";
//
//					Message message = Message.creator(
//									new PhoneNumber(to),
//									new PhoneNumber(from),
//									"Hola en " + name + " " + " " + country + " hace " + temp_c + " ºC"
//							)
//							.create();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//
//		};
//		scheduler.scheduleAtFixedRate(task1, 0, 30, TimeUnit.SECONDS);
		ClimaService climaService = new ClimaService();
		String mensaje = climaService.obtenerClima("Madrid");
		System.out.println(mensaje);
}
}

