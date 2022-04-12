package hogwarts.engineering.cloud.academy.domain;

import org.springframework.data.repository.CrudRepository;

public interface StudentDetailsRepository extends CrudRepository<StudentDetails, Long> {
    StudentDetails findByStudentRollNumber(Long studentRollNumer);
}
