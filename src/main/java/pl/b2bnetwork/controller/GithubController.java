package pl.b2bnetwork.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.dto.RepoDto;
import pl.b2bnetwork.service.GithubService;

import java.util.List;

@RequestMapping("/github")
@RestController
public class GithubController {

    @Autowired
    private GithubService githubService;

    @RequestMapping("/howManyFollowers")
    public String howManyFollowers(String login) {
        return Integer.toString(githubService.howManyFollowersThePersonHas(login));
    }

    @RequestMapping("/howManyRepos")
    public String howManyRepos(String login) {
        return Integer.toString(githubService.howManyReposThePersonHas(login));
    }

    @RequestMapping("/howManyDays")
    public String howManyDays(String login) {
        return githubService.howManyDaysAgoTheAccountWasCreated(login);
    }

    @RequestMapping("/averageNoOfFollowersOfFollowers")
    public String averageNoOfFollowersOfFollowers(String login) {
        return Double.toString(githubService.averageNoOfFollowersOfFollowers(login));
    }

    @RequestMapping("/averageNoOfFollowersRepos")
    public String averageNoOfFollowersRepos(String login) {
        return Double.toString(githubService.averageNoOfFollowersRepos(login));
    }

    @RequestMapping("/gists")
    public List<Gist> gistsOfAnUser(String login) {
        return githubService.gistsOfAUSer(login);
    }

    @RequestMapping("/gistsWhichDescriptionContainsWord")
    public List<Gist> gistsWhichDescriptionContainsWord(String login, String word) {
        return githubService.gistsWhichDescriptionContainsWord(login, word);
    }

    @RequestMapping("/repos")
    public List<RepoDto> reposOfAUser(String login) {
        return githubService.reposOfAUser(login);
    }

    @RequestMapping("/reposWhichAreForks")
    public List<RepoDto> reposWhichAreForks(String login) {
        return githubService.reposOfAUserWhichAreForks(login);
    }

    @RequestMapping("/reposWrittenInASpecificLanguage")
    public List<RepoDto> reposWrittenMostlyInASpecificLanguage(String login, String lang) {
        return githubService.reposWrittenMostlyInASpecificLanguage(login, lang);
    }
}
