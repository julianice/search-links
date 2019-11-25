package searchlinks.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import searchlinks.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsersDAO {
    @PersistenceContext
    private EntityManager manager;

    public UsersDAO(){}

    public UsersDAO(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
    public void create(User user) {
        manager.persist(user);
    }

    public User findByLogin(String login) {
        return manager.createQuery(
                "from User where login = :p", User.class)
                .setParameter("p", login)
                .getSingleResult();
    }

    public User findByLoginAndPassword(String login, String password) {
        return manager.createQuery(
                "from User where login = :l and password = :p", User.class)
                .setParameter("l", login)
                .setParameter("p", password)
                .getSingleResult();
    }

    public User findById(int userId) {
        return manager.createQuery(
                "from User where id = :p", User.class)
                .setParameter("p", userId)
                .getSingleResult();
    }
}
