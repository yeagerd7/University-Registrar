package oopda;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;
/**
 * Extends Section class and creates HybridSection objects that contain an additional timeslot attribute as well
 * as the attributes inherited from its superclass Section.
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class HybridSection extends Section{
    //Field Declaration for the timeslot attribute
    private Timeslot timeslot;
    /**
     * Constructor for the HybridSection class that creates HybridSection objects and initializes it's timeslot
     * attribute to a random Timeslot by making an internal method call.
     * @param course, instructor
     */
    public HybridSection(Course course, Instructor instructor) {
        super(course, instructor);
        generateTimeslot();
    }
    /**
     * Getter Method that returns the HybridSection object's attribute timeslot of type TimeSlot
     * @return timeslot
     */
    public Timeslot getTimeslot() {
        return timeslot;
    }
    /**
     * Setter Method that sets a HybridSection object's timeslot attribute to a Timeslot variable passed
     * as a parameter
     * @param timeslot
     */
    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }
    /**
     * Overridden Getter Method that returns a String representation of a HybridSection object's timeslot
     * attribute
     * @return timeslot.toString()
     */
    @Override
    public String getSchedule() {
        return timeslot.toString();
    }
    /**
     * Static Boolean Method that generates a JOptionPane window which will return a boolean value depending
     * on whether or not a user wants to register for a hybrid section(Yes or No)
     * @return true or false
     */
    public static boolean validateChoice() {
        Object message = "Hybrid classes require online connectivity.\n"
                + "Are you sure you want to register for this class?";
        int result = JOptionPane.showConfirmDialog(null, message, "Hybrid Registration Verification ", JOptionPane.YES_NO_OPTION);
        if(result == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Mutator Method that generates a list of timeslots and populates it by making a static method call to the driver and picking
     * a random timeslot from that list and initializes it to its timeslot attribute
     */
    private void generateTimeslot() {
        ArrayList <Timeslot> fullList = Driver.TimeslotCollection();
        Random randomTimeslot = new Random();
        int index = randomTimeslot.nextInt(fullList.size());
        timeslot = fullList.get(index);
    }
}
