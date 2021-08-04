package calendar;

import calendar.CustomCalendar;
import calendar.exception.IllegalCalendarFormatException;
import representation.CalendarRepresentation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShamsiCustomCalendar implements CustomCalendar {
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
    String[] months = new String[]{"temp", "Farvardin", "Ordibehesht", "Khordad",
            "Tir", "Mordad", "Shahrivar", "Mehr", "Aban",
            "Azar", "Dey", "Bahman", "Esfand",};

    public ShamsiCustomCalendar(String s) {
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
        if (month > 0 && month < 7 && (day < 1 || day > 31))
            throw new IllegalArgumentException();
        else if (month >6  && month <= 12 && (day < 1 || day > 30))
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
        if (day < 1 || day > 31 || month < 1 || month > 12)
            throw new IllegalArgumentException();
        else if (day == 31 && (month > 6))
            throw new IllegalArgumentException();
        else
            this.month = month;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException();
        } else {
            this.year = year;
        }
    }

    @Override
    public String getMonthName() {
        return months[getMonth()];
    }

    @Override
    public CustomCalendar increaseOneDay() {
        if (day < 30) {
            day++;
            s = day + "/" + month + "/" + year;
        } else if (day == 30) {
            if (month < 7) {
                ++day;
                s = day + s.substring(s.indexOf("/"));
            } else {
                if (month == 12) {
                    day = 1;
                    setMonth(1);
                    year++;
                    s = day + "/" + month + "/" + year;

                } else {
                    day = 1;
                    month++;
                    s = day + "/" + month + s.lastIndexOf("/");
                }
            }
        } else if (day == 31) {
            day = 1;
            month++;
            s = day + "/" + month + s.lastIndexOf("/");
        }

        return this;
    }

    @Override
    public CustomCalendar decreaseOneDay() {
        if (day > 1) {
            --day;
            s = day + "/" + month + "/" + year;
        } else if (day == 1 && month != 1) {
            month--;
            if (month < 7) {
                day = 31;
            } else {
                day = 30;
            }
            s = day + "/" + month + "/" + year;
        } else if (day == 1 && month == 1) {
            year--;
            day = 30;
            month = 12;
        }
        return this;
    }

    @Override
    public void setCalendarRepresentation(CalendarRepresentation representation) {
        this.representation = representation;
        s = representation.getRepresentation(this);
    }

    @Override
    public int compareTo(CustomCalendar object) {
        if (object instanceof GregorianCustomCalendar)
            throw new IllegalArgumentException();
        else {
            if (object.getYear() > getYear())
                return -1;
            else if (object.getYear() < getYear())
                return 1;
            else if (object.getMonth() > getMonth())
                return -1;
            else if (object.getMonth() < getMonth())
                return 1;
            else if (object.getDay() > getDay())
                return -1;
            else if (object.getDay() < getDay())
                return 1;
            else
                return 0;
        }
    }
}
