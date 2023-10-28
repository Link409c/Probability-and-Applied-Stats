package Mini_Coding_Projects.Car_Factory;

import java.io.IOException;

public class FactoryTester {

    public static void main(String[] args){
        Factory myFactory = new Factory();

        System.out.println("Current year is: " + myFactory.calculateYear() + "\n");

        for(int i = 0; i < 6; i++){
            myFactory.makeCar();
        }

        for (Car c : myFactory.getTheCars()){
            System.out.printf("%7s%5s %-8s:%7s Miles\n", c.getColor(), c.getYear(),
                    c.getCarType(), c.getMiles());
        }

        String fileName = "testFile";
        try {
            System.out.println(myFactory.exportCars(fileName));
        }
        catch(IOException err){
            err.printStackTrace();
        }
   }
}
