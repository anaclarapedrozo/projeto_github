package projeto.lab.toDoLab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.lab.toDoLab.dto.LoginDto;
import projeto.lab.toDoLab.dto.LoginResponseDto;
import projeto.lab.toDoLab.dto.UserRegisterDto;
import projeto.lab.toDoLab.model.entity.User;
import projeto.lab.toDoLab.service.TokenService;
import projeto.lab.toDoLab.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;


    @PostMapping("/cadastrar")
    public ResponseEntity<?> salvar (@RequestBody UserRegisterDto user){
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDto loginDto){

        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User)auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
