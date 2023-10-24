package Mini_Coding_Projects.Birthday_Problem;

import Project_1_Stats_Library.StatsLibrary;

import java.math.BigInteger;
import java.util.ArrayList;

public class BirthdayProblem {
    /*
     * A Program which determines the probability of any two people in
     * a group would have the same birthday.
     *
     * Control the input so the user can determine how many people are
     * in the group.
     *
     * Make a Person Class with int birthday.
     *
     * Make # of runs configurable (eg. user input in main.)
     *
     * Notes:
     * 1/365 The probability of a birthday being any one day.
     * For the sample space -
     * E1 = 1 = 365/365 First Person is equally likely to have any one birthday
     * E2 = 364/365 Second Person
     * E3 = 363/365 Third... and so on.
     * En = 1 x 364/365 x 363/365 x ... x 365-n/365
     * (Conditional Probability) - B Given A in this example is E2|E1, E3|E2, etc.
     * Equates to the permutations formula n!/(n - r)!
     */

    /**
     * calculates the probability that in the sample space of people, some
     * number of them share a birthday. Uses methods defined in the Stats
     * Library program for calculations.
     * @return the probability of that number of individuals sharing a birthday within the sample space.
     */
    public double calcBdayProblem(){
        //check if the passed number to calculate probability is out of bounds
        //get sample size
        int numOfPeople = getPeople().size();
        int sharing = getShare();
        boolean outOfBounds = sharing > numOfPeople || sharing < 0;
        //if not, proceed with calculation
        double result;
        if(!outOfBounds){
            //create stats library object
            StatsLibrary calcBirthdays = new StatsLibrary();
            int days = 365;
            //calculate total number of permutations of birthdays in the sample space
            BigInteger bDayPermutations = calcBirthdays.findPermutations(days, numOfPeople);
            //calculate total number of birthdays in the sample space
            BigInteger bDays = BigInteger.valueOf((long) Math.pow(days, numOfPeople));
            //divide the permutations by the total
            BigInteger bigResult = bDayPermutations.divide(bDays);
            //subtract the result from the total probability to get the compliment

        }
        //else, throw an exception
        else{
            //throw a custom exception
        }
        return 0;
    }

    public BirthdayProblem(ArrayList<Person> thePeople){
        this.people = thePeople;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    /**
     * The list of people with birthdays.
     */
    private ArrayList<Person> people;
    /**
     * An amount of people who might share a birthday.
     */
    private int share;

}
