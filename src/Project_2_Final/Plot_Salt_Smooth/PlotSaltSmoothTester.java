package Project_2_Final.Plot_Salt_Smooth;

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
        //import from plotter output file
        Salter salter = new Salter();
        fileName = fileName.concat(".csv");
        try{
            salter.importObjects(fileName);
        }catch(IOException i){
            i.printStackTrace();
        }
        System.out.println("Import Data from plotter output file:");
        for(Tuple<Double> t : salter.getSaltedPoints()){
            System.out.println(t.getInput() + ", " + t.getOutput());
        }
        //salt the values
        //export
        //import from salter output file
        //smooth the values
        //export
    }
}
