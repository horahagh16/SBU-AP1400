package golestan;

import golestan.adminarea.AvailableCoursesData;
import golestan.exceptions.*;

import java.util.ArrayList;

public class Registration {
    public final Student registeringStudent;

    private final ArrayList<Course> currentCourses = new ArrayList<>();

    Registration(Student registeringStudent) throws StudentHasntDoneAssessmentException {
        if (!registeringStudent.isAssessmentDone())
            throw new StudentHasntDoneAssessmentException(registeringStudent);
        this.registeringStudent = registeringStudent;
    }

    private void checkCapacity(Course course) throws CapacityCompletedException {
        //
        if (course.getCurrentStudents() == course.capacity)
            throw new CapacityCompletedException(course);
    }

    private void checkForConflict(Course course) throws ConflictException {
        //
        for (Course currentCours : currentCourses) {
            if (currentCours.startTime <= course.startTime && course.startTime < currentCours.endTime)
                throw new ConflictException(course, currentCours);
            else if (currentCours.startTime < course.endTime && course.endTime <= currentCours.endTime)
                throw new ConflictException(course, currentCours);
            else if (course.startTime <= currentCours.startTime && course.endTime >= currentCours.endTime)
                throw new ConflictException(course, currentCours);
        }

    }

    private void checkGender(Course course) throws WrongGenderException {
        //
        if (course.gender == CourseGender.Female && registeringStudent.isMale)
            throw new WrongGenderException(course, registeringStudent);
        else if (course.gender == CourseGender.Male && !registeringStudent.isMale)
            throw new WrongGenderException(course, registeringStudent);
    }

    public void addCourse(int courseNum) throws RegistrationException {
        //
        if (AvailableCoursesData.getCourseByNum(courseNum)==null)
            throw new InvalidCourseNumberException(courseNum);
        else {
            checkCapacity(AvailableCoursesData.getCourseByNum(courseNum));
            checkForConflict(AvailableCoursesData.getCourseByNum(courseNum));
            checkGender(AvailableCoursesData.getCourseByNum(courseNum));
            currentCourses.add(AvailableCoursesData.getCourseByNum(courseNum));
            AvailableCoursesData.getCourseByNum(courseNum).addNewStudent();
        }
    }
}
