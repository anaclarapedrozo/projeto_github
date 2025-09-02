package projeto.lab.toDoLab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.lab.toDoLab.model.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
