package in.ineuron.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Customer;
import in.ineuron.model.Person;

public class App 
{
    public static void main( String[] args ) {
    	
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
    		
			Customer customer = mapper.readValue(new File("C:\\Users\\Chandan\\Spring\\Spring-Rest\\JsonToJavaObject\\src\\main\\java\\in\\ineuron\\data\\sample-lite.json"), Customer.class);
			Person person = mapper.readValue(new File("C:\\Users\\Chandan\\Spring\\Spring-Rest\\JsonToJavaObject\\src\\main\\java\\in\\ineuron\\data\\sample-full.json"), Person.class);
			
			System.out.println(customer);
			System.out.println(person);
			
		
			
		} catch (StreamReadException e) {
			
			e.printStackTrace();
		} catch (DatabindException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
        
    }
}
