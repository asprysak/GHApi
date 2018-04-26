package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.b2bnetwork.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    boolean existsByLogin(String login);
}
