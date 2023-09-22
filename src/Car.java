
public class Car {
	
	//constructors
	
	public Car(String aType, int aYear, String aColor, int theMiles) {
		this.carType = aType;
		this.year = aYear;
		this.color = aColor;
		this.miles = theMiles;
	}
	
	public Car() {}
	
	//getters and setters
	
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	
	//global variables
	
	private String carType;
	private int year;
	private String color;
	private int miles;
	
	
}