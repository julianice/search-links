package searchlinks.web;

import searchlinks.dao.UsersDAO;
import searchlinks.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        EntityManagerFactory factory = StartupListener.getFactory(req.getServletContext());
        EntityManager manager = factory.createEntityManager();
        UsersDAO dao = new UsersDAO(manager);

        try {
            User found = dao.findByLoginAndPassword(login, password);
            req.getSession().setAttribute("userId", found.getId());
            resp.sendRedirect("/dashboard");
        } catch (NoResultException notFound) {
            try {
                if (dao.findByLogin(login) != null) {
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            } catch (NoResultException notFound2) {
                User newUser = new User(login, password);
                manager.getTransaction().begin();
                dao.create(newUser);
                manager.getTransaction().commit();
                req.getSession().setAttribute("userId", newUser.getId());
                resp.sendRedirect("/dashboard");
            }

        } finally {
            manager.close();
        }
    }

}