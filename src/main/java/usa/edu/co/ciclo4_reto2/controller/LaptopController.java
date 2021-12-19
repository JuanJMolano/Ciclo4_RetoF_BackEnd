package usa.edu.co.ciclo4_reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.edu.co.ciclo4_reto2.model.Laptop;
import usa.edu.co.ciclo4_reto2.service.LaptopService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Molano
 */

@RestController
@RequestMapping("/api/laptop")
@CrossOrigin("*")

public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/all")
    public List<Laptop> getAllLaptops(){
        return laptopService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Laptop> getLaptop(@PathVariable("id")int id){
        return laptopService.getLaptop(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop laptop){
        return laptopService.create(laptop);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop laptop){
        return laptopService.update(laptop);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return laptopService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<Laptop> productsByPrice(@PathVariable("price") double price){
        return laptopService.laptopsByPrice(price);
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<Laptop> findByDescriptionLike(@PathVariable("description") String description){
        return laptopService.findByDescriptionLike(description);
    }
}
