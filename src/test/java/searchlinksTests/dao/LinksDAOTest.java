package searchlinksTests.dao;

import org.junit.Before;
import org.junit.Test;
import searchlinks.dao.LinksDAO;
import searchlinks.dao.PagesDAO;
import searchlinks.entities.Link;
import searchlinks.entities.Page;
import searchlinks.entities.Site;
import searchlinks.entities.User;
import searchlinksTests.BaseTest;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LinksDAOTest extends BaseTest {
    private LinksDAO dao;
    private User owner;
    private Site site;
    private Page page;

    @Before
    public void setup() {
        dao = new LinksDAO(manager);
        owner  = new User("testd5es2d1", "123");
        site  = new Site(owner, "test.com");
        page  = new Page(site, "test");
        manager.persist(owner);
        manager.persist(site);
        manager.persist(page);
    }

    @Test
    public void findPagesForSite() {
        Link link1 = new Link(page, "https://www.link1.ru/test");
        Link link2 = new Link(page, "https://www.link2.ru/test");
        manager.getTransaction().begin();
        try {
            manager.persist(link1);
            manager.persist(link2);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        List<Link> links = dao.findLinksForPage(page);
        assertTrue(links.contains(link1));
        assertTrue(links.contains(link2));
    }
}

