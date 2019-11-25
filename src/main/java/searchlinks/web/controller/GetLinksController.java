package searchlinks.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getlinks")
public class GetLinksController extends HttpServlet {

    @Override
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
