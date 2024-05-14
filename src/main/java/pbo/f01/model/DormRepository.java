package pbo.f01.model;
import javax.persistence.*;

import java.util.List;
@Entity
public class DormRepository {
      private EntityManagerFactory emf= Persistence.createEntityManagerFactory("dormy_pu");
    public void addDorm(Dorm dorm){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(dorm);
        em.getTransaction().commit();
        em.close();
    }
    public Dorm getDorm(String name){
        EntityManager em= emf.createEntityManager();
        Dorm dorm=em.find(Dorm.class,name);
        em.close();
        return dorm;
    }
    public List<Dorm> getAllDorms(){
        EntityManager em=emf.createEntityManager();
        List<Dorm> dorms=em.createQuery("SELECT d FROM DORM d ORDER BY d.name",Dorm.class).getResultList();
        em.close();
        return dorms;
    }
}
