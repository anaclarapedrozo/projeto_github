package projeto.lab.toDoLab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.lab.toDoLab.dto.ToDoDto;
import projeto.lab.toDoLab.service.ToDoService;

@RestController
@RequestMapping("/tarefa")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;


    @PostMapping
    public ResponseEntity<?> newToDo(@RequestBody ToDoDto toDoDto){
        return  null;
    }


}
