package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.GithubApiAccess;
import pl.b2bnetwork.dto.RepoDto;
import pl.b2bnetwork.dto.UserDtoToUserConverter;
import pl.b2bnetwork.service.GithubService;

import java.util.List;

@RequestMapping("/rest")
@RestController
public class GithubRestController {

    @Autowired
    private GithubService githubService;

    private GithubApiAccess apiAccess = new GithubApiAccess();

    private UserDtoToUserConverter userConverter = new UserDtoToUserConverter();


    @GetMapping("/averageNoOfFollowersOfFollowers")
    public String averageNoOfFollowersOfFollowers(String login) {
        return Double.toString(githubService.averageNoOfFollowersOfFollowers(login));
    }

    @GetMapping("/averageNoOfFollowersRepos")
    public String averageNoOfFollowersRepos(String login) {
        return Double.toString(githubService.averageNoOfFollowersRepos(login));
    }

    @GetMapping("/gists")
    public List<Gist> gistsOfAnUser(String login) {
        return githubService.gistsOfAUSer(login);
    }

    @GetMapping("/gistsWhichDescriptionContainsWord")
    public List<Gist> gistsWhichDescriptionContainsWord(String login, String word) {
        return githubService.gistsWhichDescriptionContainsWord(login, word);
    }

    @GetMapping("/repos")
    public List<RepoDto> reposOfAUser(String login) {
        return githubService.reposOfAUser(login);
    }

    @GetMapping("/reposWhichAreForks")
    public List<RepoDto> reposWhichAreForks(String login) {
        return githubService.reposOfAUserWhichAreForks(login);
    }

    @GetMapping("/reposWrittenInASpecificLanguage")
    public List<RepoDto> reposWrittenMostlyInASpecificLanguage(String login, String lang) {
        return githubService.reposWrittenMostlyInASpecificLanguage(login, lang);
    }
}
