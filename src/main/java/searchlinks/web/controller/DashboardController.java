package searchlinks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import searchlinks.dao.PagesDAO;
import searchlinks.dao.SitesDAO;
import searchlinks.dao.UsersDAO;
import searchlinks.entities.Site;
import searchlinks.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class DashboardController {
    @Autowired
    private UsersDAO userDao;

    @Autowired
    private SitesDAO sitesDao;

    @Autowired
    private PagesDAO pagesDAO;


    @PostMapping(path = "/getpages")
    protected void getPages(HttpSession session, ModelMap model) {
//        int userId = (int) session.getAttribute("userId");
//        User found = userDao.findById(userId);
//        //String domain = model.getAttribute("domain");
//        req.getSession().setAttribute("domain", domain);
//
//        Site newSite = new Site(found, domain);
//        manager.getTransaction().begin();
//        sitesDao.create(newSite);
//        manager.getTransaction().commit();
//
//        try {
//            List<Page> pages = newSite.getPages(domain);
//
//            manager.getTransaction().begin();
//            for (Page page : pages) {
//                pagesDAO.create(page);
//            }
//            manager.getTransaction().commit();
//
//            req.setAttribute("pages", pages);
//            req.getRequestDispatcher("/pages.jsp").forward(req, resp);
//        } catch (NoResultException notFound) {
//            req.getRequestDispatcher("/").forward(req, resp);
//        } finally {
//            manager.close();
//        }
    }

    @PostMapping(path = "/getlinks")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //EntityManagerFactory factory = StartupListener.getFactory(req.getServletContext());
        //EntityManager manager = factory.createEntityManager();
//        SitesDAO sitesDao = new SitesDAO(manager);
//        PagesDAO pagesDAO = new PagesDAO(manager);
//        LinksDAO linksDAO = new LinksDAO(manager);
//        String domain = (String) req.getSession().getAttribute("domain");
//
//        List<Page> pages = pagesDAO.findPagesForSite(sitesDao.findByDomain(domain));
//
//        List<Link> allLinks = new ArrayList<>();
//
//        for (Page page: pages) {
//            String path = page.getPath();
//            List<Link> links = page.getLinks(path);
//            allLinks.addAll(links);
//        }
//        try {
//            manager.getTransaction().begin();
//            for (Link link : allLinks) {
//                linksDAO.create(link);
//            }
//            manager.getTransaction().commit();
//
//            req.setAttribute("links", allLinks);
//            req.getRequestDispatcher("/links.jsp").forward(req, resp);
//        } catch (NoResultException notFound) {
//            req.getRequestDispatcher("/").forward(req, resp);
//        } finally {
//            manager.close();
//        }
//    }
    }
}
