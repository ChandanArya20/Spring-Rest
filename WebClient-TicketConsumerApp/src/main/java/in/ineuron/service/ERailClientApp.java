package in.ineuron.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;

@Service("service")
public class ERailClientApp {

	private static final String REST_END_URL = "http://localhost:9090/Rest-CurrencyConverter_ProviderApp/api/ticket/register";
	
	public void invokeRestApi() {

		WebClient client = WebClient.create();

		PassengerInfo body = new PassengerInfo();
		body.setFirstName("Chandan");
		body.setLastName("Kumar");
		body.setJourneyDate("05/05/2023");
		body.setFrom("Delhi");
		body.setTo("Mumbai");
		body.setTrainNumber("ARk123T");

		Ticket response = client.
						  post().
						  uri(REST_END_URL).
						  accept(MediaType.APPLICATION_JSON).
						  body(BodyInserters.fromValue(body)).retrieve().bodyToMono(Ticket.class).block();
		
		
//		Ticket response = client.post().uri(REST_END_URL).accept(MediaType.APPLICATION_JSON)
//				.body(BodyInserters.fromValue(body)).retrieve().bodyToMono(Ticket.class).block();

		System.out.println(response);

	}
}
