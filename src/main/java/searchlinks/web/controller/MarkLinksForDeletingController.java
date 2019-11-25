package searchlinks.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/markfordelete")
public class MarkLinksForDeletingController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //EntityManagerFactory factory = StartupListener.getFactory(req.getServletContext());
        //EntityManager manager = factory.createEntityManager();
//        System.out.println(req.getAttribute("type"));
//        System.out.println(req.getSession().getAttribute("type"));
//        req.getRequestDispatcher("/linkswillbedeleted.jsp").forward(req, resp);

    }
}
