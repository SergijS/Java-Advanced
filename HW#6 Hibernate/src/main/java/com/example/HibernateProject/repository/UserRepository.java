package com.example.HibernateProject.repository;

import com.example.HibernateProject.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User create(User user) {
        return entityManager.merge(user);
    }

    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getByEmail(String email) {
        Query query = entityManager.createQuery("FROM User Where email=:email");
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Transactional
    public void deleteUserById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}