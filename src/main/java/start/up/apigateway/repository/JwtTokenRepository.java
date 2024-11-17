package start.up.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import start.up.apigateway.model.JwtToken;

import java.util.Optional;

public interface JwtTokenRepository extends JpaRepository<JwtToken, Long> {
    @Query(value = "FROM JwtToken jt WHERE jt.token = :token")
    Optional<JwtToken> findByToken(String token);
}
