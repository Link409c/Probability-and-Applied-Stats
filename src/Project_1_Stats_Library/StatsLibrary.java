package Project_1_Stats_Library;

import Project_1_Stats_Library.Custom_Exceptions.TotalProbabilityException;
import Project_1_Stats_Library.Custom_Exceptions.WithinNumberException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * The Stats Library Class is a custom class created to use in the Probability
 * and Applied Statistics course and beyond. The user can invoke its methods to
 * calculate several values associated with an object that represents a data set.
 * These methods can produce new sets, and inform the user on several key points of
 * data concerning a set or population. This data includes averages, variance,
 * standard deviation, and several forms of calculating probability of given events.
 * --
 * Author: Christian Simpson
 * Version: 11/1/23
 **/
public class StatsLibrary{

    //helper methods I want to create:

    //count unique elements method
    /* count the number of unique elements or objects in a list.
       used for determining those elements' probabilities.
       can be coded in a way to allow for different object subtypes
       gives users the ability to use the methods in library with lists
       of any assortment of objects. */

    //determineElementProbabilities method

    /* knowing the number of elements in a list,
       use their occurrences to determine the probability
       of choosing each element from that list in a single trial.
       ex: a bag of colored balls; 3 red, 7 white.
       two unique elements: P(red) = .3, P(white) = .7
       or: a junk drawer full of stuff; could be anything.
       6 unique elements: 1 pair of scissors, 3 rolls of tape, 5 pens,
       43 coupons, a roll of string, 10 bag clips; 63 total items.
       P(Scissors) = .01587, P(Tape) = .04769, P(Pen) = .07936,
       P(Coupon) = .68253, P(String) = .01587, P(Clip) = .15873 */

    /**
     * a helper method for summation of list elements.
     * @param anArrayList the list to sum values
     * @return the sum of list values.
     */
    public double findListSum(ArrayList<Double> anArrayList){
        double sum = 0;
        if(!anArrayList.isEmpty()) {
            for (Double d : anArrayList) {
                sum += d;
            }
        }
        return sum;
    }

    /**
     * subtracts the mean of values in a list from each of those values.
     * Used in calculating standard deviation of a set of values
     * @param anArrayList the list of values
     * @param mean mean of the passed list
     * @return the new list
     */
    public ArrayList<Double> findDifferenceOfValuesAndMean(ArrayList<Double> anArrayList, double mean){
        //create a list of equal size to hold new values
        ArrayList<Double> differenceList = new ArrayList<>(anArrayList.size());
        //for each value of the passed list,
        for (Double d : anArrayList){
            //set the elements of the new list as difference of passed list value and mean
            double difference = d - mean;
            differenceList.add(difference);
        }
        //return the new list
        return differenceList;
    }

    /**
     * squares each value in a list.
     * @param anArrayList a list of values
     * @return a list of squared values
     */
    public ArrayList<Double> squareList(ArrayList<Double> anArrayList){
        ArrayList<Double> squaredList = new ArrayList<>(anArrayList.size());
        for(Double d : anArrayList){
            d *= d;
            squaredList.add(d);
        }
        return squaredList;
    }
    /**
     * findMean computes the average of values in a list.
     * @param anArrayList the list to iterate
     * @return the average
     */
    public double findMean(ArrayList<Double> anArrayList){
        return findListSum(anArrayList) / anArrayList.size();
    }

    /**
     * sorts the passed list, and compares adjacent values to find the most
     * represented value in the list.
     * @param anArrayList a list of values
     * @return the most represented value in the list
     */
    public double findMode(ArrayList<Double> anArrayList){
        //sort the list
        Collections.sort(anArrayList);
        //loop list and compare pairs of values
        int count = 0, maxCount = 0;
        double mode = anArrayList.get(0);
        int i = 0, j = 1;
        do{
            //if equal increment count
            if(Objects.equals(anArrayList.get(i), anArrayList.get(j))){
                count++;
            }
            //else non equal is found
            //check if count is greater than current highest
            if(count > maxCount){
                //set mode value to this index element
                mode = anArrayList.get(i);
                //set current max count to count
                maxCount = count;
                //reset count
                count = 0;
            }
            i++;
            j++;
        }while(j < anArrayList.size());
        return mode;
    }

    /**
     * sorts the passed array, and finds the median by calculating the middle index.
     * if the list size is even, the median is taken as the average of the two middle
     * values.
     * @param anArrayList a list of values
     * @return the median of the values in the list
     */
    public double findMedian(ArrayList<Double> anArrayList){
        Collections.sort(anArrayList);
        double median;
        //if size is odd,
        if(anArrayList.size() % 2 != 0){
            //median is middle element
            median = anArrayList.get(anArrayList.size() / 2);
        }
        //else if size is even,
        else{
            int middle = (anArrayList.size() / 2);
            //median is average of adjacent middle elements
            median = ((anArrayList.get(middle) + anArrayList.get(middle - 1)) / 2.0);
        }
        return median;
    }

    /**
     * calculates the standard deviation of a set of values. uses several helper
     * methods for each step.
     * @param anArrayList a list of values
     * @return the standard deviation of the values.
     */
    public double calcStandardDeviation(ArrayList<Double> anArrayList) {
        //calculate variance
        double mean = calculateVariance(anArrayList);
        //take the square root of the variance
        //return the result
        return Math.sqrt(mean);
    }

    /**
     * calculates the variance of a population.
     * @param anArrayList the list of elements passed to the method is considered the population.
     * @return the variance of the population
     */
    public double calculateVariance(ArrayList<Double> anArrayList){
        //get sum of the list elements
        //divide to find mean
        double mean = findMean(anArrayList);
        //for each element, subtract the mean from it to get a new list of values
        anArrayList = findDifferenceOfValuesAndMean(anArrayList, mean);
        //square each value
        anArrayList = squareList(anArrayList);
        //get sum of the list elements
        //find the new mean
        return findMean(anArrayList);
    }

    /**
     * calculates the factorial representation of a number returning a BigInteger object.
     * This allows the method to avoid any overflow that would occur if using primitive
     * datatypes.
     * @param l the number to calculate
     * @return the factorial of the input
     */
    public BigInteger calculateFactorial(int l){
        //case for zero factorial
        if(l == 0){
            return BigInteger.ONE;
        }
        else {
            BigInteger result = BigInteger.valueOf(l);
            while (l > 1) {
                l--;
                result = result.multiply(BigInteger.valueOf(l));
            }
            return result;
        }
    }

    /**
     * sorts the passed list and compares each pair of adjacent elements, removing any
     * repeated values.
     * @param anArrayList the list to sort and sift for unique values.
     * @return the list of unique values.
     */
    public ArrayList<Double> sortAndKeepUniqueElements(ArrayList<Double> anArrayList){
        Collections.sort(anArrayList);
        int j;
        for(int i = 0; i < anArrayList.size() - 1; i++){
            j = i + 1;
            while(Objects.equals(anArrayList.get(i), anArrayList.get(j))) {
                anArrayList.remove(j);
                j++;
            }
        }
        return anArrayList;
    }

    /**
     * from two sets, finds each element which exists in both sets and returns this sorted list of items.
     * @param listA the first list
     * @param listB the second list
     * @return a list of elements which occur in both sets.
     */
    public ArrayList<Double> findIntersection(ArrayList<Double> listA, ArrayList<Double> listB){
        //create new list object to return
        ArrayList<Double> intersection = new ArrayList<>();
        //find same elements and add to new list
        for(Double first : listA){
            for(Double second : listB){
                if(first.equals(second)){
                    intersection.add(first);
                }
            }
        }
        //sort and remove repeat elements
        return sortAndKeepUniqueElements(intersection);
    }

    //union also refers to adding probabilites.
    //ex P1 or P2 or P3 = P1 + P2 + P3

    /**
     * from two sets, creates a new set of elements consisting of the elements of both sets.
     * @param listA the first set
     * @param listB the second set
     * @return the elements of both sets
     */
    public ArrayList<Double> findUnion(ArrayList<Double> listA, ArrayList<Double> listB){
        //create new list object to return
        ArrayList<Double> union = new ArrayList<>();
        //add each element of A to union
        for(Double first : listA){
            union.add(first);
        }
        boolean match;
        int index;
        //for each element in B,
        for(Double second : listB){
            match = false;
            index = 0;
            //compare to each element in union
            while(index < union.size() && !match) {
                if(!second.equals(union.get(index))){
                    index++;
                    //if end of listB is reached,
                    if(index == union.size()){
                        //no match found
                        //add this unique element to union
                        union.add(second);
                    }
                }
                else{
                    match = true;
                }
            }
        }
        //finally sort and return union
        Collections.sort(union);
        return union;
    }

    /**
     * calculates the three central tendency values of a space and provides a
     * String representation of the output.
     * @param anArrayList the values of our space in a list
     * @return the mean, median, and mode of the space.
     */
    public String centralTendency(ArrayList<Double> anArrayList){
        String result = "";
        //call mean, median, mode methods
        //output each value and add it to the string
        //format the output
        return result;
    }


    /**
     * the compliment of the probability of an event is the total probability of the
     * sample space minus that event's probability within the same space.
     * @param probEvent the probability of the event occurring.
     * @return the total probability of the space minus the probability of an event.
     */
    public double complimentOfEvent(double probEvent){
        return 1 - probEvent;
    }

    //listSubsets method
        //method to return a string of individual subsets from a given set
        //should always include the empty set
        //dont need this for formal project

    //isProperSubset method
        //dont need this for formal project

    /**
     * calculates the ways a sample space can be split into different groupings of elements
     * as divided by the user.
     * @param space the total number of elements in the sample space.
     * @param coefficients the groups of those elements to consider which equal the total.
     * @return the amount of unique groupings that can be created.
     */
    public BigInteger calcMultinomialCoefficients(int space, int[] coefficients){
        //calculate numerator
        BigInteger total = calculateFactorial(space);
        BigInteger denominator = BigInteger.ONE;
        //calculate denominator
        for (int coefficient : coefficients) {
            denominator = denominator.multiply(calculateFactorial(coefficient));
        }
        //return the division
        return total.divide(denominator);
    }

    /**
     * calculates the number of permutations of an amount of elements resulting
     * from a set of elements. Note that the order of elements matters, and
     * duplicates are not allowed. uses the calculateFactorial helper method to calculate
     * each section of the formula before returning the full formula with those values
     * plugged in.
     * @param setElements the number of elements in the set
     * @param choices the number of elements in each permutation
     * @return the total possible permutations in the set
     */
    public BigInteger findPermutations(int setElements, int choices){
        //calc factorial of set elements
        BigInteger elementsFactorial = calculateFactorial(setElements);
        //subtract number of choices from number of elements
        int difference = setElements - choices;
        //calc factorial of difference
        BigInteger elementsMinusChoices = calculateFactorial(difference);
        //plug all values into permutations formula n! / (n-r)!
        return elementsFactorial.divide(elementsMinusChoices);
    }

    /**
     * calculates the number of combinations resulting from a set of elements
     * and how many elements to include in each resulting combination. Note that
     * order of the elements does not matter and duplicates are allowed. Uses the
     * calculateFactorial helper method to calculate each section of the formula
     * before returning the full formula with those values plugged in.
     * @param setElements the number of elements in the set
     * @param choices the number of elements in each combination
     * @return the total possible combinations in the set
     */
    public BigInteger findCombinations(int setElements, int choices){
        //check n >= r >= 0
        //calc factorial of set elements
        BigInteger elementsFactorial = calculateFactorial(setElements);
        //calc factorial of choices in the combination
        BigInteger choicesFactorial = calculateFactorial(choices);
        //subtract number of choices from number of elements
        int difference = setElements - choices;
        //calc factorial of difference
        BigInteger elementsMinusChoices = calculateFactorial(difference);
        //plug all values into combinations formula n! / r!(n-r)!
        return elementsFactorial.divide(elementsMinusChoices.multiply(choicesFactorial));
    }

    //probability axioms
        // a. The probability of an event occurring cannot be less than zero. P(A) >= 0
        // b. The total probability of events occurring in a set must be 100%. P(S) = 1
        // c. Probability of pairwise exclusive events are the sum of the possibilities.
            // eg. rolling an odd number on a 1d6 = 1/6 + 1/6 + 1/6 = 3/6 or 1/2

    /**
     * represents the probability axiom:
     * "The probability of an event occurring cannot be less than zero".
     * @return true if the probability is negative, false otherwise.
     */
    public boolean negativeAxiom(double probability){
        return probability < 0;
    }

    /**
     * represents the probability axiom:
     * "The total probability of events occurring in a set must equal exactly 100%".
     * @param probabilities the list of probabilities to consider.
     * @return true if the total equals 100%, false otherwise.
     */
    public boolean totalAxiom(ArrayList<Double> probabilities){
        return findListSum(probabilities) == 1.0;
    }

    //theorem of total Probability method
    //                    n
    //representing P(A) = E  P(A|Bi)P(Bi)
    //                   i=1
    //or, The Probability of all occurrences of an event A within a sample space is equal to
    //the sum from i to n of one occurrence of A given Bi occurred, times the probability of Bi.

    /**
     * calculates the probability of an event A in a space, or P(A), by using the Theorem of Total Probability.
     * The Theorem states: "The Probability of all occurrences of an event A within a sample space is
     * equal to the sum from i to n of each occurrence of A given Bi occurred, times the probability
     * of Bi". These sample space probabilities are subject to all the axioms of probability. --
     * The passed lists should be formatted so the first contains the probability of the desired event
     * within the respective sample space should that same index element be chosen from the second.
     * ex. eventA.get(i) is P(A|Bi).
     * @param eventA the list of events A, which have unique probabilities of occurring in their
     *               respective sample spaces.
     * @param eventB the list of events B, which have unique probabilities of occurring in their
     *               respective sample space and determine the probability of the respective event A.
     * @return the total probability of an event A in a sample space.
     */
    public double thmTotalProb(ArrayList<Double> eventA, ArrayList<Double> eventB) throws TotalProbabilityException {
        //amount of steps in the addition loop
        int bSize = eventB.size();
        //check that total prob of A = 1 and B = 1
        //if either total != 1,
        if(!totalAxiom(eventA) || !totalAxiom(eventB)){
            throw new TotalProbabilityException();
        }
        else {
            double result = 0;
            //for each event B,
            for(int i = 0; i < bSize; i++) {
                //multiply P(A|Bi) by P(Bi)
                result += eventA.get(i)*eventB.get(i);
            }
            return result;
        }
    }

    //addition rule
    //P(AuB) = P(A) + P(B) - P(AnB)

    //multiplication rule
    //P(AnB) = P(A)P(B|A) or P(B)P(A|B)

    /**
     * calculates the probability of an event occurring, given another event has
     * already occurred. represented by the formula P(A|B) = P(AnB) / P(B) .
     * @param probAnB the intersection of the events A and B.
     * @param probB the total probability that an event B will occur in some sample space.
     * @return the conditional probability of A given B, or P(A|B).
     */
    public double conditionalProb(double probAnB, double probB){
        //probB must be > 0
        return probAnB / probB;
    }

    //bayesTheorem method
    //P(B|A) = P(A|B)P(B) / P(A) or...
    //P(A|B) = P(B|A)P(A) / P(B)
    /* the probability of an event B, given an event A has occurred is...
    the probability of an event A, given an event B has occurred times the probability of an event B */
    //all over the probability of an event A
    //multiply P(AnB) x P(B)
    //divide by P(A)

    public double bayesTheorem(double probA, double probB){
        //get the intersection of the two probabilities
        //multiply the intersection by the probability of B
        //divide by the probability of A
        return 0;
    }

    //independent Vs Dependent intersection
    //exclusive vs not exclusive union ( i programmed exclusive already )

    //independence or dependency
    //given two events, P(A) and P(B)
    //if P(A|B) = P(A)
    //or P(B|A) = P(B)
    //or P(AnB) = P(A)P(B)
    //the events are independent
    //otherwise they are dependent.

    /**
     * calculates the binomial distribution for a set of values. Useful when data deals
     * with individual, independent trials resulting in either success or failure only.
     * @param n the number of trials conducted
     * @param y the intended number of successes
     * @param p the probability of success occurring in one trial
     * @return the probability of Y successes in N trials.
     */
    public double binomialDistribution(int n, int y, double p){
        //calculate combinations for N choose Y
        BigInteger combinations = findCombinations(n, y);
        //calculate q
        double q = 1 - p;
        //raise p to y
        double pRaisedY = Math.pow(p, y);
        //raise q to y - 1
        double qRaised = Math.pow(q, (n-y));
        //return combinations * p^y * q^y-1
        return combinations.longValue() * pRaisedY * qRaised;
    }

    /**
     * calculates the mean of the data using values provided in a problem
     * applying binomial distribution.
     * @param p the probability of success
     * @return the average value of the data.
     */
    public double binomialMean(double p){
        return 1 / p;
    }

    /**
     * calculates the variance of the data using values provided in a problem
     * applying binomial distribution.
     * @param p the probability of success.
     * @return the variance of the data.
     */
    public double binomialVariance(double p){
        double numerator = 1 - p;
        double denominator = Math.pow(p, 2);
        return numerator / denominator;
    }

    /**
     * calculates the geometric distribution for a set of values. Useful when data deals
     * with individual, independent trials resulting in either success or failure only.
     * @param y the number of trials
     * @param p the probability of success
     * @return the chance of finding the first success at the yth trial.
     */
    public double geometricDistribution(int y, double p){
        int trialsFailed = y - 1;
        double q = 1 - p;
        double qRaised = Math.pow(q, trialsFailed);
        return qRaised * p;
    }

    /**
     * calculates the probability of selecting a number of elements from the sample where
     * selecting an element would change the probability of subsequent selections. Useful for
     * problems involving a random variable with dependent events.
     * @param totalElements the total number of elements in the space.
     * @param totalChoices the total number of choices in the space.
     * @param y the number of elements we want to choose from the sample.
     * @param n the number of elements in the sample.
     * @return the probability of choosing y elements from n specific elements.
     */

    //Example:
    /*
    We have a raffle with our class where 3 prizes are chosen.
    Once a student is picked, they cannot win another prize.
    If 16 Students are Male and 7 are Female, what is the probability that 2 winners are male and 1 is female?
    Intersection: 2 male winners and 1 female winner
    Combinations: ways to choose 2 male students, ways to choose 1 female student
    Total = 23 choose 3
    Sample = 7 choose 1
    Remaining = 16 choose 2
    |7||16|
    |1|| 2|
    ------- = .47430 ~ 47.43% chance two winners are male and one is female.
     |23|
     | 3|
     */

    public double hyperGeometricDistribution(int totalElements, int totalChoices, int y, int n){
        //combinations of choices from the sample
        BigInteger nChooseY = findCombinations(n, y);
        //combinations of the remaining choices from the remaining set elements
        BigInteger remainingChooseRemaining = findCombinations(totalElements - n, totalChoices - y);
        //combinations of the total set choosing the total number of choices
        BigInteger totalCombinations = findCombinations(totalElements, totalChoices);
        //numerator = nCy * T-n C t-y
        BigInteger numerator = nChooseY.multiply(remainingChooseRemaining);
        return numerator.divide(totalCombinations).doubleValue();
    }

    /**
     * calculates the probability of finding a certain number of successes within
     * a number of trials where each trial is an independent event and the probability
     * of success remains the same from trial to trial.
     * @param y the amount of successes to find.
     * @param p the probability of success.
     * @param r the number of trials to conduct.
     * @return the probability of finding Y successes in R trials.
     */

    //Example
    /*
    A local coffee shop offers special lattes and coffees on their menu, most of which consumers
    ignore in favor of simple and familiar drinks. Some of these customers will step out of
    their comfort zone and try something different every once in a while. The management is
    questioning the time and budget that does into making these special drinks. Checking their
    sales, customers tried the special drinks 5 percent of the time when ordering. However,
    the baristas claim they spend a lot of time making these special drinks - about a third
    of their day at the bar. What is the probability that 1 out of every 3 customers order a special drink?

    p = .05
    y = 3
    r = 1
    |3-1|
    | C |(.05)^1(.95)^3-1 = .045125 ~ a 4.5% chance that one in three customers get a special.
    |1-1|
     */

    public double negativeBinomialDistribution(int y, double p, int r){
        //calculate combinations of successes - 1 choosing trials - 1
        BigInteger combinations = findCombinations(y - 1, r - 1);
        //chance to fail
        double q = 1 - p;
        //calculate pieces of equation
        double pRaisedR = Math.pow(p, r);
        double qRaised = Math.pow(q, y-r);
        //multiply each value and return
        return combinations.doubleValue() * pRaisedR * qRaised;
    }

    /**
     * calculates the mean of the sample space for a problem utilizing
     * negative binomial distribution.
     * @param p the probability of success
     * @param r the number of trials conducted
     * @return the average rate of success.
     */
    public double negativeBinomialMean(double p, int r){
        return r / p;
    }

    /**
     * calculates the variance of the sample space for a problem utilizing
     * negative binomial distribution.
     * @param p the probability of success.
     * @param r the number of trials conducted.
     * @return the variance of success over the trials.
     */
    public double negativeBinomialVariance(double p, int r){
        double numerator = r * (1-p);
        double denominator = Math.pow(p, 2);
        return numerator / denominator;
    }

    /**
     * the lambda, used in Poisson Distribution calculations, is a representation
     * of not only the mean of the data, but also the variance. It is calculated by
     * dividing the total number of events by the number of units measured, such as
     * hours, miles, etc.
     * @param k the number of events occurring.
     * @param n the units of measurement, per unit.
     * @return the average number of events per unit of measurement.
     */
    public double poissonLambda(double k, double n){
        //events per unit
        //k's per n
        return k / n;
    }

    /**
     * calculates the Poisson Distribution of a desired event in a sample space. Useful when
     * calculating the number of occurrences on a per-unit basis, such as units of time, speed,
     * area, volume, etc. It should be noted that the larger the number of trials become, the
     * smaller the chance of success of the event becomes - or, the success rate is
     * directly dependent on the region size.
     * @param lambda the mean; also the variance.
     * @param trials the number of trials to conduct
     * @return the chance of success within the performed trials space.
     */
    public double poissonDistribution(double lambda, int trials){
        //lambda raised to trials times...
        double lambdaRaisedTrials = Math.pow(lambda, trials);
        //euler's number raised to the negative lambda...
        double eulerRaisedNegLambda = Math.pow(EULERS_NUMBER, Math.negateExact((long) lambda));
        //all over the number of trials factorial
        BigInteger bigTrials = calculateFactorial(trials);
        return (lambdaRaisedTrials * eulerRaisedNegLambda) / bigTrials.longValue();
    }

    /**
     * the "within number" is associated with Tchebysheff's Theorem. It represents, when divided
     * by the standard deviation, the number of standard deviations about the mean in which the
     * random variable has a probability of existing.
     * @param lowBound the lower bound of the interval
     * @param highBound the higher bound of the interval
     * @param mean the average of the data
     * @return the "within number".
     * @throws WithinNumberException if the calculated values using each of the bounds do not match.
     */
    public double calcWithinNumber(double lowBound, double highBound, double mean) throws WithinNumberException{
        double withinNumberLower = mean - lowBound;
        double withinNumberUpper = highBound - mean;
        if(withinNumberLower == withinNumberUpper){
            return withinNumberLower;
        }
        else{
            throw new WithinNumberException();
        }
    }

    /**
     * calculates the probability that a number of observations lie in the given interval about
     * the mean, or "K" standard deviations about the mean.
     * @param lowBound the lower bound of the interval
     * @param highBound the upper bound of the interval
     * @param mean the mean of the data
     * @param stdDev the standard deviation of the data
     * @return the probability our random variable lies within the interval.
     */
    public double tchebysheffsTheorem(double lowBound, double highBound, double mean, double stdDev)
            throws WithinNumberException {
        //subtract lower bound from mean and mean from upper bound
        //these should be equal and are the "within number"
        double withinNumber = calcWithinNumber(lowBound, highBound, mean);
        //divide within number by standard deviation to get k
        double k = withinNumber / stdDev;
        double denominator = 1 - Math.pow(k, 2);
        //subtract 1/1-k^2 from 1 to get result
        return 1 - (1 / denominator);
    }
    private static final double EULERS_NUMBER = 2.7182818;

}
