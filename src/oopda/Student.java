package oopda;

import java.util.HashMap;
/**
 * The Student class extends the Person class and adds to those said attributes to create Student objects.
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class Student extends Person {
    // Field declaration for the Student object's major attribute.
    private String major;
    // Field declaration for the Student object's currentSection attribute
    private HashMap<Integer, Section> currentSections;
    /**
     * Constructor for the Student class that initializes all the superclass attributes via the super call to the
     * Person Constructor, as well as initializing all the attributes bound to the Student class
     * @param id, firstName, middleName, lastName, email, ssn, age, major
     */
    public Student(Integer id, String firstName, String middleName, String lastName, String email, String ssn,
                   Integer age, String major) {
        super(id, firstName, middleName, lastName, email, ssn, age);
        setMajor(major);
        currentSections = new HashMap<Integer, Section>();
    }
    /**
     * Overloaded Constructor which generates an Student object by only initializing the id and lastName
     * attributes via a super call as well as a new attribute of currentSections which is initialized as a
     * new HashMap.
     * @param id, lastName
     */
    public Student(Integer id, String lastName ) {
        super(id, lastName);
        currentSections = new HashMap<Integer, Section>();
    }
    /**
     * Getter Method that returns a Student object's major attribute of type String.
     * @return major
     */
    public String getMajor() {
        return major;
    }
    /**
     * Setter Method that sets a Student object's major attribute to String variable passed as a parameter.
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }
    /**
     * Getter Method that returns a Student object's currentSection attribute of type HashMap
     * @return major
     */
    public HashMap<Integer, Section> getCurrentSections() {
        return currentSections;
    }
    /**
     * Setter Method that sets a Student object's current attribute to HashMap variable passed as a parameter
     * @param major
     */
    public void setCurrentSections(HashMap<Integer, Section> currentSections) {
        this.currentSections = currentSections;
    }
    /**
     * Mutator Method that adds a Section object variable to the HashMap collection attribute, currentSections
     * @param section
     */
    public void add(Section section){
        if(!currentSections.containsKey(section.getCrn())) {
            currentSections.put(section.getCrn(), section);
        }
        else {
            System.out.println("Student is already registered for this course");
        }
    }
    /**
     * Mutator Method that removes (drops) a specific Section objects from the currentSection HashMap collection.
     * @param section
     */
    public void drop(Section section) {
        if(currentSections.containsKey(section.getCrn())) {
            currentSections.remove(section.getCrn());
        }
        else {
            System.out.println("Student is already registered for this course");
        }
    }
}
