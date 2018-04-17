package pl.b2bnetwork.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.Repo;
import pl.b2bnetwork.service.GithubService;

import java.util.List;

@RestController
@RequestMapping("/github")
public class GithubController {

    @Autowired
    private GithubService githubService;

    @RequestMapping("/howManyFollowers")
    public String howManyFollowers(@RequestParam String login) {
        return Integer.toString(githubService.howManyFollowersThePersonHas(login));
    }

    @RequestMapping("/howManyRepos")
    public String howManyRepos(@RequestParam String login) {
        return Integer.toString(githubService.howManyReposThePersonHas(login));
    }

    @RequestMapping("/howManyDays")
    public String howManyDays(@RequestParam String login) {
        return githubService.howManyDaysAgoTheAccountWasCreated(login);
    }

    @RequestMapping("/averageNoOfFollowersOfFollowers")
    public String averageNoOfFollowersOfFollowers(@RequestParam String login) {
        return Double.toString(githubService.averageNoOfFollowersOfFollowers(login));
    }

    @RequestMapping("/averageNoOfFollowersRepos")
    public String averageNoOfFollowersRepos(@RequestParam String login) {
        return Double.toString(githubService.averageNoOfFollowersRepos(login));
    }

    @RequestMapping("/gists")
    public List<Gist> gistsOfAnUser(@RequestParam String login) {
        return githubService.gistsOfAUSer(login);
    }

    @RequestMapping("/gistsWhichDescriptionContainsWord")
    public List<Gist> gistsWhichDescriptionContainsWord(@RequestParam String login, String word) {
        return githubService.gistsWhichDescriptionContainsWord(login, word);
    }

    @RequestMapping("/repos")
    public List<Repo> reposOfAUser(@RequestParam String login) {
        return githubService.reposOfAUser(login);
    }

    @RequestMapping("/reposWhichAreForks")
    public List<Repo> reposWhichAreForks(@RequestParam String login) {
        return githubService.reposOfAUserWhichAreForks(login);
    }

    @RequestMapping("/reposWrittenInASpecificLanguage")
    public List<Repo> reposWrittenMostlyInASpecificLanguage(@RequestParam String login, String language) {
        return githubService.reposWrittenMostlyInASpecificLanguage(login, language);
    }
}
