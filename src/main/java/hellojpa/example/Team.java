package hellojpa.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long teamId;

    // 팀에서도 팀원들을 다 가져오고 싶다.
    // mappedBy 뜻 : 반대편에 너는 어떤 참조로 매핑되어 있니?
    @OneToMany(mappedBy = "team")
    List<Person> members = new ArrayList<>();

    private String teamName;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }
}
