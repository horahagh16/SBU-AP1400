package calendar;

import calendar.CustomCalendar;
import calendar.exception.IllegalCalendarFormatException;
import representation.CalendarRepresentation;
import representation.DateRepresentation;
import representation.FullRepresentation;

import java.sql.DatabaseMetaData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GregorianCustomCalendar implements CustomCalendar {
    @Override
    public String toString() {
        if (representation == null)
            throw new IllegalStateException();
        s = representation.getRepresentation(this);
        return s;
    }

    String s;
    int day;
    int month;
    int year;
    CalendarRepresentation representation;
    String[] months = new String[]{"temp", "January", "February", "March",
            "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

    public GregorianCustomCalendar(String s) {
        this.s = s;
        String checkFormat = "^[\\d]{1,2}/[\\d]{1,2}/[\\d]{1,4}$";
        Pattern pattern = Pattern.compile(checkFormat);
        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()) {
            throw new IllegalCalendarFormatException();
        }
        String dd;
        String mm;
        String yyyy;
        dd = s.substring(0, s.indexOf("/"));
        mm = s.substring(s.indexOf("/") + 1, s.lastIndexOf("/"));
        yyyy = s.substring(s.lastIndexOf("/") + 1);
        day = Integer.parseInt(dd);
        month = Integer.parseInt(mm);
        year = Integer.parseInt(yyyy);
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public void setDay(int day) {
        if ((month == 1 || month == 3 || month == 5 || month == 8 || month == 7 || month == 10 || month == 12) && (day < 1 || day > 31))
            throw new IllegalArgumentException();
        else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30))
            throw new IllegalArgumentException();
        else if (month == 2 && (day < 1 || day > 28))
            throw new IllegalArgumentException();
        else
            this.day = day;

    }

    @Override
    public int getMonth() {
        return month;
    }

    @Override
    public void setMonth(int month) {
        if (month < 0 || month > 12) {
            throw new IllegalArgumentException();
        } else {
            if (day > 28 && month == 2) {
                throw new IllegalArgumentException();
            } else if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                throw new IllegalArgumentException();
            } else if (day > 31 && (month == 1 || month == 3 || month == 5 || month == 8 || month == 7 || month == 10 || month == 12)) {
                throw new IllegalArgumentException();
            } else {
                this.month = month;
            }

        }
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException();
        } else
            this.year = year;
    }

    @Override
    public String getMonthName() {
        return months[getMonth()];
    }

    @Override
    public CustomCalendar increaseOneDay() {
        if (day < 30) {
            if (day == 28 && month == 2) {
                day = 1;
                month = 3;
                s = day + "/" + month + s.lastIndexOf("/");
            } else {
                day++;
                s = day + "/" + month + "/" + year;
            }
        } else {
            if (day == 30) {
                if (month == 1 || month == 3 || month == 5 || month == 8 || month == 7 || month == 10 || month == 12) {
                    ++day;
                    s = day + s.substring(s.indexOf("/"));
                } else {
                    day = 1;
                    month++;
                    s = day + "/" + month + s.lastIndexOf("/");
                }
            } else {
                if (month != 12) {
                    day = 1;
                    month++;
                    s = day + "/" + month + s.lastIndexOf("/");
                } else {
                    day = 1;
                    setMonth(1);
                    year++;
                    s = day + "/" + month + "/" + year;
                }
            }
        }
        return this;
    }

    @Override
    public CustomCalendar decreaseOneDay() {
        if (day > 1) {
            --day;
            s = day + s.substring(s.indexOf("/"));
        } else if (day == 1 && month != 1) {
            month--;
            if (month == 1 || month == 3 || month == 5 || month == 8 || month == 7 || month == 10 || month == 12) {
                day = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = 30;
            } else if (month == 2) {
                day = 28;
            }
            s = day + "/" + month + "/" + year;
        } else if (day == 1 && month == 1) {
            year--;
            day = 31;
            month = 12;
        }
        return this;
    }

    @Override
    public void setCalendarRepresentation(CalendarRepresentation representation) {
        if (representation instanceof FullRepresentation || representation instanceof DateRepresentation)
            this.representation = representation;
        else
            throw new IllegalStateException();

        s = representation.getRepresentation(this);
    }

    @Override
    public int compareTo(CustomCalendar object) {
        if (object instanceof ShamsiCustomCalendar)
            throw new IllegalArgumentException();
        else {
            if (object.getYear() > getYear())
                return -2;
            else if (object.getYear() < getYear())
                return 2;
            else if (object.getMonth() > getMonth())
                return -2;
            else if (object.getMonth() < getMonth())
                return 2;
            else if (object.getDay() > getDay())
                return -2;
            else if (object.getDay() < getDay())
                return 2;
            else
                return 0;
        }
    }
}
