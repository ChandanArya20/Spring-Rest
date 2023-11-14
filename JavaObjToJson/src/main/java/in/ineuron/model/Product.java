package in.ineuron.model;

import lombok.Data;

@Data
public class Product 
{
    Integer pid;
    String pName;
    Integer price;
    String[] type;
 
}
