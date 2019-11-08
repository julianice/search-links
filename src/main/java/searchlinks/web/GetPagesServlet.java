package searchlinks.web;

import searchlinks.dao.SitesDAO;
import searchlinks.dao.UsersDAO;
import searchlinks.entities.Site;
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
import java.util.List;

@WebServlet(urlPatterns = "/getpages")
public class GetPagesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory factory = StartupListener.getFactory(req.getServletContext());
        EntityManager manager = factory.createEntityManager();
        UsersDAO userDao = new UsersDAO(manager);
        SitesDAO sitesDao = new SitesDAO(manager);

        int userId = (int) req.getSession().getAttribute("userId");

        User found = userDao.findById(userId);
        String domain = req.getParameter("domain");

        Site newSite = new Site(found, domain);
        manager.getTransaction().begin();
        sitesDao.create(newSite);
        manager.getTransaction().commit();

        try {
            List<Site> sites = sitesDao.findByOwner(found);
            req.setAttribute("sites", sites);
            req.getRequestDispatcher("/pages.jsp").forward(req, resp);
        } catch (NoResultException notFound) {
            req.getRequestDispatcher("/").forward(req, resp);
        } finally {
            manager.close();
        }
    }
}
