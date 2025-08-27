package projeto.lab.toDoLab.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lab.toDoLab.dto.ToDoDto;
import projeto.lab.toDoLab.dto.ToDoRecordDto;
import projeto.lab.toDoLab.model.entity.ToDo;
import projeto.lab.toDoLab.model.enums.Status;
import projeto.lab.toDoLab.repository.ToDoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;


    public void salvar(ToDoRecordDto toDoDto){
        ToDo toDo = new ToDo();
        BeanUtils.copyProperties(toDoDto, toDo);
        toDo.setStatus(Status.PENDENTE);
        toDoRepository.save(toDo);
        System.out.println(toDo);
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


}
