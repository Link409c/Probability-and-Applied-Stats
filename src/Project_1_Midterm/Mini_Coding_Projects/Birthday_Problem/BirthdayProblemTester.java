package Project_1_Midterm.Mini_Coding_Projects.Birthday_Problem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BirthdayProblemTester {
    public static void main(String[] args) throws IOException {

        String filename = "names.txt";
        Random r = new Random();
        ArrayList<Person> people = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bfr = new BufferedReader(fileReader);
            for (int i = 0; i < 50; i++){
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
        double result = birthdayProb.calcBDayProblem() * 100;
        System.out.printf("In the list of %d people, there is a %.3f percent chance at least two of them share " +
                "the same birthday.", people.size(), result);
        System.out.println("\n" + birthdayProb.displayPeople());
        System.out.println(birthdayProb.exportObjects("BirthdayList", "Name,Birthday"));
        //test null case
        System.out.println("\nTesting null case for exception handling: ");
        System.out.println(birthdayProb.exportObjects(null, "Name,Birthday"));
    }
}
