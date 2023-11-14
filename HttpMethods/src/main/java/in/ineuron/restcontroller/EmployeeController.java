package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping("details")
	public String getEmployee(@RequestParam Integer id, @RequestParam String name) {
		if(id==18 && "kohli".equalsIgnoreCase(name))
			return "RCB";
			
		else if(id==7 && "dhoni".equalsIgnoreCase(name)) {
			return "CSK";
		}else
			return "Other team";
		
		
	}
}
