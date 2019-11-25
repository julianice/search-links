package searchlinks.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getpages")
public class GetPagesController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        EntityManagerFactory factory = StartupListener.getFactory(req.getServletContext());
//        EntityManager manager = factory.createEntityManager();
//        UsersDAO userDao = new UsersDAO(manager);
//        SitesDAO sitesDao = new SitesDAO(manager);
//        PagesDAO pagesDAO = new PagesDAO(manager);
//
//        int userId = (int) req.getSession().getAttribute("userId");
//
//        User found = userDao.findById(userId);
//        String domain = req.getParameter("domain");
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
//    }
    }
}
