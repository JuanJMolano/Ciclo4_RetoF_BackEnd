package usa.edu.co.ciclo4_reto2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.co.ciclo4_reto2.repository.crud.LaptopCrudRepository;
import usa.edu.co.ciclo4_reto2.model.Laptop;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Molano
 */

@Repository
public class LaptopRepository {
    @Autowired
    private LaptopCrudRepository laptopCrudRepository;

    public List<Laptop> getAll(){return laptopCrudRepository.findAll();}

    public Optional<Laptop> getLaptop(int id){return laptopCrudRepository.findById(id);}

    public Laptop create(Laptop laptop){return laptopCrudRepository.save(laptop);}

    public void update(Laptop laptop){laptopCrudRepository.save(laptop);}

    public void delete(Laptop laptop){laptopCrudRepository.delete(laptop);}

    public Optional<Laptop> lastUserId(){return laptopCrudRepository.findTopByOrderByIdDesc();}

    public List<Laptop> laptopsByPrice(double precio) {
        return laptopCrudRepository.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Laptop> findByDescriptionLike(String description) {return laptopCrudRepository.findByDescriptionLike(description);}
}
