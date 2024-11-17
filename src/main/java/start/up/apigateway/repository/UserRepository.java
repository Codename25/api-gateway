package start.up.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import start.up.apigateway.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
