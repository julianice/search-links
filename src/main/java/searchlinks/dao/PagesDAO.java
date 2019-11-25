package searchlinks.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import searchlinks.entities.Page;
import searchlinks.entities.Site;
import searchlinks.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PagesDAO {

    @PersistenceContext
    private EntityManager manager;

    public PagesDAO(){}

    public PagesDAO(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
    public void create(Page page) {
        manager.persist(page);
    }

    public List<Page> findPagesForSite(Site site) {
        return manager.createQuery(
                "from Page where site.id = :p", Page.class
        ).setParameter("p", site.getId())
                .getResultList();
    }
}
