package in.ineuron.service;

import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.response.CurrencyResponse;

@Service("service")
public class CurrencyService {

	private static final String REST_END_POINT = "http://localhost:9090/Rest-CurrencyConverter_ProviderApp/api/currency/getExchangeCost/from/{/to/{to}";

	public void invokeRestApiSync(String from, String to) {
//		 Sending Synchronous request
		System.out.println("****Synchronous: Restcall started ******");

		WebClient webClient = WebClient.create();
		
		CurrencyResponse response = webClient.get().
											  uri(REST_END_POINT,from,to).
											  retrieve().bodyToMono(CurrencyResponse.class).
											  block();			  		
		
		System.out.println(response);
		System.out.println("****Synchronous: Restcall ended ******");
	}

	public void invokeRestApiASync(String from, String to) {

		// Sending Synchronous request
		System.out.println("****ASynchronous: Restcall started ******");

		WebClient webClient = WebClient.create();
		
		webClient.get().
				  uri(REST_END_POINT,from,to).
				  retrieve().bodyToMono(CurrencyResponse.class).
				  subscribe(CurrencyService::myResponse);			  				
		
		System.out.println("****ASynchronous: Restcall ended ******");
	}

	public static void myResponse(CurrencyResponse response) {
		System.out.println("HI "+response);
		//use repsonse object as per the needs[push to Apache-kafka]
	}

}
