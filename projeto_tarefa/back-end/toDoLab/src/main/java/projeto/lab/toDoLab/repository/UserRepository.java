package projeto.lab.toDoLab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import projeto.lab.toDoLab.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {


    UserDetails findByUsername(String username);
}
