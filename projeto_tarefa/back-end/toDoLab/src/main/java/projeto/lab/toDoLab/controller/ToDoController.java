package projeto.lab.toDoLab.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.lab.toDoLab.dto.ToDoDto;
import projeto.lab.toDoLab.dto.ToDoRecordDto;
import projeto.lab.toDoLab.model.entity.ToDo;
import projeto.lab.toDoLab.service.ToDoService;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class ToDoController {


    @Autowired
    private ToDoService toDoService;


    @PostMapping
    public ResponseEntity<?> newToDo(@RequestBody @Valid ToDoRecordDto toDoDto){


        try{
            toDoService.salvar(toDoDto);
            return ResponseEntity.ok(toDoDto);
        }catch (RuntimeException erro){
            return ResponseEntity.badRequest().build();
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<?> editarTarefa(@PathVariable("id") Long id,  @RequestBody ToDoRecordDto toDoDto){
        return null;
    }


    @GetMapping
    public List<ToDoDto> returnAllToDos(){
        return toDoService.returnAll();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id){
        try{
            toDoService.deletar(id);
            return ResponseEntity.notFound().build();
        }catch(IllegalArgumentException erro){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/buscar")
    public String retornar(){
        return "teste";
    }


}
