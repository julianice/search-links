package searchlinks.dao;

import searchlinks.entities.Link;
import searchlinks.entities.Page;
import searchlinks.entities.Site;

import javax.persistence.EntityManager;
import java.util.List;

public class LinksDAO {
    private final EntityManager manager;

    public LinksDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Link link) {
        manager.persist(link);
    }

    public List<Link> findLinksForPage(Page page) {
        return manager.createQuery(
                "from Link where page.id = :p", Link.class
        ).setParameter("p", page.getId())
                .getResultList();
    }
}
