import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Example_JPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("MemberA");
            em.persist(member);
//
//            Order order = new Order();
//            order.setOrderStatus(OrderStatus.ORDER);
//            order.setMember(member);
//            em.persist(order);
//
//            OrderItem orderItem = new OrderItem();
//
//            Item item = new Item();
//            item.setName("ItemA");
//            item.setPrice(10000);
//            item.setStockQuantity(1);
//            em.persist(item);
//
//            orderItem.setItem(item);
//            orderItem.setOrder(order);
//            orderItem.setOrderPrice(10000);
//            orderItem.setCount(1);
//            em.persist(orderItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
