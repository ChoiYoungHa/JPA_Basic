package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class xx_Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String name;

    @OneToMany(mappedBy = "member")
    private List<xx_Order> orders = new ArrayList<>();

    private String city;
    private String street;
    private int zipcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<xx_Order> getOrders() {
        return orders;
    }

    public void setOrders(List<xx_Order> orders) {
        this.orders = orders;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
