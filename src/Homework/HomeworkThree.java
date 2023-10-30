package Homework;

import Project_1_Stats_Library.StatsLibrary;

import java.math.BigInteger;

public class HomeworkThree {

    public static void main(String[] args){

        //Pg 48-51 2.35 - 2.43 Odd, 2.51, 2.54, 2.61, 2.57, 2.58, 2.59, 2.64, 2.65

        StatsLibrary homeworkCheck = new StatsLibrary();

        System.out.println("Homework 3: Ch. 2 Pg 48 - 51.");

        //2.35

        /*
        An airline has six flights from New York to California and seven flights from California to
        Hawaii per day. If the flights are to be made on separate days, how many different flight
        arrangements can the airline offer from New York to Hawaii?
         */

        //Solution

        /*
        Using calculation for points in a sample space, MxN = 42
         */

        int flights = 6 * 7;

        System.out.printf("2.35: %d different flight arrangements can be made " +
                "from New York to Hawaii.\n", flights);

        //2.37
        /*
        A businesswoman in Philadelphia is preparing an itinerary for a visit to six major cities. The
        distance traveled, and hence the cost of the trip, will depend on the order in which she plans
        her route.
        a How many different itineraries (and trip costs) are possible?
        b If the businesswoman randomly selects one of the possible itineraries and Denver and San
        Francisco are two of the cities that she plans to visit, what is the probability that she will
        visit Denver before San Francisco?
         */

        //Solution

        /*
        a. N = 6! - 6 choices, then 5, then 4... and so on
        b. P(D then F) = N / Nt
           Calculate for one case, Denver Before SF
           Remove the 2 cities from the equation
           Nt = 6P4
         */

        int cities = 6;
        BigInteger itineraries = homeworkCheck.calculateFactorial(cities);

        System.out.println("2.37: \na. The woman can make " + itineraries.intValue() + " different itineraries.");

        itineraries = homeworkCheck.findPermutations(cities, cities - 2);



        System.out.println("b. There is a " + dBeforeF + " chance when randomly selecting an itinerary that she" +
                " visits Denver before San Fransisco.");

        //2.39

        //Solution

        //2.41

        //Solution

        //2.43

        //Solution

        //2.51

        //Solution

        //2.54

        //Solution

        //2.57

        //Solution

        //2.58

        //Solution

        //2.59

        //Solution

        //2.61

        //Solution

        //2.64

        //Solution

        //2.65

        //Solution

    }
}
