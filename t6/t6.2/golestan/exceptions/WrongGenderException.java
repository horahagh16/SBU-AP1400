package golestan.exceptions;

import golestan.Course;
import golestan.Student;

public class WrongGenderException extends RegistrationException{
    public final Course course;
    public final Student student;

    public WrongGenderException(Course course, Student student) {
        super();
        this.course=course;
        this.student=student;
    }
}
