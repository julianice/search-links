package searchlinks.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import searchlinks.entities.Link;
import searchlinks.entities.Page;
import searchlinks.entities.Site;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LinksDAO {
    @PersistenceContext
    private EntityManager manager;

    public LinksDAO(){}

    public LinksDAO(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
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
