package searchlinksTests.dao;

import searchlinks.dao.SitesDAO;
import searchlinksTests.BaseTest;
import searchlinks.entities.Site;
import searchlinks.entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SitesDAOTest extends BaseTest {
    private SitesDAO dao;
    private Site site;
    private User owner;

    @Before
    public void setup() {
        dao = new SitesDAO(manager);
        owner  = new User("testd5es2d1", "123");
        site  = new Site(owner, "test.com");
        manager.persist(owner);
    }

    @Test
    public void createSite() {
        manager.getTransaction().begin();
        try {
            dao.create(site);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }
        assertNotNull(manager.find(Site.class, site.getId()));
    }

    @Test
    public void findSitesByOwner() {
        Site site1 = new Site(owner, "test1.com");
        Site site2 = new Site(owner, "test2.com");
        manager.getTransaction().begin();
        try {
            manager.persist(site1);
            manager.persist(site2);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        List<Site> sites = dao.findByOwner(owner);
        assertTrue(sites.contains(site1));
        assertTrue(sites.contains(site2));
    }
}

