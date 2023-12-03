package Project_2.Plot_Salt_Smooth;

import Miscellaneous.CsvAble;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Salter takes a csv file input and "salts" the data by adding or subtracting from
 * each value to change the plot, effectively scattering the information on an observable graph.
**/

public class Salter implements CsvAble {

  /**
   * gets a list of input and output points from a .csv file
   * and adds them as tuples to the global list variable of the
   * salter.
   * @param fileName the name of the file to import values from.
   * @throws IOException if the fileName is null or invalid.
   */
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
   * changes the values of each output point by adding some value.
   * if the passed value is null, salt the points by randomly adding
   * or subtracting from them.
   * @param saltValue the value to add or subtract from each point.
   */
  public void salt(double saltValue){
    ArrayList<Tuple<Double>> points = getSaltedPoints();
    Random r = new Random();
    int rand;
    //get each point from the list
    for(Tuple<Double> t : points) {
      //salt according to passed value
      if (saltValue < 0 || saltValue >= 0) {
        rand = r.nextInt();
        if(rand % 2 == 0) {
          t.setOutput(t.getOutput() + saltValue);
        }
        else{
          t.setOutput(t.getOutput() - saltValue);
        }
      }
      //if saltValue was null, randomly apply a value
      else {
        rand = r.nextInt(0, 101);
        if (rand <= 50) {
          t.setOutput(t.getOutput() + r.nextInt((int) (t.getOutput() * 2.0)));
        } else {
          t.setOutput(t.getOutput() - r.nextInt((int) (t.getOutput() * 2.0)));
        }
      }
    }
    setSaltedPoints(points);
  }

  //method to output the data
  /**
   * exports the list of tuples to a csv file.
   * @param fileName the name of the file excluding filetype.
   * @param header the first line of the csv file explains column values.
   * @return a message informing the user of success or failure.
   */
  public String exportObjects(String fileName, String header) throws IOException{
    //string to return
    String successMsg;
    if(fileName != null){
      //create the csv file to pass to the constructor
      //using file writer object with the filename input
      fileName = fileName.concat(".csv");
      FileWriter toCsv = new FileWriter(fileName);
      BufferedWriter csvWriter = new BufferedWriter(toCsv);
      //write the headers separated by commas on line 1
      csvWriter.write(header);
      //for each person in the list,
      for (Tuple<Double> t : getSaltedPoints()) {
        //write each line with the variables in order separated by commas
        csvWriter.newLine();
        csvWriter.write(t.getInput() + "," + t.getOutput());
      }
      //after loop runs, close the file writer.
      csvWriter.close();
      //update success message informing user file was created.
      successMsg = fileName + " created in the specified directory.";
    }
    //if any error with filename occurs,
    else {
      //throw an IO exception informing the user of the error
      String errMsg = "File name passed to the export method is null.";
      throw new IOException(errMsg);
    }
    //return the success message
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
