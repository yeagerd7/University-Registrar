package oopda;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
/**
 * Driver class contains the main method as well as multiple, very important static methods which are responsible
 * for generating instructors, courses, sections, timeslots... as well as initializing everything for the GUI.
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class Driver {
    /**
     * Main Method that actually runs the program and generate the registrar GUI.
     * @param args
     */
    public static void main(String[] args) {
        RegistrarGui gui = new RegistrarGui();
    }
    /**
     * Static Method that essentially initializes the entire program for the GUI to run.  It creates Catalog, Term
     * and Faculty objects, then makes multiple internal method calls to populate those objects.
     * @return term
     */
    public static Term initialize() {
        Catalog catalog = new Catalog();
        Term term = new Term("Fall 2016");
        Faculty faculty = new Faculty();
        createInstructors(faculty);
        createCourses(catalog);
        createSections(catalog, faculty, term);
        return term;
    }
    /**
     * Static Method that creates 3 separate sections (Tradional, Hybrid, Online) for every course in the catalog
     * and assigns each section a random instructor
     * @param catalog, faculty, term
     */
    private static void createSections(Catalog catalog, Faculty faculty, Term term) {
        for(Course c: catalog.getCourses()){
            TraditionalSection t = new TraditionalSection(c, getRandomInstructor(faculty));
            HybridSection h = new HybridSection(c, getRandomInstructor(faculty));
            OnlineSection o = new OnlineSection(c, getRandomInstructor(faculty));
            term.addSection(t);
            term.addSection(h);
            term.addSection(o);
        }
    }
    /**
     * Static Method that creates Instructor objects and adds them to a Faculty collection
     * @param faculty
     */
    private static void createInstructors(Faculty faculty) {
        faculty.addInstructor(new Instructor(101, "Johnson"));
        faculty.addInstructor(new Instructor(102, "Kay"));
        faculty.addInstructor(new Instructor(103, "Xu"));
        faculty.addInstructor(new Instructor(104, "Mulligan"));
        faculty.addInstructor(new Instructor(105, "Muldoon"));
        faculty.addInstructor(new Instructor(106, "Stanzione"));
        faculty.addInstructor(new Instructor(107, "Brady"));
        faculty.addInstructor(new Instructor(108, "Sawyer"));
        faculty.addInstructor(new Instructor(109, "Brown"));
        faculty.addInstructor(new Instructor(110, "Harrison"));
        faculty.addInstructor(new Instructor(111, "Ford"));
        faculty.addInstructor(new Instructor(112, "Danzinger"));
        faculty.addInstructor(new Instructor(113, "Clarke"));
        faculty.addInstructor(new Instructor(114, "Abraham"));
        faculty.addInstructor(new Instructor(115, "Perkowski"));
        faculty.addInstructor(new Instructor(116, "Brando"));
    }
    /**
     * Static Method that creates Course objects and adds them to a Catalog collection
     * @param catalog
     */
    private static void createCourses(Catalog catalog) {
        catalog.addCourse(new Course("ART 01.101", "Art Appreciation", Department.Art));
        catalog.addCourse(new Course("ART 01.201", "Painting with Oils", Department.Art));
        catalog.addCourse(new Course("ART 01.202", "Painting with Water Colors", Department.Art));
        catalog.addCourse(new Course("BIOL 01.110", "Genetics", Department.Biology));
        catalog.addCourse(new Course("BIOL 04.301", "Anatomy and Physiology", Department.Biology));
        catalog.addCourse(new Course("CHEM 01.101", "Introduction to Chemistry", Department.Chemistry));
        catalog.addCourse(new Course("CHEM 01.201", "Organic Chemistry", Department.Chemistry));
        catalog.addCourse(new Course("CHEM 01.301", "Analytical Chemistry", Department.Chemistry));
        catalog.addCourse(new Course("CSC 04.114", "Object Oriented Programming", Department.Computer_Science));
        catalog.addCourse(new Course("CSC 04.301", "Human Computer Interaction", Department.Computer_Science));
        catalog.addCourse(new Course("CSC 07.211", "Artificial Intelligence", Department.Computer_Science));
        catalog.addCourse(new Course("CSC 04.370", "Software Engineering", Department.Computer_Science));
        catalog.addCourse(new Course("CSC 04.210", "Data Structures and Algorithms", Department.Computer_Science));
        catalog.addCourse(new Course("ENG 03.452", "Creative Writing", Department.English));
        catalog.addCourse(new Course("ECON 01.101", "Microeconomics", Department.Economics));
        catalog.addCourse(new Course("HIS 01.101", "Western Civilization", Department.History));
        catalog.addCourse(new Course("HIS 01.331", "Civil Wars", Department.History));
        catalog.addCourse(new Course("MATH 03.453", "Calculus III", Department.Mathematics));
        catalog.addCourse(new Course("MATH 02.345", "Linear Algebra", Department.Mathematics));
        catalog.addCourse(new Course("MUS 01.214", "The Genres of Rock Music", Department.Music));
        catalog.addCourse(new Course("PHIL 01.111", "Ethics", Department.Philosophy));
        catalog.addCourse(new Course("PHIL 01.221", "Existentialism", Department.Philosophy));
        catalog.addCourse(new Course("PHY 02.121", "Introduction to Mechanics", Department.Physics));
        catalog.addCourse(new Course("PSY 04.114", "Abnormal Psychology", Department.Psychology));
    }
    /**
     * Static Method that generates a random Instructor object from a Faculty collection
     * @param faculty
     * @return instructor
     */
    private static Instructor getRandomInstructor(Faculty faculty){
        Random randomInstructor = new Random();
        int index = randomInstructor.nextInt(faculty.getFacultyStaff().size());
        Instructor instructor = faculty.getFacultyStaff().get(index);
        return instructor;
    }
    /**
     * Static Method that generates and returns a collection of Timeslot objects
     * @return timeslots
     */
    public static ArrayList<Timeslot> TimeslotCollection() {

        ArrayList<Timeslot> timeslots = new ArrayList<Timeslot>();
        for(DayOfWeek day : DayOfWeek.values()) {
            if(day == DayOfWeek.MONDAY || day == DayOfWeek.TUESDAY || day == DayOfWeek.WEDNESDAY
                    || day == DayOfWeek.THURSDAY || day == DayOfWeek.FRIDAY) {
                for(int i = 8; i <= 18; i++) {
                    Timeslot time = new Timeslot(day, LocalTime.of(i, 00), LocalTime.of(i, 50));
                    timeslots.add(time);
                }
            }
        }
        return timeslots;
    }
}

