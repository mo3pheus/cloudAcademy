package hogwarts.engineering.cloud.academy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_authentication")
public class StudentAuthentication {
    @Id
    @Getter
    @Setter
    private Long studentRollNumber;

    @Getter
    @Setter
    private volatile String studentPassword;
}
