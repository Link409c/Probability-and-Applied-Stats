package Project_2.Plot_Salt_Smooth;

import Miscellaneous.CsvAble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Salter takes a csv file input and "salts" the data by adding or subtracting from
 * each value to change the plot, effectively scattering the information on an observable graph.
**/

public class Salter implements CsvAble {

  public void importObjects(String fileName) throws IOException {
    FileReader fileReader = new FileReader(fileName);
    BufferedReader bfr = new BufferedReader(fileReader);
    //assume first line of a .csv file is header
    bfr.readLine();
    ArrayList<Tuple<Double>> plottedPoints = new ArrayList<>();
    String next = bfr.readLine();
    while(next != null){
      //split the string to get both points
      int regex = next.indexOf(',');
      //parse substrings to doubles
      double x = Double.parseDouble(next.substring(0, regex));
      double y = Double.parseDouble(next.substring(regex + 1));
      //add points to list in a tuple
      plottedPoints.add(new Tuple<>(x, y));
      //get next line in file
      next = bfr.readLine();
    }
    setSaltedPoints(plottedPoints);
  }

  /**
   * changes the values of each output point by randomly
   * adding or subtracting from them.
   */
  public void salt(){
    ArrayList<Tuple<Double>> points = getSaltedPoints();
    Random r = new Random();
    int rand;
    //get each point from the list
    for(Tuple<Double> t : points) {
      //add or subtract a random value from the y value
      rand = r.nextInt(0, 101);
      if(rand <= 50) {
        t.setOutput(t.getOutput() + r.nextInt((int) (t.getOutput()*2.0)));
      }
      else{
        t.setOutput(t.getOutput() - r.nextInt((int) (t.getOutput()*2.0)));
      }
      //be able to configure the range of salt values
    }
    setSaltedPoints(points);
  }

  //method to output the data
  public String exportObjects(String fileName, String header){
    String successMsg = "";
    return successMsg;
  }

  public ArrayList<Tuple<Double>> getSaltedPoints() {
    return saltedPoints;
  }

  public void setSaltedPoints(ArrayList<Tuple<Double>> saltedPoints) {
    this.saltedPoints = saltedPoints;
  }

  //the plot data created with salt
  private ArrayList<Tuple<Double>> saltedPoints;
}
