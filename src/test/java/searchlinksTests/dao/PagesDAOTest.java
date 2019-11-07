package searchlinksTests.dao;

import org.junit.Before;
import org.junit.Test;
import searchlinks.dao.PagesDAO;
import searchlinks.entities.Page;
import searchlinks.entities.Site;
import searchlinks.entities.User;
import searchlinksTests.BaseTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PagesDAOTest extends BaseTest {
    private PagesDAO dao;
    private User owner;
    private Site site;
    private Page page;

    @Before
    public void setup() {
        dao = new PagesDAO(manager);
        owner  = new User("testd5es2d1", "123");
        site  = new Site(owner, "test.com");
        manager.persist(owner);
        manager.persist(site);
    }

    @Test
    public void findPagesForSite() {
        Page page1 = new Page(site, "/path1");
        Page page2 = new Page(site, "/path2");
        manager.getTransaction().begin();
        try {
            manager.persist(page1);
            manager.persist(page2);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        List<Page> pages = dao.findPagesForSite(site);
        assertTrue(pages.contains(page1));
        assertTrue(pages.contains(page2));
    }
}

