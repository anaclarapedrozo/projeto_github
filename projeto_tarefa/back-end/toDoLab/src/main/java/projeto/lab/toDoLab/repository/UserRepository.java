package projeto.lab.toDoLab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.lab.toDoLab.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
