package domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Table(name = "ORDERS")
public class xx_Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private xx_Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private xx_OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
    private List<xx_OrderItem> orderItems = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public xx_Member getMember() {
        return member;
    }

    public void setMember(xx_Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public xx_OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(xx_OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<xx_OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<xx_OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
