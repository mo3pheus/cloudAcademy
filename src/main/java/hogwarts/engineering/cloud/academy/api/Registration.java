package hogwarts.engineering.cloud.academy.api;

import hogwarts.engineering.cloud.academy.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class Registration {
    @Autowired
    StudentAuthRepository studentAuthRepository;

    @Autowired
    StudentDetailsRepository studentDetailsRepository;

    @Autowired
    StudentWhisperRepository studentWhisperRepository;

    @RequestMapping("/authentication")
    public StudentAuthentication getStudentAuth(@RequestParam(value = "student_roll_number") Long studentRollNumber) {
        if (studentAuthRepository.findByStudentRollNumber(studentRollNumber) != null) {
            throw new IllegalArgumentException("Student Roll Number already registered.");
        }

        String studentPassword = UUID.randomUUID().toString();
        StudentAuthentication studentAuthentication = new StudentAuthentication();
        studentAuthentication.setStudentRollNumber(studentRollNumber);
        studentAuthentication.setStudentPassword(studentPassword);

        studentAuthRepository.save(studentAuthentication);
        return studentAuthentication;
    }

    @RequestMapping("/registration")
    public StudentDetails postStudentRegistration(
            @RequestParam(value = "student_name") String studentName,
            @RequestParam(value = "student_notes") String studentNotes,
            @RequestParam(value = "student_roll_number") Long studentRollNumber,
            @RequestParam(value = "student_password") String studentPassword) {

        StudentAuthentication studentAuthentication = studentAuthRepository.findByStudentRollNumber(studentRollNumber);
        if (studentAuthentication == null) {
            throw new IllegalArgumentException("Student not registered due to invalid details.");
        } else if (!studentAuthentication.getStudentPassword().equals(studentPassword)) {
            throw new IllegalArgumentException("Student authentication check failed.");
        } else {

            StudentDetails studentDetails = new StudentDetails();
            studentDetails.setStudentNotes(studentNotes);
            studentDetails.setStudentRollNumber(studentRollNumber);
            studentDetails.setStudentName(studentName);

            studentDetailsRepository.save(studentDetails);
            return studentDetails;
        }
    }

    @RequestMapping("/whispers")
    public String getStudentWhispers(@RequestParam(value = "student_roll_number") Long studentRollNumber) {
        StudentWhispers studentWhispers = studentWhisperRepository.findByStudentRollNumber(studentRollNumber);
        if (studentWhispers != null) {
            return studentWhispers.toString();
        } else {
            return "No Student Whispers for this roll number at the time.";
        }
    }

    @RequestMapping("/classNotes")
    public String postClassNotes(@RequestParam(value = "student_roll_number") Long studentRollNumber,
                                 @RequestParam(value = "whispers") String whispers) {
        if (studentWhisperRepository.findByStudentRollNumber(studentRollNumber) == null) {
            StudentWhispers studentWhispers = new StudentWhispers();
            studentWhispers.setWhispers(whispers);
            studentWhispers.setStudentRollNumber(studentRollNumber);
            studentWhisperRepository.save(studentWhispers);
            return "First whisper saved successfully for student " + studentRollNumber;
        } else {
            StudentWhispers studentWhispers = studentWhisperRepository.findByStudentRollNumber(studentRollNumber);
            String oldWhispers = studentWhispers.getWhispers();
            studentWhispers.setWhispers(oldWhispers + "\n" + whispers);
            studentWhisperRepository.save(studentWhispers);
            return "Whisper saved successfully for student " + studentRollNumber;
        }
    }
}
