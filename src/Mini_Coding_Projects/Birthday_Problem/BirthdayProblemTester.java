package Mini_Coding_Projects.Birthday_Problem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BirthdayProblemTester {
    public static void main(String[] args) {

        String filename = "names.txt";
        Random r = new Random();
        ArrayList<Person> people = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bfr = new BufferedReader(fileReader);
            for (int i = 0; i < 10; i++){
                try {
                    people.add(new Person(bfr.readLine(), r.nextInt(1,366)));
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }
        BirthdayProblem birthdayProb = new BirthdayProblem(people);
        double result = birthdayProb.calcBdayProblem() * 100;
        System.out.printf("In the list of %d people, there is a %.3f percent chance at least two of them share " +
                "the same birthday.", people.size(), result);
    }
}
