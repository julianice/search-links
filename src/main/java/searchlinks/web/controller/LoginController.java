package searchlinks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import searchlinks.dao.UsersDAO;
import searchlinks.entities.User;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UsersDAO usersDAO;

    @PostMapping(path = "/login")
    protected String processLogin(HttpSession session,
                                  @RequestParam String login,
                                  @RequestParam String password,
                                  ModelMap model) {

        try {
            User found = usersDAO.findByLoginAndPassword(login, password);
            session.setAttribute("userId", found.getId());
            //req.getSession().setAttribute("userId", found.getId());
            //resp.sendRedirect("/dashboard");
            return "redirect:/dashboard";

        } catch (NoResultException notFound) {
            try {
                if (usersDAO.findByLogin(login) != null) {
                    //req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            } catch (NoResultException notFound2) {
                User newUser = new User(login, password);
                usersDAO.create(newUser);
                //req.getSession().setAttribute("userId", newUser.getId());
                return "redirect:/dashboard";
            }
        }
        return "dashboard";
    }
}