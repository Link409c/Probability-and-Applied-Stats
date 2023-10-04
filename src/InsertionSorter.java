import java.util.ArrayList;

public class InsertionSorter<E>{

    public void insertionSort(ArrayList<E> myElements){
        //sentinel value is list length
        int n = myElements.size();
        //for loop checking each pair of elements
            //key = element to compare adjacent to
            //key is second element in array
            //this implementation sorts elements to the left of the key.
            //adjacent element is i - 1
            //while A[j] is greater than A[i] and j is greater than 0 (so we dont go past first element),
            //since the compared element is bigger move it to the right
            //then change index of j to compare previous element in list.
            //when either condition is not fulfilled we move to the next element as the key.

    }

    private ArrayList<E> elements;
}
