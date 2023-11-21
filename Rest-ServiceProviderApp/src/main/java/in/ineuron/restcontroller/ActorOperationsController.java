package in.ineuron.restcontroller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Actor;

@RestController
@RequestMapping("/api/actor")
public class ActorOperationsController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> showWishMessage(){
		
		LocalDateTime time = LocalDateTime.now();
		int hours=time.getHour();
		String user = "chandan";
		String body = null;
		
		if (hours < 12)
			body = "Good Morning:: " + user;
		else if (hours < 16)
			body = "Good Afternoon :: " + user;
		else if (hours < 20)
			body = "Good Evening:: " + user;
		else
			body = "Good Night:: " + user;

		return new ResponseEntity<String>(body, HttpStatus.OK);
		
		
	}
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id, @PathVariable String name) {

		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();

		String body = null;
		if (hour < 12)
			body = "Good Morning:: " + name + " Assoaciated id is :: " + id;
		else if (hour < 16)
			body = "Good Afternoon :: " + name + " Assoaciated id is :: " + id;
		else if (hour < 20)
			body = "Good Evening:: " + name + " Assoaciated id is :: " + id;
		else
			body = "Good Night:: " + name + " Assoaciated id is :: " + id;

		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor) {
		return new ResponseEntity<String>("Actor data is :: " + actor.toString(), HttpStatus.CREATED);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Actor> getActor(@PathVariable Integer id) {
		return new ResponseEntity<Actor>(new Actor(id,"Chandan",21,"Nice"),HttpStatus.OK);
	}

	
	

}
