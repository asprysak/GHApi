package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnetwork.domain.Repo;
import pl.b2bnetwork.domain.RepoMaker;
import pl.b2bnetwork.service.RepoService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/repos")
@Controller
public class RepoController {

    @Autowired
    private RepoService repoService;

    private RepoMaker repoMaker = new RepoMaker();

    @RequestMapping(value = "/saveRepo", method = RequestMethod.POST)
    public void saveRepo(Model model, @ModelAttribute @Valid Repo repo, BindingResult bind) {
        if (bind.hasErrors()) {
            model.addAttribute("message", "Wrong name");
        } else {
            //repo = repoMaker.makeRepo(repo.);
        }
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
        repoService.updateRepo(repo);
    }
}
