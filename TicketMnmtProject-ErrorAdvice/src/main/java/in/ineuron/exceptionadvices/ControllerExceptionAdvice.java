package in.ineuron.exceptionadvices;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.TouristNotFoundException;

@RestControllerAdvice
public class ControllerExceptionAdvice {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> touristNotFoundHandler(TouristNotFoundException tx){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),tx.getMessage(),"404-Not-Found");
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
			
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> allExceptionHandler(Exception e){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),e.getMessage(),"some problem occured");
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
}
