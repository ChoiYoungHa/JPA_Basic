package hellojpa;

import javax.persistence.*;
import java.util.Date;
import java.util.IdentityHashMap;

//@Entity //jpa를 사용한다 객체로 인식
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class x_Member {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false) // 디폴트값이 true지만,false를 주게되면 not null 제약조건이 걸림
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public x_Member() {
    }

}
