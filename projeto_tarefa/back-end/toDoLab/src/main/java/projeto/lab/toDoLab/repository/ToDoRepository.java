package projeto.lab.toDoLab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projeto.lab.toDoLab.dto.ToDoDto;
import projeto.lab.toDoLab.model.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    ToDo findByNomeAndCategories(String nome, String categories);



}
