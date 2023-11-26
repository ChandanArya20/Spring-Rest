package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMnmtService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	ITouristMnmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		
		String resultMsg = service.registerTourist(tourist);
		return new ResponseEntity<String>(resultMsg, HttpStatus.OK);																													// //																													
	}
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllTourist() {
		
		List<Tourist> list = service.fetchAllTourist();
		return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);	
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findAllTourist(@PathVariable Integer id) {
		
		Tourist tourist = service.fetchTourisById(id);
		return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);		
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
		
		String msg=service.modifyTourist(tourist);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/modifyBudget/{id}/{hike}")
	public ResponseEntity<String> modifyTouristBudgetById( @PathVariable Integer id, @PathVariable Float hike){
		
		String msg=service.updateTouristBudgetById(id, hike);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTouristById(@PathVariable Integer id) {
		
		String msg=service.deleteTouristById(id);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
}













