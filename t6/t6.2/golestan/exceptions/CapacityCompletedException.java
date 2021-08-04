package golestan.exceptions;

import golestan.Course;

public class
CapacityCompletedException extends RegistrationException {
    Course course;

    public CapacityCompletedException(Course course) {
        super();
        this.course = course;
    }
}
