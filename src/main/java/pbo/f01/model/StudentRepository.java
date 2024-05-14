package pbo.f01.model;
import javax.persistence.*;

import java.util.List;
@Entity
public class StudentRepository {
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("dormy_pu");
    public void addStudent(Student student){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }
    public Student getStudent(String id){
        EntityManager em= emf.createEntityManager();
        Student student=em.find(Student.class,id);
        em.close();
        return student;
    }
}

