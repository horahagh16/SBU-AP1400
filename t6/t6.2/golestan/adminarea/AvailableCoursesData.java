package golestan.adminarea;

import golestan.Course;
import golestan.exceptions.InvalidCourseNumberException;

import java.util.ArrayList;

public class AvailableCoursesData {
    private static final ArrayList<Course> coursesAvailable = new ArrayList<>();

    static public Course getCourseByNum(int courseNum) {
        for (int i = 0; i < coursesAvailable.size(); i++) {
            if (coursesAvailable.get(i).courseNumber == courseNum) {
                return coursesAvailable.get(i);
            }
        }
        return null;
    }

    static void addCourse(Course course) throws DuplicateCourseNumberException {
        coursesAvailable.add(course);
    }
}
