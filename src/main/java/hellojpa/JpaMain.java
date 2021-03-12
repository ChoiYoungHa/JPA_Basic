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

        try {
 //           Member memberA = em.find(Member.class, 1L);
            //JPQL
            List<Member> result = em.createQuery("select m from Member as m", Member.class).
                    getResultList();
            for (Member member : result) {
                System.out.println("member.getId() = " + member.getId());
                System.out.println("member.getName() = " + member.getName());
            }

//            em.persist(memberA); // 이렇게 해주어야할 것 같지만 이렇게 해주지 않아도 쿼리가 나감

            transaction.commit(); // 마지막 데이터변경 commit
        } catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
