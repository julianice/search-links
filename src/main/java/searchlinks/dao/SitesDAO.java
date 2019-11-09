package searchlinks.dao;

import searchlinks.entities.Site;
import searchlinks.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public class SitesDAO {
    private final EntityManager manager;

    public SitesDAO(EntityManager manager) {
        this.manager = manager;
    }

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
