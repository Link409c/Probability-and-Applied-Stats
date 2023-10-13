import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * The Stats Library Class is a custom class created to use in the Probability
 * and Applied Statistics course and beyond. The user can invoke its methods to
 * calculate several values associated with an object that represents a data set.
 */
public class StatsLibrary{

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
            differenceList.add(d - mean);
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
        for(Double d : anArrayList){
            double element = d;
            anArrayList.remove(d);
            element *= element;
            anArrayList.add(element);
        }
        return anArrayList;
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
    public double computeStandardDeviation(ArrayList<Double> anArrayList) {
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
                result.multiply(result);
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

    /**
     * from two sets, creates a new set of elements consisting of the elements of both sets.
     * @param listA the first set
     * @param listB the second set
     * @return the elements of both sets
     */
    public ArrayList<Double> findUnion(ArrayList<Double> listA, ArrayList<Double> listB){
        //create new list object to return
        ArrayList<Double> union = new ArrayList<>();
        //find unique elements and add to new list
        for(Double first : listA){
            for(Double second : listB){
                if(!first.equals(second)){
                    union.add(first);
                }
            }
        }
        //sort and remove repeat elements
        return sortAndKeepUniqueElements(union);
    }

    //findCompliment method
        //given a set S and a universal set P (population)
        //compliment is all elements of P that are not in S
        //example a hand of 5 cards and a deck of cards
        //the compliment of the hand of cards is the remaining cards in the deck.

    //listSubsets method
        //method to return a string of individual subsets from a given set
        //should always include the empty set
        //dont need this for formal project

    //isProperSubset method
        //dont need this for formal project

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

    //totalProbability method
    //representing 0 < P(B) < 1
    
    //conditionalProbability method
    // "B Given A"
    //the probability of an event given that another has occurred.
    //example choosing a red ball from a bag, when that bag has been chosen from a set of bags.

    //bayesTheorem method
    //P(B|A) = P(A|B)P(B) / P(A)
    //the probability of an event B, given an event A has occurred is...
    //the probability of an event A, given an event B has occurred times the probability of an event B
    //all over the probability of an event A

    //independent Vs Dependent
    //Probability of B vs B given A

    //probability mass function method

    //binomial distribution method
    //the number of combinations "N choose R" times...
    //(probability of success raised to the number of successes ) times...
    // probability of failure raised to (the number of successes minus 1)
    // | N |
    // | R | (p^y)(q^(y-1))

    //geometric distribution method


}
