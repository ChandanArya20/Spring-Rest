package in.ineuron.restcontroller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.response.CurrencyResponse;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConverterApp {

	@GetMapping("/getExchangeCost/from/{from}/to/{to}")
	public ResponseEntity<CurrencyResponse> getCurrencyValue(@PathVariable String from, @PathVariable String to) {

		System.out.println(from);
		System.out.println(to);
		
		CurrencyResponse response = new CurrencyResponse();
		response.setCurrencyId(1);
		response.setCurrencyFrom(from);
		response.setCurrencyTo(to);
		response.setCurrencyValue(82);
		return new ResponseEntity<CurrencyResponse>(response, HttpStatus.OK);
	}
	@GetMapping("/show")
	public ResponseEntity<String> showMessage(){
	
		String msg="Welcome";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	
}

















