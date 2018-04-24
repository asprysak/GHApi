package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.b2bnetwork.domain.User;
import pl.b2bnetwork.domain.UserMaker;
import pl.b2bnetwork.service.UserService;

import javax.validation.Valid;

@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private UserMaker userMaker = new UserMaker();

    @RequestMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @RequestMapping("/saveUser")
    public String saveUser(Model model, @ModelAttribute @Valid User user, BindingResult bind) {
        if (bind.hasErrors()) {   //to do
            model.addAttribute("message", "Size must be over 1"); //todo
            return "home";
        } else {
            user = userMaker.makeUser(user.getLogin());
            userService.saveUser(user);
            model.addAttribute("users", userService.findAllUsers());
            model.addAttribute("message", "User added: " + user.getLogin());
            return "home";
        }
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Model model, User user) {
        user.setIdDb(user.getIdDb());
        user.setLogin(user.getLogin());
        userService.deleteUser(user);
        model.addAttribute("users", userService.findAllUsers());
        return "home";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String findAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "home";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(String login) {
        User user = userMaker.makeUser(login);
        userService.updateUser(user);
    }
}
