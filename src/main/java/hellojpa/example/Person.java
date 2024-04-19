package hellojpa.example;

import jakarta.persistence.*;

@Entity // N : 1 (person 기준)
public class Person {

    @Id @GeneratedValue
    @Column(name = "PERSON_ID")
    private Long id;

    //    @Column(name = "TEAM_ID")

    @ManyToOne()
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void ChangeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
