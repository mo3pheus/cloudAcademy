package hogwarts.engineering.cloud.academy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class StudentDetails {
    @Id
    @Getter
    @Setter
    private Long studentRollNumber;

    @Getter
    @Setter
    private String studentName;

    @Getter
    @Setter
    private String studentNotes;

    @Override
    public String toString() {
        return "Student Name = " + studentName + " Student RollNo = " + studentRollNumber
                + " Student Notes = " + studentNotes;
    }
}
