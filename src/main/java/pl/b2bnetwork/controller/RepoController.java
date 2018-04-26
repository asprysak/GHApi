package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnetwork.domain.Repo;
import pl.b2bnetwork.domain.RepoMaker;
import pl.b2bnetwork.service.RepoService;

import java.util.List;

@RequestMapping("/repos")
@RestController
public class RepoController {

    @Autowired
    private RepoService repoService;

    private RepoMaker repoMaker = new RepoMaker();

    @RequestMapping(value = "/saveRepo", method = RequestMethod.POST)
    public void saveRepo(String login, String repoName) {
        Repo repo = repoMaker.makeRepo(login, repoName);
        repoService.saveRepo(repo);
    }

    @RequestMapping(value = "/deleteRepo", method = RequestMethod.DELETE)
    public void deleteRepo(String login, String repoName) {
        Repo repo = repoMaker.makeRepo(login, repoName);
        repoService.deleteRepo(repo);
    }

    @RequestMapping(value = "/findAllRepos", method = RequestMethod.GET)
    public List<Repo> findAll() {
        return repoService.findAllRepos();
    }

    @RequestMapping(value = "/updateRepo", method = RequestMethod.PUT)
    public void updateRepo(String login, String repoName) {
        Repo repo = repoMaker.makeRepo(login, repoName);
        repoService.saveRepo(repo);
    }
}
