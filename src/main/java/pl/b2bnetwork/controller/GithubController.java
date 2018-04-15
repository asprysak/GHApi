package pl.b2bnetwork.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnetwork.service.GithubService;

@RestController
@RequestMapping("/github")
public class GithubController {

    @Autowired
    private GithubService githubService;

    @RequestMapping("/howManyFollowers")
    public String result(@RequestParam("name") String name) {
        return githubService.howManyFollowersThePersonHas(name);
    }
}
