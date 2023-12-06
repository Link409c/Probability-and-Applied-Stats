package Project_1_Midterm.Mini_Coding_Projects.Birthday_Problem;

import Miscellaneous.Interfaces.CsvAble;
import Project_1_Midterm.Stats_Library_Set_Operations.StatsLibrary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;


/**
 * This program models the "Birthday Problem", an experiment that finds the probability of
 * two individuals within a group sharing a birthday.
 */
public class BirthdayProblem implements CsvAble {
    /**
     * calculates the probability that in the sample space of people, some
     * number of them share a birthday. Uses methods defined in the Stats
     * Library program for calculations.
     * @return the probability of that number of individuals sharing a birthday within the sample space.
     */
    public double calcBDayProblem(){
        //get sample size
        int numOfPeople = getPeople().size();
        BigInteger days = BigInteger.valueOf(365);
        //create stats library object
        StatsLibrary calcBirthdays = new StatsLibrary();
        //calculate the total number of points in the sample space
        //365^n where n is the number of people
        BigInteger totalPoints = days.pow(numOfPeople);
        //calculate the number of sample points
        //first person 365/365, second person 364/365, etc.
        //365x364x363x...x365-n
        int difference = days.intValue() - numOfPeople;
        //get 365 factorial and 365 - n factorial
        BigInteger numerator = calcBirthdays.calculateFactorial(days.intValue());
        BigInteger denominator = calcBirthdays.calculateFactorial(difference);
        //365x364x...x(365-n+1)x(365-n)! divided by (365-n)! leaves us with first (365-n) elements multiplied
        BigInteger samplePoints = numerator.divide(denominator);
        //divide sample points by total points to get probability of nobody sharing a birthday
        double noneSharing = samplePoints.doubleValue() / totalPoints.doubleValue();
        //get the compliment to determine probability that at least two people share a birthday.
        return calcBirthdays.complimentOfEvent(noneSharing);
    }

    /**
     * returns a string of people whose birthdays match. if none match, returns a default message.
     */
    public String displayPeople(){
        ArrayList<Person> sharers = new ArrayList<>();
        //new addition: splitting the groups into subsets
        //split people who share birthdays into subsets by birthday
        //ArrayList<Person> tuples = new ArrayList<>();
        String result = "";
        ArrayList<Person> thePeople = getPeople();
        for(Person p : thePeople){
            for(Person q : thePeople){
                if(p != q) {
                    if (p.getBirthday() == q.getBirthday() && !sharers.contains(p) && !sharers.contains(q)) {
                        sharers.add(p);
                        sharers.add(q);
                    }
                }
            }
        }
        result = result.concat("People who share a birthday: ");
        String compare = result;
        for(Person s : sharers){
            result = result.concat(s.getName()).concat(", ");
        }
        //remove trailing regex characters
        result = result.replaceAll(", $", "");
        if(result.equals(compare)){
            result = "Nobody in this group shares a birthday.";
        }
        return result;
    }

    public void importObjects(String fileName){}

    /**
     * exports the list of people and their birthdays to a csv file.
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
            for (Person p : getPeople()) {
                //write each line with the variables in order separated by commas
                csvWriter.newLine();
                csvWriter.write(p.getName() + "," + p.getBirthday());
                //after loop runs, close the file writer.
            }
            csvWriter.close();
            successMsg = fileName + " created in the specified directory.";
        }
        else {
            String errMsg = "File name passed to the export method is null.";
            throw new IOException(errMsg);
        }
        return successMsg;
    }

    public BirthdayProblem(ArrayList<Person> thePeople){
        setPeople(thePeople);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    /**
     * The list of people with birthdays.
     */
    private ArrayList<Person> people;
}
