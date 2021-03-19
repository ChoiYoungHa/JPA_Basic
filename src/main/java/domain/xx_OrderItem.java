package domain;

import javax.persistence.*;

//@Entity
public class xx_OrderItem {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private xx_Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private xx_Item item;

    private int orderPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public xx_Order getOrder() {
        return order;
    }

    public void setOrder(xx_Order order) {
        this.order = order;
    }

    public xx_Item getItem() {
        return item;
    }

    public void setItem(xx_Item item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
