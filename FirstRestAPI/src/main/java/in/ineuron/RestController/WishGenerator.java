package in.ineuron.RestController;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishGenerator {

	@GetMapping("/msg")
	public ResponseEntity<String> generateWishMessage(){
		
		LocalDateTime time = LocalDateTime.now();
		
		String body="";
		int hours=time.getHour();
		
		if(hours<12)
			body="Good Morning";
		else if(hours<16)
			body="Good Afternoonn";
		else if(hours<20)
			body="Good Evening";
		else
			body="Good Night";
		
		ResponseEntity<String> entity = new ResponseEntity<>(body,HttpStatus.OK);
		
		return entity;
	}
}
