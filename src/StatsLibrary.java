import java.util.ArrayList;

public class StatsLibrary<E>{

    /**
     * findMean computes the average of values in a list.
     * @param anArrayList the list to iterate
     * @return the average
     */
    public double findMean(ArrayList<E> anArrayList){
        double sum = 0;
        //assumes elements are numerical datatype
        for(E element : anArrayList){
            sum += (Double)element;
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
        //

}
