package oopda;
/**
 * The Person class creates Person objects with certain attributes (name, email, ssn, etc etc)
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public class Person {
    // Field declaration for the person's ID.
    private Integer id;
    // Field declaration for the person's first name.
    private String firstName;
    // Field declaration for the person's middle name.
    private String middleName;
    // Field declaration for the person's last name.
    private String lastName;
    // Field declaration for the person's email address.
    private String email;
    // Field declaration for the person's social security #.
    private String ssn;
    // Field declaration for the person's age.
    private Integer age;
    // Field declaration for the highest age.
    private static Integer oldest = 0;
    /**
     * Constructor for the Person class that instantiates a new Person object mostly by using internal method calls to
     * validate age
     * @param id, firstName, middleName, lastName, email, ssn, age
     */
    public Person(Integer id, String firstName, String middleName, String lastName, String email, String ssn,
                  Integer age) {
        this.id = id;
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setEmail(email);
        setSsn(ssn);
        setAge(age);
        if(age > oldest) {
            oldest = age;
        }
    }
    /**
     * Overloaded Constructor for the Person Class that creates Person objects with with only id and lastName
     * attributes
     * @param id, lastName
     */
    public Person (Integer id, String lastName){
        this.id = id;
        setLastName(lastName);
    }
    /**
     * Accessor Method that returns a specific person object's ID
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * Accessor Method that returns a specific person object's firstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Private Mutator Method that sets the firstName to a given input, used in the constructor to instantiate new
     * Person objects
     * @param firstName
     */
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Accessor Method that returns a specific person object's middleName
     * @return middleName
     */
    public String getMiddleName() {
        return middleName;
    }
    /**
     * Private Mutator Method that sets the middleName to a given input, used in the constructor to instantiate new
     * Person objects
     * @param middleName
     */
    private void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    /**
     * Accessor MEthod that returns a specific person object's lastName.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Private Mutator Method that sets the lastName to a given input, used in the constructor to instantiate new
     * Person objects
     * @param lastName
     */
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Accessor Method that returns a specific person object's email.
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Private Mutator Method that sets the email to a given input, if and only if all validation checks are met.
     * @param email
     */
    private void setEmail(String email) {
        if(Person.validateEmail(email) == false) {
            System.out.println("Given email is NOT VALID");
        }
        else {
            this.email = email;
        }
    }
    /**
     * Accessor Method that returns a specific person object's ssn
     * @return ssn
     */
    public String getSsn() {
        return ssn;
    }
    /**
     * Private Mutator Method that sets the ssn to a given input, if and only if all validation checks are met.
     * @param ssn
     */
    private void setSsn(String ssn) {
        if(Person.validateSSN(ssn) == false) {
            System.out.println("Given Social Security # is NOT VALID");
        }
        else {
            this.ssn = ssn;
        }
    }
    /**
     * Accessor Method that returns a specific person object's age
     * @return age
     */
    public Integer getAge() {
        return age;
    }
    /**
     * Private Mutator Method that sets the age to a given input, if and only if all validation checks are met.
     * @param age
     */
    private void setAge(Integer age) {
        if(Person.validateAge(age) == false) {
            System.out.println("Given age is NOT VALID");
        }
        else {
            this.age = age;
        }
    }
    /**
     * Accessor Method that returns the full name of a specific person object
     * @return fullName
     */
    public String toString() {
        return "" + getFirstName() + " " + getMiddleName() + " " + getLastName();
    }
    /**
     * Accessor Method that returns a specific person object's email domain.
     * @param email
     * @return emailDomain
     */
    public String getEmailDomain(String email) {
        String emailDomain = email.substring(email.indexOf('@') + 1);
        return emailDomain;
    }
    /**
     * Accessor Method that returns the last 4 digits of a specific person object's ssn.
     * @param ssn
     * @return last4
     */
    public String getLast4SSN(String ssn) {
        String last4 = ssn.substring(7, 11);
        return last4;
    }
    /**
     * Static Method that determines whether a given age is valid or not
     * @param age
     * @return true or false
     */
    public static boolean validateAge(Integer age) {
        if(age > 16) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Static Method that determines whether a given ssn is valid or not
     * @param ssn
     * @return true or false
     */
    public static boolean validateSSN(String ssn) {
        if(ssn.matches("\\d{3}-\\d{2}-\\d{4}")) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Static Method that determines whether a given email is valid or not
     * @param email
     * @return true or false
     */
    public static boolean validateEmail(String email) {
        String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(email.matches(regex)) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Static Method that returns the oldest age in a specific collection.
     * @return oldest
     */
    public static Integer getOldest() {
        return oldest;
    }
}
