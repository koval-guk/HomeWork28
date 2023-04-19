package ua.od.hibernate.dao;

import ua.od.hibernate.model.Student;

import java.util.List;

public interface StudentDAO {
    void add(Student student);
    void deleteById(long id);
    void update(Student student);
    List<Student> getAll();
    Student getById(long id);
}
