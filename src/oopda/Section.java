package oopda;
/**
 * Section Class (abstract) serves as a superclass and template for Traditional/Hybrid/Online Section classes with
 * crn, course and instructor attributes.
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public abstract class Section {
    //Protected Field declaration for the crn attribute
    protected Integer crn;
    //Protected Field declaration for the course attribute
    protected Course course;
    //Protected Field declaration for the instructor attribute
    protected Instructor instructor;
    //Static field declaration for the initialcrn attribute
    private static int initialcrn = 40000;
    /**
     * Constructor for the Section class that initializes its attributes and increments the crn as more Section
     * subclass (Traditional/Hybrid/Online) objects are created.
     * @param course, instructor
     */
    public Section(Course course, Instructor instructor) {
        crn = initialcrn;
        initialcrn++;
        this.course = course;
        this.instructor = instructor;
    }
    /**
     * Getter Method that returns the Section object's crn attribute of type Integer.  Also called in the
     * subclasses (Traditional/Hybrid/Online Section)
     * @return crn
     */
    public Integer getCrn() {
        return crn;
    }
    /**
     * Setter Method that sets a Section object's crn attribute to Integer variable passed as a parameter.
     * @param crn
     */
    public void setCrn(Integer crn) {
        this.crn = crn;
    }
    /**
     * Getter Method that returns the Section object's course attribute of type Course.  Also called in the
     * subclasses (Traditional/Hybrid/Online Section)
     * @return course
     */
    public Course getCourse() {
        return course;
    }
    /**
     * Setter Method that sets a Section object's course attribute to Course variable passed as a parameter.
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
    }
    /**
     * Getter Method that returns the Section object's instructor attribute of type Instructor.  Also called in
     * the subclasses (Traditional/Hybrid/Online Section)
     * @return instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }
    /**
     * Setter Method that sets a Section object's instructor attribute to Instructor variable passed
     * as a parameter.
     * @param instructor
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    /**
     * Static Getter Method that returns the Section object's initialcrn attribute of type int.  Also called in
     * the subclasses (Traditional/Hybrid/Online Section)
     * @return initialcrn
     */
    public static int getInitialcrn() {
        return initialcrn;
    }
    /**
     * Static Setter Method that sets a Section object's crn attribute to int variable passed as a parameter.
     * @param crn
     */
    public static void setInitialcrn(int initialcrn) {
        Section.initialcrn = initialcrn;
    }
    /**
     * Abstract Getter Method that allows overridden methods to be called and executed differently in each
     * of the subclasses.
     */
    public abstract String getSchedule();
}

