package Project_2.Plot_Salt_Smooth;

import Miscellaneous.CsvAble;
import Project_1_Stats_Library.StatsLibrary;

import java.io.*;
import java.util.ArrayList;

/**
 * Smoother takes a list of data points, and using averages, "smooths" the scattering of the plot
 * to create a clearer, observable trend in a graph of sample points.
 */
public class Smoother implements CsvAble {

    /**
     * using a moving average, "smoothes" a list of data points to
     * clearly illustrate trends in the data.
     * @param window the size of the window to smooth values around.
     */
    public void smooth(int window) {
        StatsLibrary sl = new StatsLibrary();
        ArrayList<Tuple<Double>> points = getSmoothedPoints();
        int bound = points.size();
        double sum = -1;
        for(int i = 0; i < bound; i++) {
            //take y values from a range around a point
            //range is window
            //get values from i - n to i - 1 and i + 1 to i + n
            //average the points in the window and replace the point at x with the average
            //repeat for all points on the plot
            int lowBound = i - window;
            int upperBound = i + window;
            //set bounds to limits if outside range for list size
            if(lowBound < 0){
                lowBound = 0;
            }
            if(upperBound > bound){
                upperBound = bound;
            }
        }
    }

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
        setSmoothedPoints(plottedPoints);
    }

    /**
     * exports the tuples of input and output points to a .csv file.
     * @param fileName the desired name of the file.
     * @param header the header describing each column of the file.
     * @return a message informing the user the file was created.
     */
    public String exportObjects(String fileName, String header) throws IOException {
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
            //for each object in the list,
            for (Tuple<Double> t : getSmoothedPoints()) {
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

    public Smoother(){
        setSmoothedPoints(new ArrayList<>());
    }

    public ArrayList<Tuple<Double>> getSmoothedPoints() {
        return smoothedPoints;
    }

    public void setSmoothedPoints(ArrayList<Tuple<Double>> smoothedPoints) {
        this.smoothedPoints = smoothedPoints;
    }

    /**
     * The list of points whose outputs will be smoothed.
     */
    ArrayList<Tuple<Double>> smoothedPoints;
}
