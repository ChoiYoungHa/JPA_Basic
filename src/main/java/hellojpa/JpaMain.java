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
            Member member1 = new Member(1001L, "MemberA");
            Member member2 = new Member(1002L, "MemberB");

            //각각 영속성 컨텍스트 1차 캐시에 저장됨. 그리고 지연쓰기 sql에 쿼리가 하나하나 저장됨.
            em.persist(member1);
            em.persist(member2);
            System.out.println("======================");

            transaction.commit(); // 마지막 데이터변경 commit
        } catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
