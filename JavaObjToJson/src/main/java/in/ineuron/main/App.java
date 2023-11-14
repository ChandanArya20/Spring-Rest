package in.ineuron.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Product;

public class App 
{
    public static void main( String[] args ) {
    	
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
    		
    		Product product = new Product();
    		product.setPid(12);
    		product.setPName("soap");
    		product.setPrice(1200);
    		product.setType(new String[] {"mcr","inh","ytr","try"});
    		
			String jsonString = mapper.writeValueAsString(product);		
			System.out.println(jsonString);
			
			
			mapper.writeValue(new File("myjson.json"), product);
			System.out.println("Data is written to the file successfully...");
			
		} catch (StreamReadException e) {
			
			e.printStackTrace();
		} catch (DatabindException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
        
    }
}
