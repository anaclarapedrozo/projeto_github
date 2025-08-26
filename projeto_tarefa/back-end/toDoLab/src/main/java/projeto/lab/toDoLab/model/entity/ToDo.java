package projeto.lab.toDoLab.model.entity;


import jakarta.persistence.*;
import projeto.lab.toDoLab.model.entity.enums.Status;

import java.time.LocalDate;

@Entity
@Table(name = "todo_lab_table")
public class ToDo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private LocalDate data;
    private String categories;
    private Status status;
}
