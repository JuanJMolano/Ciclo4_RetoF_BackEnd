package usa.edu.co.ciclo4_reto2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.edu.co.ciclo4_reto2.model.User;
import usa.edu.co.ciclo4_reto2.repository.UserRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan Molano
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public boolean existEmail(String email){
        return userRepository.existEmail(email);
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User authenticateUser(String email, String password){
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if(usuario.isEmpty()){
            return new User();
        }
        else{
            return usuario.get();
        }
    }

    public User create(User user) {

        Optional<User> userIdMaximo = userRepository.lastUserId();

        if (user.getId() == null) {

            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }

        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (existEmail(user.getEmail()) == false){
                return userRepository.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public User update(User user){
        if(user.getId() != null){
            Optional<User> userOptional = userRepository.getUser(user.getId());
            if(!userOptional.isEmpty()){
                if(user.getIdentification() != null){
                    userOptional.get().setIdentification(user.getIdentification());
                }
                if(user.getName() != null){
                    userOptional.get().setName(user.getName());
                }
                if(user.getAddress() != null){
                    userOptional.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone() != null){
                    userOptional.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail() != null){
                    userOptional.get().setEmail(user.getEmail());
                }
                if(user.getPassword() != null){
                    userOptional.get().setPassword(user.getPassword());
                }
                if(user.getZone() != null){
                    userOptional.get().setZone(user.getZone());
                }
                if(user.getType() != null) {
                    userOptional.get().setType(user.getType());
                }

                userRepository.update(userOptional.get());
                return userOptional.get();

            } else {
                return user;
            }
        }else {
            return user;
        }
    }

    public boolean delete(int id){
        Optional<User> userOptional = userRepository.getUser(id);
        if(!userOptional.isEmpty()){
            userRepository.delete(userOptional.get());
            return true;
        }
        return false;
    }
}
