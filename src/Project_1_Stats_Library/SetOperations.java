package Project_1_Stats_Library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * A program which can perform simple operations on sets of elements.
 */
public class SetOperations<E> {

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

    //compliment

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
    //listSubsets method
    //method to return a string of individual subsets from a given set
    //should always include the empty set
    //dont need this for formal project

    //isProperSubset method
    //dont need this for formal project
}
