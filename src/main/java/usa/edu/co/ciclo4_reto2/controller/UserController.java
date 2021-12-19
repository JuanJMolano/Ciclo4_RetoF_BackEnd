package usa.edu.co.ciclo4_reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.edu.co.ciclo4_reto2.model.User;
import usa.edu.co.ciclo4_reto2.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Molano
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable("id")int id){
        return userService.getUser(id);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return userService.existEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){return userService.authenticateUser(email, password);}

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }

    @GetMapping("/birthday/{month}")
    public List<User> listBirthtDayMonth(@PathVariable("month") String month){return userService.listBirthtDayMonth(month);}
}
