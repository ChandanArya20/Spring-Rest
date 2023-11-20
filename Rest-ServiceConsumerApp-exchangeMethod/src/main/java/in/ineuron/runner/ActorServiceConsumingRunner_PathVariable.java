package in.ineuron.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_PathVariable implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_PathVariable.run()");
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9090/Rest-ServiceProviderApp/api/actor/wish/{id}/{name}";
		

		ResponseEntity<String> responseEntity = template.exchange(serviceUrl, HttpMethod.GET, null, String.class,7,"Dhoni");
		
		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");

	}
}
