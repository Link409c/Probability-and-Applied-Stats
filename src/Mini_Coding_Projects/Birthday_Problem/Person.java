package Mini_Coding_Projects.Birthday_Problem;

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

    private String name;
    private int birthday;
}
