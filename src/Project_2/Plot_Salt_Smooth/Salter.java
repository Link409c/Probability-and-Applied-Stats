package Project_2.Plot_Salt_Smooth;

import Miscellaneous.CsvAble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Salter takes a csv file input and "salts" the data by adding or subtracting from
 * each value to change the plot, effectively scattering the information on an observable graph.
**/

public class Salter implements CsvAble {

  //method to input the data
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

  //method to salt each data point
  public void salt(){
    //get each point from the list
    //add a random value to the y value
    //be able to configure the range of salt values
    //loop thru y values and +/- from each
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
