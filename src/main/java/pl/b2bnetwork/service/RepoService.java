package pl.b2bnetwork.service;

import pl.b2bnetwork.domain.Repo;

import java.util.List;

public interface RepoService {
    void saveRepo(Repo repo);

    void deleteRepo(Repo repo);

    List<Repo> findAllRepos();

    void updateRepo(Repo repo);
}
