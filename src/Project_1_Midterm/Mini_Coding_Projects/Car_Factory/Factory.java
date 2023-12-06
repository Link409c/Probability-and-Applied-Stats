package Project_1_Midterm.Mini_Coding_Projects.Car_Factory;

import Miscellaneous.Interfaces.CsvAble;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * The Project_1_Midterm.Mini_Coding_Projects.Car_Factory.Factory class makes cars and
 * exports the data as a .csv file for use in excel.
 * @author simpso61
 */

public class Factory implements CsvAble {

	/**
	 * makeCar calls the constructors of the Car class to produce a car object and add it to the list.
	 */
	public void makeCar() {
		//make car object
		Car car = new Car();
		//use setters and helper methods to assign values
		car.setColor(chooseColor());
		car.setCarType(chooseType());
		car.setMiles(chooseMiles());
		car.setYear(chooseYear());
		//add the car to the list
		getTheCars().add(car);
	}
	
	/**
	 * chooseType randomly returns a make to be used when constructing a car object. 
	 * Sedans are slightly more popular.
	 * @return a string make.
	 */
	public String chooseType() {
		Random r = new Random();
		int choice = r.nextInt(0, getTypes().length);
		return getTypes()[choice];
	}

	/**
	 * calculateYear method uses simple arithmetic to determine the current year
	 * using the milliseconds value given by a Date object.
	 * @return the current year in YYYY format.
	 */
	public int calculateYear(){

		Date d = new Date();
		//to calculate year, get milliseconds from date object
		long theYear = d.getTime();

		//use division
		//1000 ms in 1 second
		theYear /= 1000;
		//60 seconds in 1 minute
		theYear /= 60;
		//60 minutes in an hour
		theYear /= 60;
		//24 hours in a day
		theYear /= 24;
		//365 days in a year
		theYear /= 365;
		//initial milliseconds value is since 1970; add this to get current year
		theYear += 1970;

		return (int) theYear;
	}
	
	/**
	 * chooseYear selects a year for the car object, within the last 50 years.
	 * @return a random year within the last 50 years.
	 */
	public int chooseYear() {
		int withinLastFiftyYears = getCurrentYear() - 50;
		int upperYearsBound = getCurrentYear() + 1;
		Random randomYear = new Random();
		return randomYear.nextInt(withinLastFiftyYears, upperYearsBound);
	}
	
	/**
	 * chooseColor picks the color of the car object. Red is slightly more popular.
	 * @return a color string.
	 */
	public String chooseColor() {
		Random r = new Random();
		int choice = r.nextInt(0, getColors().length);
		return getColors()[choice];
	}

	public int chooseMiles(){
		int upperMilesBound = 250001;
		Random r = new Random();
		return r.nextInt(0, upperMilesBound);
	}

	public void importObjects(String fileName) throws IOException {

	}

	/**
	 * writes the contents of the cars arraylist to a csv file
	 * the user can explore and use to visualize and represent data in excel.
	 * The method is programmed using a relative path for the output file, placing the
	 * file in the project folder of Factory.java. This can be changed by the user for
	 * ease of navigation.
	 * @param fileName the name of the file to create, not including filetype suffix.
	 * @param header the header describing the fields of each column.
	 * @return a string informing the user the file has been created.
	 */
	@Override
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
			//for each car in the list,
			for (Car c : getTheCars()) {
				//write each line with the variables in order separated by commas
				//lets do Year, Color, Type, Miles.
				csvWriter.newLine();
				csvWriter.write(c.getYear() + "," + c.getColor() + ","
						+ c.getCarType() + "," + c.getMiles());
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

	public void importObjects(){
	}

	//constructors

	public Factory(){
		this.theCars = new ArrayList<>();
		this.types = new String[] {"Sedan", "Minivan", "Sport", "SUV", "Truck", "Sedan"};
		this.colors = new String[] {"White", "Black", "Blue", "Red", "Green", "Silver", "Red"};
		this.currentYear = calculateYear();
	}
	
	//global variables
	
	private ArrayList<Car> theCars;
	private String[] types;
	private String[] colors;
	private int currentYear;
	
	//getters and setters
	
	public ArrayList<Car> getTheCars() {
		return theCars;
	}

	public String[] getTypes() {
		return types;
	}

	public String[] getColors() {
		return colors;
	}

	public int getCurrentYear() {
		return currentYear;
	}

}
