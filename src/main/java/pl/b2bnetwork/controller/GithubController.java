package pl.b2bnetwork.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.b2bnetwork.domain.GithubApiAccess;
import pl.b2bnetwork.domain.User;
import pl.b2bnetwork.dto.UserDto;
import pl.b2bnetwork.dto.UserDtoToUserConverter;
import pl.b2bnetwork.service.GithubService;

@RequestMapping("/github")
@Controller
public class GithubController {

    @Autowired
    private GithubService githubService;

    private GithubApiAccess apiAccess = new GithubApiAccess();

    private UserDtoToUserConverter userConverter = new UserDtoToUserConverter();

    @RequestMapping(value = "/howManyFollowers")
    public String howManyFollowers(Model model, @ModelAttribute User user) {
        UserDto userDto = apiAccess.makeUser(user.getLogin());
        user = userConverter.convert(userDto);
        String stat = Integer.toString(githubService.howManyFollowersThePersonHas(user.getLogin()));
        model.addAttribute("stats", "Followers: " + stat);
        return "howManyFollowers";
    }

    @RequestMapping(value = "/howManyRepos")
    public String howManyRepos(Model model, @ModelAttribute User user) {
        UserDto userDto = apiAccess.makeUser(user.getLogin());
        user = userConverter.convert(userDto);
        String stat = Integer.toString(githubService.howManyReposThePersonHas(user.getLogin()));
        model.addAttribute("stats", "Repos: " + stat);
        return "howManyRepos";
    }

    @RequestMapping("/howManyDays")
    public String howManyDays(Model model, @ModelAttribute User user) {
        UserDto userDto = apiAccess.makeUser(user.getLogin());
        user = userConverter.convert(userDto);
        String stat = githubService.howManyDaysAgoTheAccountWasCreated(user.getLogin());
        model.addAttribute("stats", "Days on Github: " + stat);
        return "howManyDays";
    }

}
