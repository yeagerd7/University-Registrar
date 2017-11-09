package oopda;
/**
 * Creates Course objects that with attributes that represent a course's number, title and department
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class Course {
    //Field declaration for the Course Object's attribute courseNumber
    private String courseNumber;
    //Field declaration for the Course Object's attribute title
    private String title;
    //Field declaration for the Course Object's attribute department
    private Department department;
    /**
     * Constructor for the Course class that instantiates all of the attributes and allows for the creation of a
     * course object
     * @param courseNumber, title, department
     */
    public Course(String courseNumber, String title, Department department) {
        this.courseNumber = courseNumber;
        this.title = title;
        this.department = department;
    }
    /**
     * Getter Method that returns the Course object's attribute courseNumber
     * @return courseNumber
     */
    public String getCourseNumber() {
        return courseNumber;
    }
    /**
     * Setter Method that sets a Course object's courseNumber attribute to a String variable passed as a parameter
     * @param courseNumber
     */
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
    /**
     * Getter Method that returns a Course object's title attribute
     * @return title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Setter Method that sets a Course object's title attribute to a String variable passed as a parameter
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Getter Method that returns a Course object's department attribute
     * @return department
     */
    public Department getDepartment() {
        return department;
    }
    /**
     * Setter Method that sets a Course object's department based on a Department variable passed as a parameter
     * @param department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
}
