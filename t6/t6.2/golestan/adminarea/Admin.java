package golestan.adminarea;

import golestan.Course;
import golestan.CourseGender;


// Admin is a Singleton class!
public class Admin {
    static private Admin admin;

    private Admin(){
    }

    public static Admin getAdmin(){
        if (admin==null)
            admin=new Admin();
        return admin;
    }

    public void addNewCourse(String name, CourseGender gender, int courseNumber,
                             int capacity,int startTime, int endTime) throws DuplicateCourseNumberException {
        // Pay attention to why AvailableCoursesData's methods are package accessed
        if (AvailableCoursesData.getCourseByNum(courseNumber)==null) {
            Course course = new Course(name, gender, courseNumber, capacity, startTime, endTime);
            AvailableCoursesData.addCourse(course);
        }
        else
            throw new DuplicateCourseNumberException(courseNumber);

    }

}
