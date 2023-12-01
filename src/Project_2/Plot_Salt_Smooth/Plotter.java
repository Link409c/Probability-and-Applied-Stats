package Project_2.Plot_Salt_Smooth;

import Miscellaneous.CsvAble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
* Plotter plots a number of points using a defined function. The program then outputs
* these values to a .csv file users can view in Excel or similar software.
**/

public class Plotter implements CsvAble {
  
  //function method
  //testing with simple parabola.
  public double calculateFunction(Double input){
    return Math.pow(input, 2);
  }

  /**
   * populates a list of pairs of associated inputs and outputs of a chosen function.
   */
  public void plotFunction() {
    int bound = getPointCount();
    //pointCount times,
    for (int i = 0; i < bound; i++){
      //run the calculate function method using each input
      double input = getInputs().get(i);
      //add the input and output to a tuple
      double output = calculateFunction(input);
      //add that tuple to the list of points
      Tuple<Double> t = new Tuple<>(input, output);
      getOutputPoints().add(t);
    }
  }

  /**
   * imports a list of input points to be used with the plotter.
   * @param fileName the name of the file to be accessed.
   * @throws IOException if fileName is null or path is invalid.
   */
  public void importObjects(String fileName) throws IOException {
    FileReader fileReader = new FileReader(fileName);
    BufferedReader bfr = new BufferedReader(fileReader);
    //assume first line of a .csv file is header
    bfr.readLine();
    ArrayList<Double> inputPoints = new ArrayList<>();
    //get all points in the .csv file
    String next = bfr.readLine();
    while(next != null){
      inputPoints.add(Double.parseDouble(next));
      next = bfr.readLine();
    }
    setInputs(inputPoints);
  }

  /**
   * exports the tuples of input and output points to a .csv file.
   * @param fileName the desired name of the file.
   * @param header the header describing each column of the file.
   * @return a message informing the user the file was created.
   */
  public String exportObjects(String fileName, String header){
    String successMsg = "";
    return successMsg;
  }

  public Plotter(int theCount){
    setPointCount(theCount);
    setOutputPoints(new ArrayList<>());
  }

  public int getPointCount() {
    return pointCount;
  }

  public void setPointCount(int pointCount) {
    this.pointCount = pointCount;
  }

  public ArrayList<Double> getInputs() {
    return inputs;
  }

  public void setInputs(ArrayList<Double> inputs) {
    this.inputs = inputs;
  }

  public ArrayList<Tuple<Double>> getOutputPoints() {
    return outputPoints;
  }

  public void setOutputPoints(ArrayList<Tuple<Double>> outputPoints) {
    this.outputPoints = outputPoints;
  }

  //number of points to plot
  private int pointCount;
  //input values to plot
  private ArrayList<Double> inputs;
  //data points to output to the csv
  private ArrayList<Tuple<Double>> outputPoints;
}
