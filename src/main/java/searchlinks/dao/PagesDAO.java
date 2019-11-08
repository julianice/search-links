package searchlinks.dao;

import searchlinks.entities.Page;
import searchlinks.entities.Site;
import searchlinks.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public class PagesDAO {
    private final EntityManager manager;

    public PagesDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Page page) {
        manager.persist(page);
    }

    public List<Page> findPagesForSite(Site site) {
        return manager.createQuery(
                "from Page where site.id = :p", Page.class
        ).setParameter("p", site.getId())
                .getResultList();
    }

    public void createPages() {

    }
}
