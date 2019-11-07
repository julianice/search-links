package searchlinksTests.entities;

import org.junit.Assert;
import org.junit.Test;
import searchlinks.entities.User;
import searchlinksTests.BaseTest;

import static org.junit.Assert.assertEquals;

public class UserTest extends BaseTest {

    @Test
    public void createUser() {
        User user = new User(USER_NAME, USER_PASSWD);
        manager.getTransaction().begin();
        try {
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        Assert.assertNotNull(manager.find(User.class, user.getId()));
        Assert.assertTrue(manager.find(User.class, user.getId()).getLogin().equals(USER_NAME));
        Assert.assertTrue(manager.find(User.class, user.getId()).getPassword().equals(USER_PASSWD));
    }

    @Test
    public void queryUser() {
        User user = new User(USER_NAME, USER_PASSWD);
        manager.getTransaction().begin();
        try {
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        User found = manager.createQuery("from User where login = :p", User.class)
                .setParameter("p", USER_NAME)
                .getSingleResult();

        assertEquals(user.getId(), found.getId());
        assertEquals(USER_PASSWD, found.getPassword());
    }
}