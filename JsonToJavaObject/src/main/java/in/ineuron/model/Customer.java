package in.ineuron.model;

import lombok.Data;

@Data
public class Customer 
{
    Integer id;
    String firstName;
    String lastName;
    boolean active;
}
