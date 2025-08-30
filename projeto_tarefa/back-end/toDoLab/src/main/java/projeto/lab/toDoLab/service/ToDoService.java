package projeto.lab.toDoLab.service;


import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lab.toDoLab.dto.ToDoDto;
import projeto.lab.toDoLab.dto.ToDoDtoRecord;
import projeto.lab.toDoLab.dto.ToDoRequestDto;
import projeto.lab.toDoLab.model.entity.Categories;
import projeto.lab.toDoLab.model.entity.ToDo;
import projeto.lab.toDoLab.model.enums.Status;
import projeto.lab.toDoLab.repository.CategoriaRepository;
import projeto.lab.toDoLab.repository.ToDoRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    public void salvar(ToDoDtoRecord toDoDto){

        ToDo toDo = new ToDo();
        BeanUtils.copyProperties(toDoDto, toDo);
        toDo.setStatus(Status.PENDENTE);

        Categories categoria = categoriaRepository.findByName(toDoDto.categories()).orElse(null);
        if(categoria != null) toDo.setCategories(categoria);
        else throw new RuntimeException("Categoria não encontrada");
        toDoRepository.save(toDo);
    }


    public List<ToDoDto> returnAll(){
        return toDoRepository.findAll().stream().map(todo -> {
            var toDo = new ToDoDto();
            BeanUtils.copyProperties(todo, toDo);
            return toDo;
        }).toList();

    }


    public void deletar (Long id){
        ToDo toDoBuscado = toDoRepository.findById(id).orElse(null);
        if (toDoBuscado != null){
            toDoRepository.delete(toDoBuscado);
        }

//        toDoRepository.findAll().forEach(tarefa -> {
//            if(!tarefa.equals(id)){
//                throw new RuntimeException("Não econtramos esse to-do na base de dados");
//            }
//            toDoRepository.deleteById(id);
//        });

    }

//    public void deletar (Long id){
//        var toDoBuscado = toDoRepository.findById(id);
//        toDoRepository.deleteById(id);
//    }


    public void deletarPeloNome(String nome){
        var todoBuscado = toDoRepository.findByNome(nome);

        if(todoBuscado != null) toDoRepository.delete(todoBuscado);

    }



    public void editarTarefa(Long id, ToDoRequestDto toDoDto){

        ToDo todo = toDoRepository.findById(id).orElse(null);
        if(todo == null) throw new IllegalArgumentException("To-do Inexistente");
        Categories categories = categoriaRepository.findByName(toDoDto.categories()).orElse(null);
        BeanUtils.copyProperties(toDoDto, todo);
        todo.setCategories(categories);

        toDoRepository.save(todo);

    }


    public List<ToDo> retornarTodDosComId(){
        return toDoRepository.findAll();
    }


















}
