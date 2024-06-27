package com.udacity.critter.system.data;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

// Class named PersistenceUtils in the data package
public class PersistenceUtils {

    // That's a constructor that takes an EntityManager as a parameter
    private final EntityManager entityManager;

    // That's a constructor that takes an EntityManager as a parameter
    public PersistenceUtils(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // That's a method to find an entity by its ID
    public <T> Optional<T> find(Class<T> entityClass, Long id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    // That's a method to find all entities of a given class
    public <T> List<T> findAll(Class<T> entityClass) {
        String queryStr = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        TypedQuery<T> query= entityManager.createQuery(queryStr, entityClass);
        return query.getResultList();
    }

    // That's a method to save an entity
    public void save (Object entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    // That's a method to update an entity
    public void update (Object entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    // That's a method to delete an entity
    public void delete (Object entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }
}
