package representation;

import calendar.CustomCalendar;

public class DateRepresentation implements CalendarRepresentation {
    @Override
    public String getRepresentation(CustomCalendar calendar) {
        if (calendar.getDay() > 9 && calendar.getMonth() > 9)
            return calendar.getDay() + "/" + calendar.getMonth() + "/" + calendar.getYear();
        else if (calendar.getDay() > 9 && calendar.getMonth() <= 9)
            return calendar.getDay() + "/0" + calendar.getMonth() + "/" + calendar.getYear();
        else if (calendar.getDay() <= 9 && calendar.getMonth() <= 9)
            return "0" + calendar.getDay() + "/0" + calendar.getMonth() + "/" + calendar.getYear();
        else
            return "0"+calendar.getDay()+"/"+calendar.getMonth()+"/"+calendar.getYear();
    }
}
