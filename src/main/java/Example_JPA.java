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

        //h2 데이터베이스 연동
        try {
            Movie movie = new Movie();
            movie.setActor("bbbb");
            movie.setDirector("봉준호");
            movie.setName("기생충");
            movie.setPrice(20000);

            em.persist(movie);

            em.flush();
            em.clear();

            Item findMove = em.find(Item.class, movie.getId());// 조인해서 가져옴.
            System.out.println("findMove = " + findMove);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
