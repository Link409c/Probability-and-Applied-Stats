package Miscellaneous;

import java.io.IOException;

/**
 * An interface designed to support classes which may create some data the user
 * wants to import from, or export to, a .csv file for use in Excel.
 */
public interface CsvAble {

    /**
    * importObjects takes a filename from parameters or input by the user and loads data
    * from lines of a .csv into a data structure. 
    */
    void importObjects(String fileName) throws IOException;

    /**
     * exportObjects creates a .csv file from a list of objects and their associated fields.
     * Assume the method throws an IOException due to the use of fileReader or BufferedReader.
     * @return a message informing the user if the file was created.
     */
    String exportObjects(String fileName, String header) throws IOException;
    //create string to return
    //create the csv file to pass to the constructor
    //using file writer object with the filename input
    //write the headers separated by commas on line 1
    //for each object in the list,
    //write each line with the variables in order separated by commas
    //after loop runs, close the file writer.
    //update success message informing user file was created.
    //if any error with filename occurs,
    //throw an IO exception informing the user of the error
    //return the success message
}
