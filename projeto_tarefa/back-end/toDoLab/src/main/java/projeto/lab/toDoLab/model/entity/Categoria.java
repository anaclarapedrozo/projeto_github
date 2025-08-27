package projeto.lab.toDoLab.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "categoria_tarefa")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
