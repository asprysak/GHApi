package pl.b2bnetwork.repository;

import org.springframework.data.repository.CrudRepository;
import pl.b2bnetwork.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
