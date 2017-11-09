package oopda;

import java.util.ArrayList;

/**
 * Creates Faculty objects with an attribute which contains an ArrayList of Instructor objects
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class Faculty {
    //Field declaration for staff attribute(ArrayList of Instructor objects)
    private ArrayList<Instructor> staff;
    /**
     * Constructor for the Faculty Class that creates a Faculty object and instantiates its staff attribute
     * as a new ArrayList of Instructor objects.
     */
    public Faculty() {
        staff = new ArrayList<Instructor>();
    }
    /**
     * Getter Method that returns the staff attribute(ArrayList of Course objects)
     * @return staff
     */
    public ArrayList<Instructor> getFacultyStaff() {
        return staff;
    }
    /**
     * Setter Method that sets an existing ArrayList of Instructor objects (as a parameter) and sets that object
     * to the staff attribute
     * @param facultyStaff
     */
    public void setFacultyStaff(ArrayList<Instructor> facultyStaff) {
        this.staff = facultyStaff;
    }
    /**
     * Mutator Method that adds a Instructor to a Faculty object's existing staff collection(ArrayList of
     * Instructor objects).
     * @param instructor
     */
    public void addInstructor(Instructor instructor) {
        if(staff.contains(instructor)) {
            System.out.println("Instructor already exists");
        }
        else {
            staff.add(instructor);
        }
    }
}
