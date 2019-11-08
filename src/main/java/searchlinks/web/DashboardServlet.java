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

@WebServlet(urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory factory = StartupListener.getFactory(req.getServletContext());
        EntityManager manager = factory.createEntityManager();
        UsersDAO dao = new UsersDAO(manager);
        //TransactionsDAO tx = new TransactionsDAO(manager);
        try {
            int userId = (int) req.getSession().getAttribute("userId");
            User found = manager.find(User.class, userId);
            //List<Transaction> transactions = tx.findByAccount(found);

            //req.setAttribute("transactions", transactions);

            req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
        } catch (NoResultException notFound) {
            req.getRequestDispatcher("/").forward(req, resp);
        } finally {
            manager.close();
        }
    }
}
