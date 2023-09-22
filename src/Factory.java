
/**
 * The Factory class makes cars and exports the data as a .csv file for use in excel.
 * @author simpso61
 *
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
//import java.util.GregorianCalendar;

public class Factory {

	/**
	 * makeCar calls the constructors of the Car class to produce a car object and add it to the list.
	 */
	public void makeCar() {
		
	}
	
	/**
	 * chooseType randomly returns a make to be used when constructing a car object. 
	 * Sedans are slightly more popular.
	 * @return a string make.
	 */
	public String chooseType() {
		String theType = null;
		return theType;
	}
	
	/**
	 * chooseYear selects a year for the car object, within the last 50 years.
	 * @return
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
		String theColor = null;
		return theColor;
	}
	
	public File exportCars(ArrayList<Car> theCars) {
		File theExportFile = null;
		return theExportFile;
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
