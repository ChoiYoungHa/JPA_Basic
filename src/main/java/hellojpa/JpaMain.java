package hellojpa;

import hellojpa.example.Person;
import hellojpa.example.Team;
import jakarta.persistence.*;
import jpashop.domain.Item;
import jpashop.domain.Order;
import jpashop.domain.OrderItem;

import java.util.Iterator;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Team team = new Team();
            team.setTeamName("TeamA");
            em.persist(team);

            Person member = new Person();
            member.setUserName("MemberA");
            member.ChangeTeam(team);
            em.persist(member);



            Team findTeam = em.find(Team.class, team.getTeamId());

            List<Person> members = findTeam.getMembers();


            for (Person person : members) {
                System.out.println("person.getUserName() = " + person.getUserName());
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
