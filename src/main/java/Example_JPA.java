import MappingExample.*;
import domain.*;
import highMapping.Item;
import highMapping.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class Example_JPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setName("Hello");
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getName() = " + findMember.getName());
            System.out.println("findMember.getId() = " + findMember.getId());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
