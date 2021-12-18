package usa.edu.co.ciclo4_reto2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Juan Molano
 */

@Document(collection = "laptops")
@Data
@NoArgsConstructor
@AllArgsConstructor

/*Colección Laptop*/
public class Laptop {
    @Id
    private Integer id;
    private String brand;
    private String model;
    private String procesor;
    private String os;
    private String description;
    private String memory;
    private String hardDrive;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;
}
