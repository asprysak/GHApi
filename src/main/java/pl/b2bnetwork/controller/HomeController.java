package pl.b2bnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.b2bnetwork.domain.User;

@Controller
public class HomeController {

    @RequestMapping(value={"", "/", "home"})
    public String getHome(Model model) {
        model.addAttribute("user", new User());
        return "userHome";
    }
}
