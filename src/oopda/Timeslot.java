package oopda;

import java.time.DayOfWeek;
import java.time.LocalTime;
/**
 * Creates Timeslot objects which represents a timeslot's day, start time and end time.
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class Timeslot {
    //Field Declaration for the weekDay attribute
    private DayOfWeek weekDay;
    //Field Declaration for the startTime attribute
    private LocalTime startTime;
    //Field Declaration for the endTime attribute
    private LocalTime endTime;
    /**
     * Constructor for the Timeslot class that allows for the creation of timeslot objects and initializes all of
     * it's attributes via the 'this' keyword
     * @param weekday, startTime, endTime
     */
    public Timeslot(DayOfWeek weekday, LocalTime startTime, LocalTime endTime) {
        this.weekDay = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    /**
     * Getter Method that returns the Timeslot object's weekDay attribute of type DayOfWeek.
     * @return weekday
     */
    public DayOfWeek getWeekDay() {
        return weekDay;
    }
    /**
     * Setter Method that sets a Timeslot object's weekDay attribute to DayOfWeek variable passed as a parameter.
     * @param weekDay
     */
    public void setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
    }
    /**
     * Getter Method that returns the Timeslot object's startTime attribute of type LocalTime.
     * @return startTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }
    /**
     * Setter Method that sets a Timeslot object's startTime attribute to LocalTime variable passed as a parameter.
     * @param startTime
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    /**
     * Getter Method that returns the Timeslot object's startTime attribute of type LocalTime.
     * @return endTime
     */
    public LocalTime getEndTime() {
        return endTime;
    }
    /**
     * Setter Method that sets a Timeslot object's endTime attribute to LocalTime variable passed as a parameter.
     * @param endTime
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    /**
     * Overridden toString() Method that returns a nice String representation of all the Timeslot objec's attributes
     */
    public String toString() {
        return "" + weekDay + " " + startTime + "-" + endTime;

    }
}
