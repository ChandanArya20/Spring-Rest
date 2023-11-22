package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;


@RestController
@RequestMapping("/api/ticket")
public class TicketBookingRestController {

	@PostMapping("/register")
	public ResponseEntity<Ticket> bookTicket(@RequestBody PassengerInfo passenger) {

		Ticket ticket = new Ticket();
		ticket.setTicketId("LBS18274");
		ticket.setFrom(passenger.getFrom());
		ticket.setTo(passenger.getTo());
		ticket.setJourneyDate(passenger.getJourneyDate());
		ticket.setPassengerName(passenger.getFirstName() + " " + passenger.getLastName());
		ticket.setTicketPrice(3456.5);
		ticket.setTicketStatus("booked");
		ticket.setTrainNumber(passenger.getTrainNumber());
		
		System.out.println(passenger);

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

	}
	
	@GetMapping("/test")
	public ResponseEntity<String> showMessage(){
		String msg="welcom";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
