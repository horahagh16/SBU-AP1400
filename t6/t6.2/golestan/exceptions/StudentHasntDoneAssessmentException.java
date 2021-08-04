package golestan.exceptions;

import golestan.Student;

public class StudentHasntDoneAssessmentException extends RegistrationException {
    public final Student student;

    public StudentHasntDoneAssessmentException(Student student) {
        super();
        this.student = student;
    }
}