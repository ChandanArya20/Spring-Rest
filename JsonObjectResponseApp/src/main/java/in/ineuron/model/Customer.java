package in.ineuron.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	Integer id;
	String name;
	String address;
	Integer age;
	String[] teamNames;
	List<String> studies;
	Set<Long> mobo;
	Map<String,Object> ids;
	Company company;
	
}
