package oopda;
/**
 * The Instructor class extends the Person class and adds to those said attributes to create Instructor objects
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class Instructor extends Person {
    // Field declaration for an instructor's department.
    private String department;
    /**
     * Constructor for the Instructor class that initializes all the superclass attributes via the super call to the
     * Person Constructor, as well as initializing all the attributes bound to the Instructor class and thus
     * creating the Instructor object
     * @param id, firstName, middleName, lastName, email, ssn, age, department
     */
    public Instructor(Integer id, String firstName, String middleName, String lastName, String email, String ssn,
                      Integer age, String department) {
        super(id, firstName, middleName, lastName, email, ssn, age);
        setDepartment(department);
    }
    /**
     * Overloaded Constructor which generates an Instructor object by only initializing the id and lastName
     * attributes via a super call.
     * @param id, lastName
     */
    public Instructor(Integer id, String lastName) {
        super(id, lastName);
    }
    /**
     * Getter Method that returns an Instructor object's specific department of type String
     * @return department
     */
    public String getDepartment() {
        return department;
    }
    /**
     * Setter method that sets department attribute to the given String variable passed as a parameter.
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
