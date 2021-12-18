package usa.edu.co.ciclo4_reto2.repository.crud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import usa.edu.co.ciclo4_reto2.model.Order;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Molano
 */

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);

    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    Optional<Order> findTopByOrderByIdDesc();


}
