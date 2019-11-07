package searchlinksTests.dao;

import searchlinks.dao.UsersDAO;
import searchlinksTests.BaseTest;
import searchlinks.entities.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.NoResultException;

import static org.junit.Assert.*;

public class UsersDAOTest extends BaseTest {
    private UsersDAO dao;
    User user;

    @Before
    public void setup() {
        dao = new UsersDAO(manager);
        user = new User("test1", "123");
    }

    @Test
    public void createUser() {
        manager.getTransaction().begin();
        try {
            dao.create(user);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
        assertNotNull(manager.find(User.class, user.getId()));
    }

    @Test
    public void findByLogin() {
        manager.getTransaction().begin();
        try {
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        User found = dao.findByLogin("test1");
        assertNotNull(found);
        assertEquals(user.getId(), found.getId());

        try {
            dao.findByLogin("test3");
            fail("User test3 shouldn't be found");
        } catch (NoResultException expected) {
        }
    }
}