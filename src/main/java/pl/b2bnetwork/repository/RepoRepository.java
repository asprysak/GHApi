package pl.b2bnetwork.repository;

import org.springframework.data.repository.CrudRepository;
import pl.b2bnetwork.domain.Repo;

public interface RepoRepository extends CrudRepository<Repo, Long> {

}
