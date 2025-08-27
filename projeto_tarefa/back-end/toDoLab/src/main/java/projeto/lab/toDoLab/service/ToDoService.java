package projeto.lab.toDoLab.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lab.toDoLab.dto.ToDoRecordDto;
import projeto.lab.toDoLab.model.entity.ToDo;
import projeto.lab.toDoLab.model.enums.Status;
import projeto.lab.toDoLab.repository.ToDoRepository;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;


    public void salvar(ToDoRecordDto toDoDto){
        ToDo toDo = new ToDo();
        BeanUtils.copyProperties(toDoDto, toDo);
        toDo.setStatus(Status.PENDENTE);
        toDoRepository.save(toDo);
    }


    public List<ToDo> returnAll(){
        List<ToDoRecordDto> lista = toDoRepository.findAll().stream().map(todo -> {
            var toDo = new ToDoRecordDto();
            BeanUtils.copyProperties(todo, toDo);
            return toDo;
        })



    }
}
