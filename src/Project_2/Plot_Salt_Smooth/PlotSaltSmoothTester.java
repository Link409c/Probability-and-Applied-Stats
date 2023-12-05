package Project_2.Plot_Salt_Smooth;

import java.io.IOException;
import java.util.Random;

/**
 * tester class for the plotter, salter, and smoother programs.
 */
public class PlotSaltSmoothTester {
    public static void main(String[] args) {
        Plotter plotter = new Plotter();
        Random r = new Random();
        //populate the list with random doubles
        for(int i = 0; i < 51; i++){
            double d = r.nextDouble(1, 5);
            plotter.getInputs().add(d);
        }
        //plot some values
        plotter.plotFunction();
        //export
        String fileName = "plotterTest";
        String header = "Input,Output";
        try {
            System.out.println(plotter.exportObjects(fileName, header));
        }catch(IOException i){
            i.printStackTrace();
        }
        //import
        //salt the values
        //export
        //import
        //smooth the values
        //export
    }
}
