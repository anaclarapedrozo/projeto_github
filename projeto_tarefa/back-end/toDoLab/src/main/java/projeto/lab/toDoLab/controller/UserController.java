package projeto.lab.toDoLab.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.lab.toDoLab.dto.UserRegisterDto;
import projeto.lab.toDoLab.model.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {


    @PostMapping("/cadastrar")
    public ResponseEntity<?> salvar (@RequestBody UserRegisterDto user){
        return null;
    }
}
