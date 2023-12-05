package Project_2.Plot_Salt_Smooth;

import Miscellaneous.CsvAble;

import java.io.*;
import java.util.ArrayList;

/**
* Plotter plots a number of points using a defined function. The program then outputs
* these values to a .csv file users can view in Excel or similar software.
**/

public class Plotter implements CsvAble {

  /**
   * plots output points using a simple function. In this case a parabola was chosen.
   * @param input the input value to pass to the function.
   * @return an associated output value.
   */
  public double calculateFunction(Double input){
    return Math.pow(input, 2);
  }

  /**
   * populates a list of pairs of associated inputs and outputs of a chosen function.
   */
  public void plotFunction() {
    int bound = getInputs().size();
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
  public String exportObjects(String fileName, String header) throws IOException{
    //string to return
    String successMsg;
    if(fileName != null){
      //create file writer object with the filename input
      fileName = fileName.concat(".csv");
      //specify an absolute path for file
      //change this if testing on your own PC
      String filePath = "E:\\Coding Projects\\Probability and Applied Statistics\\" +
              "src\\Project_2\\Plot_Salt_Smooth\\Files";
      filePath = filePath.concat("\\" + fileName);
      FileWriter toCsv = new FileWriter(filePath);
      BufferedWriter csvWriter = new BufferedWriter(toCsv);
      //write the headers separated by commas on line 1
      csvWriter.write(header);
      //for each object in the list,
      for (Tuple<Double> t : getOutputPoints()) {
        //write each line with the variables in order separated by commas
        csvWriter.newLine();
        csvWriter.write(t.getInput() + "," + t.getOutput());
      }
      //after loop runs, close the file writer.
      csvWriter.close();
      //update success message informing user file was created.
      successMsg = fileName + " created in the specified directory: \n " + filePath;
    }
    //if any error with filename or path occurs,
    else {
      //throw an IO exception informing the user of the error
      String errMsg = "Error in file name or path specified in export method.";
      throw new IOException(errMsg);
    }
    //return the success message
    return successMsg;
  }

  public Plotter(){
    setInputs(new ArrayList<>());
    setOutputPoints(new ArrayList<>());
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

  //input values to plot
  private ArrayList<Double> inputs;
  //data points to output to the csv
  private ArrayList<Tuple<Double>> outputPoints;
}
