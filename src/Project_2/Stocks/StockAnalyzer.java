package Project_2.Stocks;

import Miscellaneous.CsvAble;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Uses daily information on stocks to simulate best practices
 * in buying and selling.
 */
public class StockAnalyzer implements CsvAble{

    /**
     * reads an input file and parses the data into the daysData
     * arraylist.
     * @param fileName
     */
    public void importObjects(String fileName) throws IOException {
        //read the file
        //skip the header
        //parse each line
        //split the string at the commas
        //read each value into a String, doubles, and long
        //populate a new StockDay object
        //add it to the blobal list
    }

    public String exportObjects(String fileName, String header){
        String successMsg = "";
        return successMsg;
    }

    /**
     * updates heuristics on central tendency of the stock data for
     * use in making financial decisions.
     */
    public void updateInternalData(){

    }

    /**
     * calculates the Relative Strength Index of the stock.
     */
    public void calculateRSI(){}

    /**
     * The simulated amount of money we have.
     */
    private BigInteger myMoney;

    /**
     * Holds various values for individual days' performance of a stock.
     */
    private ArrayList<StockDay> daysData;
}
