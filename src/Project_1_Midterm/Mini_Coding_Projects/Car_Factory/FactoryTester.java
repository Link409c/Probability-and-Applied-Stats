package Project_1_Midterm.Mini_Coding_Projects.Car_Factory;

import java.io.IOException;

public class FactoryTester {

    public static void main(String[] args){
        Factory myFactory = new Factory();

        //test current year calculation

        System.out.println("\nCurrent year is: " + myFactory.calculateYear() + "\n");

        //test car object creation

        for(int i = 0; i < 6; i++){
            myFactory.makeCar();
        }

        for (Car c : myFactory.getTheCars()){
            System.out.printf("%7s%5s %-8s:%7s Miles\n", c.getColor(), c.getYear(),
                    c.getCarType(), c.getMiles());
        }

        System.out.println();

        //test exporting to csv

        String fileName = "testFile";
        String header = "Color,Year,Type,Miles";
        try {
            System.out.println(myFactory.exportObjects(fileName, header));
        }
        catch(IOException err){
            err.printStackTrace();
        }

        //test exception handling

        System.out.println("\nTesting null case for exception handling: ");

        try {
            System.out.println(myFactory.exportObjects(null, header));
        }
        catch(IOException err){
            err.printStackTrace();
        }
   }
}
