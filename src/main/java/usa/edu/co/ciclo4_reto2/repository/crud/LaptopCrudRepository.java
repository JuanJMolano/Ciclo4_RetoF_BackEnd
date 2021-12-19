package usa.edu.co.ciclo4_reto2.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import usa.edu.co.ciclo4_reto2.model.Laptop;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Molano
 */

public interface LaptopCrudRepository extends MongoRepository<Laptop, Integer> {

    Optional<Laptop> findTopByOrderByIdDesc();

    //Reto 5
    public List<Laptop> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Laptop> findByDescriptionLike(String description);
}
