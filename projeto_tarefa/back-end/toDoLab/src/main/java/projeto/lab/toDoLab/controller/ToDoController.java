package projeto.lab.toDoLab.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.lab.toDoLab.dto.ToDoDto;
import projeto.lab.toDoLab.dto.ToDoDtoRecord;
import projeto.lab.toDoLab.model.entity.Categories;
import projeto.lab.toDoLab.model.entity.ToDo;
import projeto.lab.toDoLab.repository.CategoriaRepository;
import projeto.lab.toDoLab.repository.ToDoRepository;
import projeto.lab.toDoLab.service.ToDoService;


import java.util.List;

@RestController
@RequestMapping("/tarefa")
@CrossOrigin(origins = "*")
public class ToDoController {


    @Autowired
    private ToDoService toDoService;

    @Autowired
    private ToDoRepository toDoRepository;


    @Autowired
    private CategoriaRepository categoriaRepository;


    @PostMapping("/salvar")
    public ResponseEntity<?> criarTarefa(@RequestBody @Valid ToDoDtoRecord toDoDto){

        toDoService.salvar(toDoDto);
        return ResponseEntity.ok(toDoDto);

    }


//    @PutMapping("/{id}")
//    public void editarTarefa(@PathVariable("id") Long id, @RequestBody ToDoDto toDo){
//        toDoService.editarTarefa(id, toDo);
//    }

    @PutMapping("/{id}")
    public void editar(@PathVariable("id") Long id, @RequestBody ToDoDtoRecord toDoDto){
        toDoService.editarTarefa(id, toDoDto);
//        ToDo todo = toDoRepository.findById(id).orElse(null);
//        todo.setNome(toDoDto.getNome());
//        Categories categories = categoriaRepository.findByName(toDoDto.getCategories()).orElse(null);
//        todo.setCategories(categories);
//        todo.setData(toDoDto.getData());
//        todo.setStatus(toDoDto.getStatus());
//        toDoRepository.save(todo);
    }


    @GetMapping
    public List<ToDo> returnAllToDos(){
        return toDoService.retornarTodDosComId();
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){


            toDoService.deletar(id);


    }

//    @DeleteMapping("/{id}")
//    public void deletar(@PathVariable("id") Long id){
//
//        toDoService.deletar(id);
//
//
//    }


    @GetMapping("/buscar")
    public String retornar(){
        return "teste";
    }


//    @DeleteMapping("/{nome}")
//    public void deletar(@PathVariable("nome") String nome){
//        toDoService.deletarPeloNome(nome);
//    }

//    @PostMapping("/teste")
//    public void teste(@RequestBody ToDoDtoTeste toDoDto){
//        System.out.println(toDoDto);
//    }


//    @GetMapping("/concluir")
//    public void marcarComoConcluido(@PathVariable ("id") Long id){
//
//    }



}
