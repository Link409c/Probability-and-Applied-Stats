import java.util.ArrayList;

/**
 * The Stats Library Class is a custom class created to use in the Probability
 * and Applied Statistics course and beyond. The user can invoke its methods to
 * calculate several values associated with an object that represents a data set.
 * @param <E> The class will accept generics but works best with lists.
 */
public class StatsLibrary<E>{

    /**
     * findMean computes the average of values in a list.
     * @param anArrayList the list to iterate
     * @return the average
     */
    public double findMean(ArrayList<E> anArrayList){
        double sum = 0;
        //assumes elements are numerical datatype
        if(!anArrayList.isEmpty()) {
            for (E element : anArrayList) {
                sum += (Double) element;
            }
        }
        return sum / anArrayList.size();
    }

    //findMode method
        //what is the best way?
        //sort then count each?
        //would need generic comparator
        //possibly use comparator with toString?
        //turn the list into a string and compare using substring?
        //otherwise use a list by unique elements then count approach

    //findMedian method
        //sort then find middle
        //return middle

    //computeStandardDeviation method
        //for each loop the list to get sum
        //divide to find mean
        //for each element, subtract the mean from it to get a new list of values
        //square each value
        //add the values
        //find the new mean
        //square the new mean
        //return the result

    //calculateFactorial method
    //does what it says.
    //use big integer object to avoid hitting integer limit on primitive int
    //lets use recursion

    //findIntersection method
        //compare each value
        //if they match add to a new list
        //return this list

    //findUnion method
        //add each value to a new list
        //check each value against the new list as added
        //if a value is repeated do not add it
        //return the new list

    //listSubsets method
        //method to return a string of individual subsets from a given set
        //should always include the empty set

    //isProperSubset method

    //091823: checking to test push and commits - it worked! had to set new remote URL

    //findPermutations method
    //accepts a list, and number of elements in a permutation
    //returns a list of each possible permutation of elements from the set

    //findCombinations method
    //accepts a list and number of elements in a combination
    //returns a list of each possible combination of elements from the set
    //note this differs from permutations; combinations can contain repeated elements

}
