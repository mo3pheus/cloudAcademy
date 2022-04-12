package hogwarts.engineering.cloud.academy.domain;

import org.springframework.data.repository.CrudRepository;

public interface StudentAuthRepository extends CrudRepository<StudentAuthentication, Long> {
    StudentAuthentication findByStudentRollNumber(Long studentRollNumber);
}
