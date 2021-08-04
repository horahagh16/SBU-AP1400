package golestan.exceptions;

import golestan.Course;

public class ConflictException extends RegistrationException{
    public final Course course1,course2;

    public ConflictException(Course course1, Course course2) {
        super();
       this.course1=course1;
       this.course2=course2;
    }

}