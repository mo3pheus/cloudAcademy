package hogwarts.engineering.cloud.academy.domain;

import org.springframework.data.repository.CrudRepository;

public interface StudentWhisperRepository extends CrudRepository<StudentWhispers, Long> {
    StudentWhispers findByStudentRollNumber(Long studentRollNumber);
}
