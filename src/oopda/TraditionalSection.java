package oopda;

import java.util.ArrayList;
import java.util.Random;
/**
 * Extends Section class and creates TraditionalSection objects that contain an additional collection of timeslots (2)
 * attribute as well as the attributes inherited from its superclass Section.
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class TraditionalSection extends Section{
    //Field Declaration for for the timelist attribute.
    private ArrayList<Timeslot> timelist;
    /**
     * Constructor for the TraditionalSection class that creates TraditionalSection objects and initializes it's
     * timelist attribute to a new ArrayList of Timeslot objects and adds 2 random Timeslot objects to timelist from
     * a collection of Timeslot objects by making a internal method call.
     */
    public TraditionalSection(Course course, Instructor instructor) {
        super(course, instructor);
        timelist = new ArrayList<Timeslot>();
        timeslotsGeneratorAndCheck();
    }
    /**
     * Getter Method that returns the TraditionalSection object's attribute timelist (ArrayList of TimeSlot objects)
     * @return timelist
     */
    public ArrayList<Timeslot> getTimeSlots() {
        // TODO Auto-generated method stub
        return timelist;
    }
    /**
     * Overridden Getter Method that returns a String representation of a Traditional Section object's 2 current
     * timeslots
     * @return timeslot.toString()
     */
    @Override
    public String getSchedule() {
        String x = timelist.get(0).toString() + "/" + timelist.get(1).toString();
        return x;
    }
    /**
     * Mutator Method that generates a list of timeslots and populates it by making a static method call to the driver and picks
     * two random timeslots from that list and adds them to the Traditional Section objects collection of (2) timeslots only if
     * the two randomly picked timeslots don't have the same day.  It won't assign and initialize the timeslots until this stipulation
     * is met.
     */
    private void timeslotsGeneratorAndCheck() {
        ArrayList <Timeslot> fullList = Driver.TimeslotCollection();
        Random randomTimeslot = new Random();
        int index1 = randomTimeslot.nextInt(fullList.size());
        int index2 = randomTimeslot.nextInt(fullList.size());
        Timeslot timeslot1 = fullList.get(index1);
        Timeslot timeslot2 = fullList.get(index2);
        timelist = new ArrayList<Timeslot>();
        timelist.add(timeslot1);
        boolean searching = true;
        while(timeslot1.getWeekDay().toString().equalsIgnoreCase(timeslot2.getWeekDay().toString()) && searching) {
            Random replacementRandomTimeslot = new Random();
            int index3 = replacementRandomTimeslot.nextInt(fullList.size());
            timeslot2 = fullList.get(index3);
            if(timeslot2.getWeekDay().toString().equalsIgnoreCase(timeslot1.getWeekDay().toString())) {
                searching = true;
            }
            else {
                searching = false;
            }
        }
        timelist.add(timeslot2);
    }
}
