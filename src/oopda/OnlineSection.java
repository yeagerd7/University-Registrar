package oopda;
import javax.swing.JOptionPane;
/**
 * Extends Section class and creates OnlineSection objects,
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class OnlineSection extends Section {
    /**
     * Constructor for the OnlineSection class that generates OnlineSection objects and initializes its
     * attributes via a super call.
     * @param course, instructor
     */
    public OnlineSection(Course course, Instructor instructor) {
        super(course, instructor);
    }
    /**
     * Getter Method that returns a String variable representing it's section type.
     * @return x
     */
    public String getSchedule() {
        String x = "ONLINE CLASS";
        return x;
    }
    /**
     * Static Boolean Method that generates a JOptionPane window which will return a boolean value depending
     * on whether or not a user wants to register for an online section(Yes or No)
     * @return true or false
     */
    public static boolean validateChoice() {
        Object message = "Remote classes require online connectivity and good time management skills.\n"
                + "Are you sure you want to register for this class?";
        int result = JOptionPane.showConfirmDialog(null, message, "Online Registration Verification ", JOptionPane.YES_NO_OPTION);
        if(result == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
