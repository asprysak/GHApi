package pl.b2bnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.b2bnetwork.domain.Repo;
import pl.b2bnetwork.repository.RepoRepository;

import java.util.List;

@Service
public class RepoServiceImpl implements RepoService {

    @Autowired
    private RepoRepository repoRepository;

    @Override
    public void saveRepo(Repo repo) {

        Repo repoFromDb = repoRepository.findByFullName(repo.getFullName());
        if(repoFromDb == null) {
            repoRepository.save(repo);
        }
    }

    @Override
    public void deleteRepo(Repo repo) {
        repoRepository.delete(repo);
    }

    @Override
    public List<Repo> findAllRepos() {
        return repoRepository.findAll();
    }

    @Override
    public void updateRepo(Repo repo) {

        Repo repoFromDb = repoRepository.findByFullName(repo.getFullName());
        if(repoFromDb != null) {
            Long idDb = repoFromDb.getIdDb();
            repo.setIdDb(idDb);
            repoRepository.save(repo);
        }
    }
}
