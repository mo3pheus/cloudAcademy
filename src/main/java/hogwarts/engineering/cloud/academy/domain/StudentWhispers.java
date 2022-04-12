package hogwarts.engineering.cloud.academy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_whispers")
public class StudentWhispers {
    @Id
    @Getter
    @Setter
    private Long studentRollNumber;

    @Getter
    @Setter
    private String whispers;

    @Override
    public String toString() {
        return "Student Roll Number = " + studentRollNumber + " Whispers = " + whispers;
    }
}
