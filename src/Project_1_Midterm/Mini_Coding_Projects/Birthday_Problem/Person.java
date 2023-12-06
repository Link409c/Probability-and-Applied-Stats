package Project_1_Midterm.Mini_Coding_Projects.Birthday_Problem;

/**
 * A Data Container for the Birthday Problem program.
 */
public class Person {

    public Person(String aName, int aBirthday){
        this.setName(aName);
        this.setBirthday(aBirthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    /**
     * No specific format. Name your people however you like.
     */
    private String name;
    /**
     * Each person has a birthday, in the format day of the year.
     * Eg - July 4 is the 185th day of the year.
     */
    private int birthday;
}
