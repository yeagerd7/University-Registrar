package oopda;

import java.util.ArrayList;

/**
 * Creates Catalog objects which contain a collection of course objects
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class Catalog {
    //Field Declaration for courses(ArrayList of Course Objects)
    private ArrayList<Course> courses;
    /**
     * Constructor for the Catalog Class that creates a Catalog object and instantiates its courses attribute
     * as a new ArrayList of Course objects.
     */
    public Catalog() {
        courses = new ArrayList<Course>();
    }
    /**
     * Getter Method that returns the courses attribute(ArrayList of Course objects)
     * @return courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }
    /**
     * Setter Method that sets an existing ArrayList of Course objects (as a parameter) and sets that object
     * to the courses attribute
     * @param courses
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    /**
     * Mutator Method that adds a course to a Catalog object's existing courses collection(ArrayList of Course
     * objects.
     * @param course
     */
    public void addCourse(Course course) {
        if(courses.contains(course.getTitle())) {
            System.out.println("Course name already exists");
        }
        else if(courses.contains(course.getCourseNumber())) {
            System.out.println("Course number already exists");
        }
        else {
            courses.add(course);
        }
    }
}
