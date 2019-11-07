package searchlinksTests;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseTest {
    protected EntityManagerFactory factory;
    protected EntityManager manager;
    protected static final String USER_NAME  = "test";
    protected static final String USER_PASSWD  = "123";
    protected static final String SITE  = "test.com";
    protected static final String PAGE_1  = "/page1";
    protected static final String PAGE_2  = "/page2";
    protected static final String LINK_1  = "https://www.link1.com";
    protected static final String LINK_2  = "https://www.link2.com/link2";

    @Before
    public void setUp() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();
    }

    @After
    public void cleanup() {
        if (manager != null) {
            manager.close();
        }
        if (factory != null) {
            factory.close();
        }
    }
}
