package usa.edu.co.ciclo4_reto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import usa.edu.co.ciclo4_reto2.repository.crud.LaptopCrudRepository;
import usa.edu.co.ciclo4_reto2.repository.crud.OrderCrudRepository;
import usa.edu.co.ciclo4_reto2.repository.crud.UserCrudRepository;

@Component
@SpringBootApplication
public class Ciclo4Reto2Application implements CommandLineRunner {
	@Autowired
	private UserCrudRepository userCrudRepository;

	@Autowired
	private LaptopCrudRepository laptopCrudRepository;

	@Autowired
	private OrderCrudRepository orderCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ciclo4Reto2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();
		laptopCrudRepository.deleteAll();
		orderCrudRepository.deleteAll();
	}
}
