package Project_2_Final.Stocks;

import Miscellaneous.Interfaces.CsvAble;
import Project_1_Midterm.Stats_Library_Set_Operations.StatsLibrary;
import Project_2_Final.Plot_Salt_Smooth.Tuple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Uses daily information on stocks to simulate assumed best practices
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
        //read a file from the program package files directory
        String filePath = "E:\\Coding Projects\\Probability and Applied Statistics" +
                "\\src\\Project_2_Final\\Stocks\\Files";
        //check for valid filetype (.csv)
        int fileTypeIndex = fileName.indexOf(".");
        //if invalid inform user
        if(!fileName.substring(fileTypeIndex).equalsIgnoreCase(".csv")){
            String errMsg = "importObjects: Passed file type is not valid. " +
                    "Pass a .csv file to the method.";
            throw new IOException(errMsg);
        }
        //else add file to path and read in data
        else {
            filePath = filePath.concat("\\" + fileName);
            FileReader fr = new FileReader(filePath);
            BufferedReader bfr = new BufferedReader(fr);
            //skip the header
            bfr.readLine();
            //parse each line
            String nextLine = bfr.readLine();
            //array for column values
            String[] columns;
            //create data container to populate
            StockDay nextDay;
            //loop while next line has data
            while (nextLine != null && !nextLine.equals("")) {
                //split the string at the commas
                columns = nextLine.split(",");
                //populate the StockDay object
                nextDay = populateDay(columns);
                //add it to the list
                annualDailyValues.add(nextDay);
                //update nextLine
                nextLine = bfr.readLine();
            }
            //set the global list
            setDaysData(annualDailyValues);
        }
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
        //export the data as a csv
        //per day,
        //display the date, total money, money earned, money spent, stocks bought, stocks sold?
        String successMsg = "";
        return successMsg;
    }

    /**
     * based on a series of calculations using daily stock values,
     * determine the next action the program takes to buy, sell, or
     * hold a stock.
     * @return positive to buy, zero to hold, negative to sell.
     */
    public int determineDailyAction(){
        //basic without RSI or more values
        //based on day to day
        //get the moving average of the close
        //compare it to previous days close
        //if close is higher sell
        //if close is lower buy
        //if close is within a value dont do anything

        //with RSI
        //if more up moves than down moves over a range,
        //if RSI is in a certain range,
        //couple this with moving average
        return 0;
    }

    public double movingAverage(String value, int midpoint, int window){
        //take sum of value indicated by passed string
        //get average
        return 0;
    }

    /**
     * helper method to buy a number of stocks.
     * @param numStocks the amount to buy.
     */
    public void buyStock(int numStocks, StockDay aDay){
        //multiply numStocks by close value
        double cost = numStocks * aDay.getClose();
        //if total cost will not cause us to go negative,
        if(cost < getMyMoney().doubleValue()) {
            //subtract this value from total money
            setMyMoney(getMyMoney().subtract(BigInteger.valueOf((long) cost)));
            //add numStocks to sharesOwned
            setSharesOwned(getSharesOwned() + numStocks);
        }
        //else buy as many shares as possible without going negative
        else{
            int numToBuy = (int) Math.floor(getMyMoney().doubleValue() / aDay.getClose());
            setSharesOwned(getSharesOwned() + numToBuy);
            cost = numToBuy * aDay.getClose();
            setMyMoney(getMyMoney().subtract(BigInteger.valueOf((long) cost)));
        }
    }

    /**
     * helper method to sell a number of stocks.
     * @param numStocks the amount to sell.
     */
    public void sellStock(int numStocks, StockDay aDay){
        //if numStocks is <= ownedShares,
        if(numStocks <= getSharesOwned()) {
            //multiply numStocks by close value
            double earnings = numStocks * aDay.getClose();
            //add this amount to our money
            setMyMoney(getMyMoney().add(BigInteger.valueOf((long) earnings)));
            //subtract numStocks from ownedShares
            setSharesOwned(getSharesOwned() - numStocks);
        }
        //else sell as many as possible without going negative
        else{
            //get the total value of all owned stocks at current day
            double earnings = getSharesOwned() * aDay.getClose();
            //add this amount to our money
            setMyMoney(getMyMoney().add(BigInteger.valueOf((long) earnings)));
            //set owned stocks to 0
            setSharesOwned(0);
        }
    }

    /**
     * updates data on the stock to determine amounts to buy or sell.
     */
    public int updateInternalData(){
        //updating central tendency
        //updating RSI
        /*
         What probability calculations can be applied here?
         */
        return 0;
    }

    /**
     * calculates the Relative Strength Index of the stock. Also
     * stores all up and down moves in a list used within the calculations.
     * @param date the date on which to calculate a specific RSI.
     * @return the RSI read as a percentage.
     */
    public double calculateRSI(String date){
        //get days data
        ArrayList<StockDay> daysCopy = getDaysData();
        //make list to hold move data
        ArrayList<Tuple<Double>> moves = new ArrayList<>(daysData.size());
        //get the index of the day with the passed date
        int indexOfDate = 0;
        for(StockDay day : daysCopy){
            if(day.getDate().equals(date)){
                indexOfDate = daysCopy.indexOf(day);
                break;
            }
        }
        //check that date is at least 14 days since start of data
        if(indexOfDate < 14){
            String errMsg = "Date must be at least 14 days since the start of the data.";
            throw new IllegalArgumentException(errMsg);
        }
        else {
            //subtract 14 from date index
            int start = indexOfDate - 14;
            //calculate up and down moves
            while(start < indexOfDate) {
                //get the difference between close and prev close
                double prevDayClose = daysCopy.get(start).getClose();
                double prevMinusOneDayClose = daysCopy.get(start-1).getClose();
                double closeDiff = prevDayClose - prevMinusOneDayClose;
                moves.add(new Tuple<>((double) start, closeDiff));
                start++;
            }
            //average up and down moves
            //3 methods
            //simple moving avg
            //separate moves into 2 lists of negatives and positives
            ArrayList<Double> upMoves = new ArrayList<>();
            ArrayList<Double> downMoves = new ArrayList<>();
            for(Tuple<Double> t : moves){
                double move = t.getOutput();
                //if negative move is down
                if(move < 0){
                    downMoves.add(move);
                }
                //if positive or 0 move is up
                else{
                    upMoves.add(move);
                }
            }
            StatsLibrary sl = new StatsLibrary();
            //sum up moves and down moves
            double avgU = sl.findMean(upMoves);
            double avgD = sl.findMean(downMoves);
            //exponential moving avg
            //wilder's smoothing method
            //calculate Relative Strength
            //avgU over avgD
            double rs = avgU / avgD;
            //calculate RSI using formula
            return 100 - (100 / (1 + rs));
        }
    }

    /**
     * runs the program, analyzing the data day by day until
     * no more data is available.
     * @param buyAmount the initial dollar amount to spend.
     * @return a String informing the user their profits or losses.
     */
    public String runProgram(double buyAmount){
        double startingMoney = getMyMoney().doubleValue();
        //buy some amount to start
        //check for valid buyAmount
        if(buyAmount > startingMoney){
            String errMsg = "Cannot spend more than you have. Input a buyAmount up to" +
                    "your total money.";
            throw new IllegalArgumentException(errMsg);
        }
        //if buyAmount is valid, buy as many stocks as possible with that money
        else{
            int numBuy = (int) Math.floor(buyAmount / getDaysData().get(0).getOpen());
            buyStock(numBuy, getDaysData().get(0));
        }
        //loop for each day of year
        int days = getDaysData().size();
        ArrayList<StockDay> daysCopy = getDaysData();
        for(int i = 0; i < days; i++) {
            StockDay currDay = daysCopy.get(i);
            //update heuristics (moving avg, RSI, etc) to get buy amount
            int numBuy = updateInternalData();
            //call determineDailyAction method
            int action = determineDailyAction();
            //buy sell or hold
            if(action > 0){
                buyStock(numBuy, currDay);
            }
            else if (action < 0){
                sellStock(numBuy, currDay);
            }
        }
        //after year of analysis, sell all shares and compare starting money vs current
        StockDay lastDay = getDaysData().get(getDaysData().size() - 1);
        sellStock(getSharesOwned(), lastDay);
        String result = "In trading the selected stock over one year, you ";
        if(getMyMoney().doubleValue() < startingMoney){
            result = result.concat("lost " + (startingMoney - getMyMoney().doubleValue()) + " dollars.");
        }
        else{
            result = result.concat("gained " + (getMyMoney().doubleValue() - startingMoney) + " dollars.");
        }
        return result;
    }
    public StockAnalyzer(){
        setDaysData(new ArrayList<>());
        setMyMoney(new BigInteger("10000"));
        setSharesOwned(0);
    }

    public int getSharesOwned() {
        return sharesOwned;
    }

    public void setSharesOwned(int numShares) {
        this.sharesOwned = numShares;
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
     * The amount of shares of the stock we own.
     */
    private int sharesOwned;
    /**
     * The simulated amount of money we have.
     */
    private BigInteger myMoney;
    /**
     * Holds various values for individual days' performance of a stock.
     */
    private ArrayList<StockDay> daysData;
}
