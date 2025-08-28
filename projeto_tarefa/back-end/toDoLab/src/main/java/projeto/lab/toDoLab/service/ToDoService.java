package projeto.lab.toDoLab.service;


import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lab.toDoLab.dto.ToDoDto;
import projeto.lab.toDoLab.dto.ToDoDtoRecord;
import projeto.lab.toDoLab.model.entity.Categories;
import projeto.lab.toDoLab.model.entity.ToDo;
import projeto.lab.toDoLab.model.enums.Status;
import projeto.lab.toDoLab.repository.CategoriaRepository;
import projeto.lab.toDoLab.repository.ToDoRepository;

import java.util.List;

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
        var toDoBuscado = toDoRepository.findById(id);
        toDoRepository.findAll().forEach(tarefa -> {
            if(!tarefa.getId().equals(toDoBuscado.get().getId())){
                throw new RuntimeException("Não econtramos esse to-do na base de dados");
            }
        });
        toDoRepository.deleteById(id);
    }

//    public void deletar (Long id){
//        var toDoBuscado = toDoRepository.findById(id);
//        toDoRepository.deleteById(id);
//    }


    public void deletarPeloNome(String nome){
        var todoBuscado = toDoRepository.findByNome(nome);

        if(todoBuscado != null) toDoRepository.delete(todoBuscado);

    }



    public void editarTarefa(Long id, ToDoDtoRecord toDoDto){

        ToDo todo = toDoRepository.findById(id).orElse(null);
//        todo.setNome(toDoDto.getNome());
        Categories categories = categoriaRepository.findByName(toDoDto.categories()).orElse(null);
//        todo.setCategories(categories);
//        todo.setData(toDoDto.getData());
//        todo.setStatus(toDoDto.getStatus());
        BeanUtils.copyProperties(toDoDto, todo);
        todo.setCategories(categories);

        toDoRepository.save(todo);

    }


    public List<ToDo> retornarTodDosComId(){
        return toDoRepository.findAll();
    }


//    public void editarTarefa(Long id, ToDoDto toDoDto){
//
//        ToDo todo = toDoRepository.findById(id).orElse(null);
//        if(todo != null){
//            todo.setNome(toDoDto.getNome());
//            Categories categories = categoriaRepository.findByName(toDoDto.getCategories()).orElse(null);
//            if(categories != null){
//                todo.setCategories(categories);
//                todo.setStatus(toDoDto.getStatus());
//                todo.setData(toDoDto.getData());
//                toDoRepository.save(todo);
//            }
//        }
//
//    }














}
