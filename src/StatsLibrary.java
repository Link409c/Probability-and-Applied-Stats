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
        //get sum of the list elements
        //divide to find mean
        double mean = findMean(anArrayList);
        //for each element, subtract the mean from it to get a new list of values
        anArrayList = findDifferenceOfValuesAndMean(anArrayList, mean);
        //square each value
        anArrayList = squareList(anArrayList);
        //get sum of the list elements
        //find the new mean
        mean = findMean(anArrayList);
        //take the square root of the mean
        //return the result
        return Math.sqrt(mean);
    }

    //findVariance method

    /**
     * calculates the factorial representation of a number returning a BigInteger object.
     * This allows the method to avoid any overflow that would occur if using primitive
     * datatypes.
     * @param l the number to calculate
     * @return the factorial of the input
     */
    public BigInteger calculateFactorial(int l){
        long result = l;
        while(l > 1){
            l--;
            result *= l;
        }
        return BigInteger.valueOf(result);
    }

    //findIntersection method
        //compare each value
        //if they match add to a new list
        //return this list

    //findUnion method
        //add each value to a new list
        //check each value against the new list as added
        //if a value is repeated do not add it
        //return the new list

    //findCompliment method

    //listSubsets method
        //method to return a string of individual subsets from a given set
        //should always include the empty set
        //dont need this for formal project

    //isProperSubset method
        //dont need this for formal project

    //findPermutations method
    //accepts a list, and number of elements in a permutation
    //returns a list of each possible permutation of elements from the set

    //findCombinations method
    //accepts a list and number of elements in a combination
    //returns a list of each possible combination of elements from the set
    //note this differs from permutations; combinations can contain repeated elements

    //totalProbability method
    
    //conditionalProbability method

    //bayesTheorem method

    //independentVsDependent

    //probability mass function method
}
