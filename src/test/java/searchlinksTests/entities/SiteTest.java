package searchlinksTests.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import searchlinks.entities.Site;
import searchlinks.entities.User;
import searchlinksTests.BaseTest;

import static org.junit.Assert.assertEquals;

public class SiteTest extends BaseTest {
    private User owner;

    @Before
    public void setup() {
        owner = new User(USER_NAME, USER_PASSWD);
        manager.persist(owner);
    }

    @Test
    public void createSite() {
        Site site = new Site(owner, SITE);
        manager.getTransaction().begin();
        try {
            manager.persist(site);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        Assert.assertNotNull(manager.find(Site.class, site.getId()));
    }

    @Test
    public void querySite() {
        Site site = new Site(owner, SITE);
        manager.getTransaction().begin();
        try {
            manager.persist(site);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        Site found = manager.createQuery("from Site where domain = :p", Site.class)
                .setParameter("p", SITE)
                .getSingleResult();

        assertEquals(site.getId(), found.getId());
        assertEquals(SITE, found.getDomain());
    }

    //TODO добавление path
}