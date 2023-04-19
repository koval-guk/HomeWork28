package ua.od.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import ua.od.hibernate.model.Student;

import java.util.List;

public class StudentJpaDAO implements StudentDAO {
    private final EntityManagerFactory factory;
    private final EntityManager entityManager;

    public StudentJpaDAO() {
        factory = Persistence.createEntityManagerFactory("student");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void add(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getById(id));
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> studentsNQ = entityManager.createNamedQuery("Student.getAll", Student.class);
        return studentsNQ.getResultList();
    }

    @Override
    public Student getById(long id) {
        return entityManager.find(Student.class, id);
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
