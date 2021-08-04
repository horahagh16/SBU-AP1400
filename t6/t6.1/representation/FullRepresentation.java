package representation;

import calendar.CustomCalendar;

public class FullRepresentation implements CalendarRepresentation{
    @Override
    public String getRepresentation(CustomCalendar calendar) {

        return calendar.getDay()+" "+calendar.getMonthName()+" "+calendar.getYear();
    }
}
