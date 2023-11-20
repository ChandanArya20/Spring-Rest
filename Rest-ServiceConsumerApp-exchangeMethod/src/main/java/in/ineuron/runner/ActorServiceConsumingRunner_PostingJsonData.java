package in.ineuron.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_PostingJsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner_PostingJsonData.run()");
		
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9090/Rest-ServiceProviderApp/api/actor/register";
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String json_body="{\r\n"
				+ "    \"aid\":12,\r\n"
				+ "    \"name\":\"Shivam\",\r\n"
				+ "    \"age\":20,\r\n"
				+ "    \"type\":\"nice\"\r\n"
				+ "}";
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(json_body,headers);
		
		ResponseEntity<String> responseEntity = template.exchange(serviceUrl, HttpMethod.POST, httpEntity, String.class);
		
		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		
		System.out.println("********************************************************");

	}
}
