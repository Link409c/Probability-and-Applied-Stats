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
        BigInteger days = BigInteger.valueOf(365);
        //create stats library object
        StatsLibrary calcBirthdays = new StatsLibrary();
        //calculate the total number of points in the sample space
        //365^n where n is the number of people
        BigInteger totalPoints = days.pow(numOfPeople);
        //calculate the number of sample points
        //first person 365/365, second person 364/365, etc.
        //365x364x363x...x365-n
        int difference = days.intValue() - numOfPeople;
        //get 365 factorial and 365 - n factorial
        BigInteger numerator = calcBirthdays.calculateFactorial(days.intValue());
        BigInteger denominator = calcBirthdays.calculateFactorial(difference);
        //365x364x...x(365-n)x(365-n)! divided by (365-n)! leaves us with first (365-n+n) elements multiplied
        //divide them to be left with 365x364x...x365-n
        BigInteger samplePoints = numerator.divide(denominator);
        //divide sample points by total points to get probability of nobody sharing a birthday
        double noneSharing = samplePoints.doubleValue() / totalPoints.doubleValue();
        //get the compliment to determine probability that at least two people share a birthday.
        return calcBirthdays.complimentOfEvent(noneSharing);
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
