package in.ineuron.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Company;
import in.ineuron.model.Customer;
import in.ineuron.model.Person;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@GetMapping("/report/{id}")
	public ResponseEntity<Customer> showAllCustomer(@PathVariable Integer id){
		
		System.out.println("Data for the given id : "+id);
		Customer customer=new Customer();
		
		customer.setId(id);
		customer.setName("chandan");
		customer.setAddress("Bettiah");
		customer.setAge(20);
		customer.setTeamNames(new String[] {"RCB","MI","CSK","GT"});
		customer.setStudies(List.of("10th","12th","BCA"));
		customer.setMobo(Set.of(9905669732L,8757572723L,9127735469L));
		customer.setIds(Map.of("adhar",361294376072L,"pan","PQZX12389L","account",35782949957L));
		
		customer.setCompany(new Company("MI","IPL","Mumbai",11));
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(	@RequestBody Customer customer){
		
		System.out.println(customer);
		
		Integer id=	12;			//customer.getId();
		String body="Customer registered with id "+id;
		
		return new ResponseEntity<String>(body,HttpStatus.OK);
			
	}
	@PostMapping("/test")
	public ResponseEntity<String> savePerson(@RequestBody Person person){
		
		System.out.println(person);
		
		String name=person.getName();
		String body="Customer registered with name "+name;
		
		return new ResponseEntity<String>(body,HttpStatus.OK);
		
	}
	
}
