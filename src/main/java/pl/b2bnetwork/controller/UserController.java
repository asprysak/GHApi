package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnetwork.domain.User;
import pl.b2bnetwork.domain.UserMaker;
import pl.b2bnetwork.service.UserService;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private UserMaker userMaker = new UserMaker();

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public void saveUser(String login) {
        User user = userMaker.makeUser(login);
        userService.saveUser(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public void deleteUser(String login) {
        User user = userMaker.makeUser(login);
        userService.deleteUser(user);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(String login) {
        User user = userMaker.makeUser(login);
        userService.updateUser(user);
    }
}
