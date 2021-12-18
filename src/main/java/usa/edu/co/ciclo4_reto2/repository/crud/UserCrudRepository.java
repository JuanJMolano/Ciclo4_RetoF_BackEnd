package usa.edu.co.ciclo4_reto2.repository.crud;

import usa.edu.co.ciclo4_reto2.model.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Juan Molano
 */

public interface UserCrudRepository extends MongoRepository<User,Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email,String password);

    Optional<User> findTopByOrderByIdDesc();

    List<User> findByMonthBirthtDay(String month);
}
