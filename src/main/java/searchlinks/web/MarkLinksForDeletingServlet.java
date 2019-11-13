package searchlinks.web;

import searchlinks.dao.LinksDAO;
import searchlinks.dao.PagesDAO;
import searchlinks.dao.SitesDAO;
import searchlinks.entities.Link;
import searchlinks.entities.Page;

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

@WebServlet(urlPatterns = "/markfordelete")
public class MarkLinksForDeletingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory factory = StartupListener.getFactory(req.getServletContext());
        EntityManager manager = factory.createEntityManager();

            //req.setAttribute("linksWillBeDeleted", links1);
            req.getRequestDispatcher("/linkswillbedeleted.jsp").forward(req, resp);

    }
}
