package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //입
        try {
            Member member = new Member();
            member.setUsername("ChoiYoung");

            em.persist(member);

            transaction.commit(); // 마지막 데이터변경 commit
        } catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
