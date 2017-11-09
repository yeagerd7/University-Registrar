package oopda;
/**
 * Department Class is also an Enumerator Type that simulates multiple education departments.
 * @author David Yeager, Tyler Cockburn
 * @version July 10, 2016
 */
public enum Department {
    Art, Biology, Chemistry, Computer_Science, Economics, English, History, Music, Mathematics,
    Philosophy, Physics, Psychology;
    /**
     * Overridden and returns a string representation of each department name
     */
    public String toString() {
        String s = "";
        if(this.ordinal() == 0) {
            s = "Art";
        }
        else if(this.ordinal() == 1) {
            s = "Biology";
        }
        else if(this.ordinal() == 2) {
            s = "Chemistry";
        }
        else if(this.ordinal() == 3) {
            s = "Computer Science";
        }
        else if(this.ordinal() == 4) {
            s = "Economics";
        }
        else if(this.ordinal() == 5) {
            s = "English";
        }
        else if(this.ordinal() == 6) {
            s = "History";
        }
        else if(this.ordinal() == 7) {
            s = "Music";
        }
        else if(this.ordinal() == 8) {
            s = "Mathematics";
        }
        else if(this.ordinal() == 9) {
            s = "Philosophy";
        }
        else if(this.ordinal() == 10) {
            s = "Physics";
        }
        else if(this.ordinal() == 11) {
            s = "Psychology";
        }
        return s;
    }
}
