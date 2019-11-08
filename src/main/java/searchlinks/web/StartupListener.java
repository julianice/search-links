package searchlinks.web;
import searchlinks.dao.UsersDAO;
import searchlinks.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.NoResultException;
//import javax.persistence.Persistence;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextListener;


@WebListener
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        event.getServletContext().setAttribute("factory", factory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        EntityManagerFactory factory = getFactory(event.getServletContext());
        if (factory != null) {
            factory.close();
        }
    }

    public static EntityManagerFactory getFactory(ServletContext context) {
        return (EntityManagerFactory) context.getAttribute("factory");
    }
}
