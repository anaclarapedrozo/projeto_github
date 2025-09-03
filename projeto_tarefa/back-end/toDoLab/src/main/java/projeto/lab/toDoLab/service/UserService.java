package projeto.lab.toDoLab.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lab.toDoLab.dto.UserRegisterDto;
import projeto.lab.toDoLab.model.entity.User;
import projeto.lab.toDoLab.repository.UserRepository;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    public void saveUser(UserRegisterDto userRegisterDto){
        User user = new User();
        userRepository.findAll().forEach( usuario -> {

            if(user.equals(usuario)){
                throw new RuntimeException("Usuario já cadatrado");
            }
        });

        BeanUtils.copyProperties(user, userRegisterDto);
        userRepository.save(user);
    }
}
