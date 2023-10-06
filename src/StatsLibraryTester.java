import java.util.ArrayList;
import java.util.Random;

public class StatsLibraryTester {
    public static void main(String[] args) {

        Random r = new Random();
        ArrayList<Double> testList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testList.add(r.nextDouble(1, 100));
        }
        System.out.println("List:");
        for(Double e : testList) {
            System.out.printf("%.3f\n", e);
        }

        StatsLibrary myStatsTest = new StatsLibrary();
        //test mean, median, mode methods
        System.out.printf("Mean: %.3f ", myStatsTest.findMean(testList));
        System.out.printf("Median: %.3f ", myStatsTest.findMedian(testList));
        System.out.printf("Mode: %.3f ", myStatsTest.findMode(testList));

        System.out.println();
        testList.clear();
        for (int i = 0; i < 10; i++) {
            if(i%2 == 0){
                testList.add(2.0);
            }
            else{
                testList.add(r.nextDouble(1, 10));
            }
        }
        System.out.println("List:");
        for(Double e : testList) {
            System.out.printf("%.3f\n", e);
        }

        //test with a defined mode
        System.out.printf("Mean: %.3f ", myStatsTest.findMean(testList));
        System.out.printf("Median: %.3f ", myStatsTest.findMedian(testList));
        System.out.printf("Mode: %.3f ", myStatsTest.findMode(testList));

        //test factorial method
        int fact = 16;
        System.out.println();
        System.out.println(fact + " Factorial: " + myStatsTest.calculateFactorial(fact));

        //test combinations and permutations
        int totalElements = 4;
        int choiceNumber = 4;
        System.out.println("Permutations of a set of " + totalElements + " elements " +
                choiceNumber + " ways: " + myStatsTest.findPermutations(totalElements, choiceNumber));
        System.out.println("Combinations of a set of " + totalElements + " elements " +
                choiceNumber + " ways: " + myStatsTest.findCombinations(totalElements, choiceNumber));
    }
}
