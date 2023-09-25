import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
//import java.util.GregorianCalendar;


/**
 * The Factory class makes cars and exports the data as a .csv file for use in excel.
 * @author simpso61
 *
 */

public class Factory {

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
		//GregorianCalendar theDate = new GregorianCalendar();
		Random randomYear = new Random();
		return randomYear.nextInt(getCurrentYear() - 50, getCurrentYear() + 1);
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
		Random r = new Random();
		return r.nextInt(0, 250001);
	}

	public File exportCars(ArrayList<Car> theCars) {
		File theExportFile = null;
		return theExportFile;
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

	public void setTheCars(ArrayList<Car> theCars) {
		this.theCars = theCars;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
}
