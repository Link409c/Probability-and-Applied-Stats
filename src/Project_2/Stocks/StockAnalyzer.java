package Project_2.Stocks;

import Miscellaneous.CsvAble;
import Project_2.Plot_Salt_Smooth.Tuple;

import java.io.BufferedReader;
import java.io.FileReader;
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
     * @param fileName the file name to pass to the method.
     */
    public void importObjects(String fileName) throws IOException {
        ArrayList<StockDay> annualDailyValues = new ArrayList<>();
        //read the file
        FileReader fr = new FileReader(fileName);
        BufferedReader bfr = new BufferedReader(fr);
        //skip the header
        bfr.readLine();
        //parse each line
        String nextLine = bfr.readLine();
        while (nextLine != null) {
            //split the string at the commas
            String[] columns = nextLine.split(",");
            //populate a new StockDay object
            StockDay nextDay = populateDay(columns);
            annualDailyValues.add(nextDay);
            //update nextLine
            nextLine = bfr.readLine();
        }
        //add it to the global list
        setDaysData(annualDailyValues);
    }

    /**
     * populate the attributes of a StockDay object with csv data.
     * @param values a line of data from the .csv file
     * @return a populated StockDay object.
     */
    public StockDay populateDay(String[] values){
        StockDay newDay = new StockDay();
        //get index 0 as string date
        newDay.setDate(values[0]);
        //get index 1 - 5 as doubles
        newDay.setOpen(Double.parseDouble(values[1]));
        newDay.setHigh(Double.parseDouble(values[2]));
        newDay.setLow(Double.parseDouble(values[3]));
        newDay.setClose(Double.parseDouble(values[4]));
        newDay.setAdjustedClose(Double.parseDouble(values[5]));
        //get index 6 as long
        newDay.setVolume(Long.parseLong(values[6]));
        return newDay;
    }
    public String exportObjects(String fileName, String header){
        String successMsg = "";
        return successMsg;
    }

    publoc boolean doIBuy(){
        //basic without RSI or more values
        //based on day to day
        //get the moving average of the close
        //compare it to previous days close
        //if close is higher buy
        //if close is lower sell
        //if close is within a value dont do anything

        //with RSI
        //
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
    public double calculateRSI(int period){
        ArrayList<StockDay> daysCopy = getDaysData();
        //calculate up and down moves
        ArrayList<Tuple<Double>> moves = new ArrayList<>(daysData.size());
        //for each day in the window starting from a certain day,
        for(int i = 1; i < period; i++){
            //get the difference between close and prev close
            double prevDayClose;
            double prevMinusOneDayClose;
            double closeDiff = prevDayClose - prevMinusOneDayClose;
            //if positive or 0 move is up
            //if negative move is down
        }
        //average up and down moves
            //3 methods
            //simple moving avg
            //exponential moving avg
            //wilder's smoothing method
        //calculate Relative Strength
            //avgU over avgD
        double rs = avgU / avgD;
        //calculate RSI using formula
        return 100 - (100 / (1 + rs));
    }

    public StockAnalyzer(){
        setDaysData(new ArrayList<>());
        setMyMoney(new BigInteger("10000"));
    }

    public BigInteger getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(BigInteger myMoney) {
        this.myMoney = myMoney;
    }

    public ArrayList<StockDay> getDaysData() {
        return daysData;
    }

    public void setDaysData(ArrayList<StockDay> daysData) {
        this.daysData = daysData;
    }

    /**
     * The simulated amount of money we have.
     */
    private BigInteger myMoney;

    /**
     * Holds various values for individual days' performance of a stock.
     */
    private ArrayList<StockDay> daysData;
}
