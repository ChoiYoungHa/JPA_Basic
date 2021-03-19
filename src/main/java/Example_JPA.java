import MappingExample.*;
import domain.*;

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

            Member member = new Member("Y", "Seoul", "Ha", 20);
            em.persist(member);
            Order order = new Order(member, LocalDateTime.now(), OrderStatus.ORDER);
            em.persist(order);

            Item item = new Item("doc", 12000, 1);
            em.persist(item);

            item.setPrice(10000);

            OrderItem orderItem = new OrderItem(order, item, item.getPrice(), item.getStockQuantity());
            em.persist(orderItem);

            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem itis : orderItems) {
                String name = itis.getItem().getName();
                System.out.println("name = " + name);
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
