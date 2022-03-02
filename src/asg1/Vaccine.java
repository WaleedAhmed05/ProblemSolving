// --------------------------------------------
// Assignment 01
// Part 2A
// © Waleed Ahmed Siddiqui
// Written by: Waleed Ahmed Siddiqui 40186042
// --------------------------------------------
package asg1;

public class Vaccine {
	
	public static int objCounter=0; //to count objects.
	private double dose; //for Vaccine dose
	private String expiry_date; //for Vaccine expiry date.
	private long id;// except id //Vaccine Id-Serial Number.
	private double price_tag; //Vaccine Password.
	public enum brand {Astrazenecca, Pfizer, JohnsonAndJohnson}; //Pre defined vaccine brands.
	private brand ebrand; //Enum brand.
	
	{
		objCounter++; //to count number of objects.
	}
	
	/**
	 * @author Waleed Ahmed SIDDIQUI- 40186042
	 * Vaccine Constructor.
	 * @param ebrand
	 * @param dose
	 * @param expiry_date
	 * @param id
	 * @param price_tag
	 */
	
	Vaccine(brand ebrand,double dose, String expiry_date, long id, double price_tag) {
		this.ebrand=ebrand;
		this.dose=dose;
		this.expiry_date=expiry_date;
		this.id=id;
		this.price_tag=price_tag;
		
		
	}
			
	//Mutator to set Brand Name
	public void setBrand(brand xbrand) {
		
		ebrand=xbrand;
		
	}
	
	//Accessor to get Brand name
	public brand getBrand() {
		return ebrand;
	}
	
	//Mutator to set Dose.
	public void setDose(double Vaccine_dose) {
		dose=Vaccine_dose;
	}
	
	//Accessor to get Dose.
	public double getDose() {
		return dose;
	}
	
	//Mutator to set Expiry date.
	public void setExpiry_Date(String expiry_datee) {
		expiry_date= expiry_datee;
	}
	
	//Accessor to get Expiry Date.
	public String getExpiry_Date() {
		return expiry_date;
	}
	
	//Mutatators set Price.
	public void setPrice_tag(double prc_tag) {
		price_tag=prc_tag;
	}
	
	//Accessor to get Price tag.
	public double getPrice_tag() {
		return price_tag;
	}
	
	//Setting accessor for ID, since we are not allowed to set ID.
	public double getId() {
		return id;
	}
	
	//Overriding toString() method to return Vaccine all information.
	public  String toString() {
		return "Brand: "+ebrand +"\n"+"Dose: "+dose+"\n" +"Expiry Date: "+
	expiry_date+"\n" +"Price Tag: "+price_tag;
	}
	
	
	/**
	 * to compare two vaccines object with their brand and doses.
	 * @param xbrand
	 * @param xdose
	 * @return boolean
	 */
	public boolean equals(brand xbrand, double xdose) {
		
	
		if(xbrand==ebrand && dose ==xdose) { //if brand name and doses are same then two vaccines objects are same.
			
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * to return all quantity of vaccines objects.
	 * @return Integer
	 */
    public static int findNumberOfCreatedVaccines(){	
    	
    	
    	if(objCounter>0) {
    		return objCounter;
    	}
    	
    	else {
    		return 0;
    	}
    	
	}
	

}
