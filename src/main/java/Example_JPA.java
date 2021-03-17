import domain.Member;
import domain.Order;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Example_JPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try {
            Team team = new Team();
            team.setName("TeamB");
            em.persist(team); // 영속성 컨텍스트에 자동생성되는 키값 + team 세팅값이 등록 (1차캐시)

            Member member = new Member();
            member.setUsername("MemberB");
            member.setTeam(team);
            em.persist(member); // 영속성 컨텍스트에 자동생성되는 키값 + member 세팅값이 등록 (1차캐시)

            em.flush(); // 디비에서 직접 조회하고 싶어가지고 플러시로 지연쓰기에있는 것들을 디비에 날림
            em.clear(); // 1차캐시 초기화해줌.

            Member findMember = em.find(Member.class, member.getId()); // 1차캐시 조회했는데 없어서 DB조회
            // DB조회를 했기때문에 쿼리문이 날라감

            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members) {
                System.out.println("m.getId() = " + m.getId());
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
