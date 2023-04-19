package ua.od.hibernate;

import ua.od.hibernate.dao.StudentJpaDAO;
import ua.od.hibernate.model.Student;

public class Main {
    public static void main(String[] args) {
        StudentJpaDAO studentDB = new StudentJpaDAO();
        try {
            Student s1 = new Student("Student1", "mail1@ukr.net");
            Student s2 = new Student("Student2", "mail2@ukr.net");
            Student s3 = new Student("Student3", "mail3@ukr.net");
            Student s4 = new Student("Student4", "mail4@ukr.net");
            Student s5 = new Student("Student5", "mail5@ukr.net");
            studentDB.add(s1);
            studentDB.add(s2);
            studentDB.add(s3);
            studentDB.add(s4);
            studentDB.add(s5);
            studentDB.deleteById(2);
            studentDB.update(s4);
            System.out.println(studentDB.getAll());
            System.out.println(studentDB.getById(1));
        } finally {
            studentDB.getEntityManager().close();
            studentDB.getFactory().close();
        }
    }
}
