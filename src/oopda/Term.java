package oopda;
import java.util.ArrayList;
/**
 * Creates Term objects with attributes that represent a term's name and all the sections it contains.
 * @author David Yeager, Tyler Cockburn
 * @version 07/10/2016
 */
public class Term {
    //Field Declaration for the termName attribute.
    private String termName;
    //Field Declaration for the sections attribute.
    private ArrayList<Section> sections;
    /**
     * Constructor for the term class that allows for the creation of Term objects and instantiates its termName
     * attribute using the 'this' keyword as well as instantiating the sections attribute to a new ArrayList
     * of Section objects.
     * @param termName
     */
    public Term(String termName) {
        this.termName = termName;
        sections = new ArrayList<Section>();
    }
    /**
     * Getter Method that returns the Term object's termName attribute of type String.
     * @return termName
     */
    public String getTermName() {
        return termName;
    }
    /**
     * Setter Method that sets a Term object's termName attribute to String variable passed as a parameter.
     * @param major
     */
    public void setTermName(String termName) {
        this.termName = termName;
    }
    /**
     * Getter Method that returns the Term object's sections attribute which represents an ArrayList of Section
     * objects.
     * @return termName
     */
    public ArrayList<Section> getSections() {
        return sections;
    }
    /**
     * Setter Method that sets a Term object's termName attribute to String variable passed as a parameter.
     * @param major
     */
    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
    /**
     * Mutator Method that adds a Section object (passed as a parameter) to the sections attribute but first checks
     * if the section already exists in the current collection.
     * @param section
     */
    public void addSection(Section section) {
        if(sections.contains(section)) {
            System.out.println("Section already exists");
        }
        else {
            sections.add(section);
        }
    }
}
