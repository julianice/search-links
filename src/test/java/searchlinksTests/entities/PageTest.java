package searchlinksTests.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import searchlinks.entities.Page;
import searchlinks.entities.Site;
import searchlinks.entities.User;
import searchlinksTests.BaseTest;

import static org.junit.Assert.*;

public class PageTest extends BaseTest {
    private User owner;
    private Site site;

    @Before
    public void setup() {
        owner = new User(USER_NAME, USER_PASSWD);
        site = new Site(owner, SITE);
        manager.persist(owner);
        manager.persist(site);
    }

    @Test
    public void createPage() {
        Page page = new Page(site, PAGE_1);
        manager.getTransaction().begin();
        try {
            manager.persist(page);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        Assert.assertNotNull(manager.find(Page.class, page.getId()));
    }
}