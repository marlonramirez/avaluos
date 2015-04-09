package org.domain.avaluosapl.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.jboss.seam.annotations.Name;

@Name("calendarBean")
public class CalendarBean implements Serializable {
  /**/
  private static final long serialVersionUID = -219499296173801537L;
  private Locale locale;
  private TimeZone timeZone;
  private Calendar calendar;

  public CalendarBean() {
    locale = new Locale("es", "CO");
    timeZone = TimeZone.getDefault();
    calendar = Calendar.getInstance(timeZone, locale);
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public TimeZone getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(TimeZone timeZone) {
    this.timeZone = timeZone;
  }

  public Calendar getCalendar() {
    return calendar;
  }

  public void setCalendar(Calendar calendar) {
    this.calendar = calendar;
  }

}
