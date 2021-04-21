package ru.anleto.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.anleto.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Transactional
    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
        entityManager.flush();
    }
    @Transactional
    public void delete(int id) {
        entityManager.remove(show(id));
        entityManager.flush();
    }
}
