package searchlinks.web;

import searchlinks.dao.LinksDAO;
import searchlinks.dao.PagesDAO;
import searchlinks.dao.SitesDAO;
import searchlinks.dao.UsersDAO;
import searchlinks.entities.Link;
import searchlinks.entities.Page;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/getlinks")
public class GetLinksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory factory = StartupListener.getFactory(req.getServletContext());
        EntityManager manager = factory.createEntityManager();
        //UsersDAO userDao = new UsersDAO(manager);
        SitesDAO sitesDao = new SitesDAO(manager);
        PagesDAO pagesDAO = new PagesDAO(manager);
        LinksDAO linksDAO = new LinksDAO(manager);
        String domain = (String) req.getSession().getAttribute("domain");

        List<Page> pages = pagesDAO.findPagesForSite(sitesDao.findByDomain(domain));

        List<Link> allLinks = new ArrayList<>();

        for (Page pp: pages) {
            String path = pp.getPath();
            List<Link> links = pp.getLinks(path);
            allLinks.addAll(links);
        }
        try {
            manager.getTransaction().begin();
            for (Link link : allLinks) {
                linksDAO.create(link);
            }
            manager.getTransaction().commit();

            req.setAttribute("links", allLinks);
            req.getRequestDispatcher("/links.jsp").forward(req, resp);
        } catch (NoResultException notFound) {
            req.getRequestDispatcher("/").forward(req, resp);
        } finally {
            manager.close();
        }
    }
}
