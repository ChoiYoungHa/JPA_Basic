package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //jpa를 사용한다 객체로 인식
public class Member {

    // jpa에게 pk를 알려줌. 또 어노테이션중에
    // 비슷한 녀석들이 있는데 무조건 javax로 시작하는거 선택
    @Id
    private Long id; // db에 있는 속성들을 맞춰준다.


    private String name;

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
}
