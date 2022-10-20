package ru.maslov.dao;

import org.springframework.stereotype.Repository;
import ru.maslov.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> AllListUser() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void edit(int id, User user) {
        User newUser = entityManager.find(User.class, id);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail());
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
