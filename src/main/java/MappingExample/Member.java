package MappingExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    public Member(){
    }

    public Member(String city, String name, String street, int zipcode) {
        this.city = city;
        this.name = name;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String city;

    private String name;

    private String street;

    private int zipcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
