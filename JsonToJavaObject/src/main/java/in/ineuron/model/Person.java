package in.ineuron.model;

import lombok.Data;

@Data
public class Person {
	private Integer id;
	private String firstName;
	private String lastName;
	private Boolean active;

	// HAS-A property
	private Address address;

	// Array property
	private String[] languages;
}

