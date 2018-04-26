package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.b2bnetwork.domain.Repo;

public interface RepoRepository extends JpaRepository<Repo, Long> {

    Repo findByFullName(String fullName);
    boolean existsByFullName(String fullName);

}
