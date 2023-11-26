package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Tourist {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	String city;
	String name;
	String packageType;
	Double budget;
}
