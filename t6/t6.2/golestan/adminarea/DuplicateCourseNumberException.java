package golestan.adminarea;

public class DuplicateCourseNumberException extends Exception{
    public DuplicateCourseNumberException(int number) {
        super(String.valueOf(number));
    }
}

