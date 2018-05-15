package pl.b2bnetwork.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.User;
import pl.b2bnetwork.domain.UserMaker;
import pl.b2bnetwork.dto.RepoDto;
import pl.b2bnetwork.dto.UserDto;
import pl.b2bnetwork.dto.UserDtoToUserConverter;
import pl.b2bnetwork.service.GithubService;

import java.util.List;

@RequestMapping("/github")
@Controller
public class GithubController {

    @Autowired
    private GithubService githubService;

    private UserMaker userMaker = new UserMaker();

    private UserDtoToUserConverter userConverter = new UserDtoToUserConverter();

    @RequestMapping(value = "/howManyFollowers")
    public String howManyFollowers(Model model, @ModelAttribute User user) {
        UserDto userDto = userMaker.makeUser(user.getLogin());
        user = userConverter.convert(userDto);
        String stat = Integer.toString(githubService.howManyFollowersThePersonHas(user.getLogin()));
        model.addAttribute("stats", "Followers: " + stat);
        return "howManyFollowers";
    }

/*    @RequestMapping(value = "/howManyRepos")
    public String howManyRepos(Model model, @ModelAttribute User user) {
        UserDto userDto = userMaker.makeUser(user.getLogin());
        user = userConverter.convert(userDto);
        String stat = Integer.toString(githubService.howManyReposThePersonHas(user.getLogin()));
        model.addAttribute("stats", "Repos: " + stat);
        return "howManyRepos";
    }

    @RequestMapping("/howManyDays")
    public String howManyDays(Model model, @ModelAttribute User user) {
        UserDto userDto = userMaker.makeUser(user.getLogin());
        user = userConverter.convert(userDto);
        String stat = githubService.howManyDaysAgoTheAccountWasCreated(user.getLogin());
        model.addAttribute("stats", "Days on Github: " + stat);
        return "howManyDays";
    }*/
/*
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
    }*/
}
