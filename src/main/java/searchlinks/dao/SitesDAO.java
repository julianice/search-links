package searchlinks.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import searchlinks.entities.Site;
import searchlinks.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SitesDAO {

    @PersistenceContext
    private EntityManager manager;

    public SitesDAO(){}

    public SitesDAO(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
    public void create(Site site) {
        manager.persist(site);
    }

    public List<Site> findByOwner(User user) {
        return manager.createQuery(
                "from Site where owner.id = :p", Site.class
        ).setParameter("p", user.getId())
                .getResultList();
    }

    public Site findByDomain(String domain) {
        return manager.createQuery(
                "from Site where domain = :p", Site.class
        ).setParameter("p", domain)
                .getSingleResult();
    }
}
