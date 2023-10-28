package Mini_Coding_Projects.Birthday_Problem;

import Project_1_Stats_Library.StatsLibrary;

import java.math.BigInteger;
import java.util.ArrayList;

public class BirthdayProblem {
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
            result = 1 - bigResult.doubleValue();
        }
        //else, throw an exception
        else{
            //throw a custom exception
        }
        return result;
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
