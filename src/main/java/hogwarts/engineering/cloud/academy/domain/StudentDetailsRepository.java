package hogwarts.engineering.cloud.academy.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDetailsRepository extends CrudRepository<StudentDetails, Long> {
    StudentDetails findByStudentRollNumber(Long studentRollNumer);

    List<StudentDetails> findAll();
}
