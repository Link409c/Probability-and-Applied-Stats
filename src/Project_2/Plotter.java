package Project_2;

import Miscellaneous.CsvExportable;

import java.util.ArrayList;

/**
* Plotter plots a number of points using a defined function. The program then outputs
* these values to a .csv file users can view in Excel or similar software.
*
**/

public class Plotter implements CsvExportable {
  
  //function method
  //testing with simple parabola.
  public double calculateFunction(Double input){
    return Math.pow(input, 2);
  }

  /**
   * populates a list of pairs of associated inputs and outputs of a chosen function.
   * @param inputs the list of inputs to use.
   */
  public void plotFunction(Double[] inputs) {
    int bound = getPointCount();
    //pointCount times,
    for (int i = 0; i < bound; i++){
      //run the calculate function method using each input
      double input = inputs[i];
      //add the input and output to a tuple
      double output = calculateFunction(input);
      //add that tuple to the list of points
      Tuple<Double> t = new Tuple<>(input, output);
      getOutputPoints().add(t);
    }
  }

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

  public ArrayList<Tuple<Double>> getOutputPoints() {
    return outputPoints;
  }

  public void setOutputPoints(ArrayList<Tuple<Double>> outputPoints) {
    this.outputPoints = outputPoints;
  }

  //number of points to plot
  private int pointCount;
  //data points to output to the csv
  private ArrayList<Tuple<Double>> outputPoints;
}
