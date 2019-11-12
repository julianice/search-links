package searchlinksTests.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import searchlinks.entities.Link;
import searchlinks.entities.Page;
import searchlinks.entities.Site;
import searchlinks.entities.User;
import searchlinksTests.BaseTest;

import java.util.LinkedList;
import java.util.List;


public class LinkTest extends BaseTest {
    private User owner;
    private Site site;
    private Page page;

    @Before
    public void setup() {
        owner = new User(USER_NAME, USER_PASSWD);
        site = new Site(owner, SITE);
        page = new Page(site, PAGE_1);
        manager.persist(owner);
        manager.persist(site);
        manager.persist(page);
    }

    @Test
    public void createLink() {
        Link link = new Link(page, LINK_1);
        manager.getTransaction().begin();
        try {
            manager.persist(link);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        }

        Assert.assertNotNull(manager.find(Link.class, link.getId()));
    }
}