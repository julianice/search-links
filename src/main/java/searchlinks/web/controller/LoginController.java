package searchlinks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import searchlinks.dao.UsersRepository;
import searchlinks.entities.User;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UsersRepository users;

    @GetMapping(path = "/")
    protected String getIndex() {
        return "start_page";
    }

    @PostMapping(path = "/login")
    protected String processLogin(HttpSession session,
                                  @RequestParam String login,
                                  @RequestParam String password,
                                  ModelMap model) {
        User found;
        try {
            found = users.findByLoginAndPassword(login, password);
            session.setAttribute("userId", found.getId());
        } catch (NullPointerException notFound) {
            if (users.findByLogin(login) != null) {
                model.addAttribute("error", "wrong login or password");
                return "start_page";
            } else {
                User newUser = new User(login, password);
                users.save(newUser);
                session.setAttribute("userId", newUser.getId());
            }
        }
        return "setup_sitemap";
    }
//TODO обработка логина
}