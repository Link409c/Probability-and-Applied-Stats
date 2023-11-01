package Mini_Coding_Projects.Birthday_Problem;

import Project_1_Stats_Library.StatsLibrary;

import java.math.BigInteger;
import java.util.ArrayList;


/**
 * This program models the "Birthday Problem", an experiment that finds the probability of
 * two individuals within a group sharing a birthday.
 */
public class BirthdayProblem {
    /**
     * calculates the probability that in the sample space of people, some
     * number of them share a birthday. Uses methods defined in the Stats
     * Library program for calculations.
     * @return the probability of that number of individuals sharing a birthday within the sample space.
     */
    public double calcBdayProblem(){
        //get sample size
        int numOfPeople = getPeople().size();
        double result;
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
        return result;
    }

    public BirthdayProblem(ArrayList<Person> thePeople){
        setPeople(thePeople);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    /**
     * The list of people with birthdays.
     */
    private ArrayList<Person> people;
}
