package searchlinks.dao;

import searchlinks.entities.User;

import javax.persistence.EntityManager;

public class UsersDAO {
    private final EntityManager manager;

    public UsersDAO(EntityManager manager) {
        this.manager = manager;
    }

    public void create(User user) {
        manager.persist(user);
    }

    public User findByLogin(String login) {
        return manager.createQuery(
                "from User where login = :p", User.class)
                .setParameter("p", login)
                .getSingleResult();
    }

    public User findById(int userId) {
        return manager.createQuery(
                "from User where id = :p", User.class)
                .setParameter("p", userId)
                .getSingleResult();
    }
}
