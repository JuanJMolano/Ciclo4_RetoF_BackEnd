package usa.edu.co.ciclo4_reto2.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import usa.edu.co.ciclo4_reto2.model.Laptop;
import java.util.Optional;

/**
 *
 * @author Juan Molano
 */

public interface LaptopCrudRepository extends MongoRepository<Laptop, Integer> {
    Optional<Laptop> findTopByOrderByIdDesc();
}
