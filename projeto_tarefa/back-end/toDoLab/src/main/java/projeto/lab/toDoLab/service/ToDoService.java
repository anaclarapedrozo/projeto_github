package projeto.lab.toDoLab.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lab.toDoLab.repository.ToDoRepository;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;
}
