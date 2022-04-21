//--------------------------------------------
//Assignment 03
//Part 2
//© Waleed Ahmed Siddiqui
//Written by: Waleed Ahmed SIDDIQUI 40186042
//--------------------------------------------
package asg3;

import java.util.Scanner;

/**
 * TVShow class will assist in storing each TVShow.
 * @author Waleed Ahmed Siddiqui
 * @version 1.0
 */

public class TVShow implements Watchable {
	
	private String ShowID; //unique ID
	private String showName; //single word
	private double startTime; //24 hours format.
	private double endTime; //24 hours format.
	
	
	
	/**
	 * @author Waleed Ahmed Siddiqui
	 * @param ShowID - Each unique Show ID
	 * @param showName - Show name
	 * @param startTime - Show Start Time
	 * @param endTime - Show End Time
	 * Parameterized constructor
	 */
	public TVShow(String ShowID, String showName, double startTime, double endTime) { // Parameterized constructor
		this.ShowID=ShowID;
		this.showName=showName;
		this.startTime=startTime;
		this.endTime=endTime;
	}
	
	
	/**
	 * Copy Constructor
	 * @param showObj - TVShow Object
	 * @param value - Show ID
	 */
	public TVShow(TVShow showObj, String value) { //Copy Constructor
		
		this.ShowID=value;
		this.showName=showObj.showName;
		this.startTime=showObj.startTime;
		this.endTime=showObj.endTime;
		
	}
	
	/**
	 * Clone() method will clone TVShow object with new ShowID.
	 * @return TVShow
	 */
	
	public TVShow clone() {
		System.out.println("Please enter Show ID: ");
		Scanner sc = new Scanner(System.in);
		String showIDClone=sc.next();
		sc.close();
		return new TVShow(showIDClone,this.showName,this.startTime, this.endTime);
	}
	
	/**
	 * toString() method helps in printing TVShow attributes.
	 * @return String
	 */
	public String toString() {
		
		return this.ShowID +" "+ this.showName +" "+ this.startTime +" "+ this.endTime;
	}
	
	/**
	 * equals() method check if two TVShow are equal if they have same attributes except ShowID.
	 * @param showName - Show Name
	 * @param startTime - Show Start Time
	 * @param endTime - Show end Time.
	 * @return boolean
	 */
	
	public boolean equals(String showName, double startTime, double endTime) {
		
		if(this.showName.equals(showName) && this.startTime==startTime && this.endTime==endTime) 
			return true; 
		
		else
			return false;
	}
	
	
	/**
	 * IsOneSameTime is method of Watchable interface.
	 * This method check if two shows has Same time or Different times.
	 * @param tvshow1 - TVShow
	 * @return String
	 */
	
	@Override
	public String isOnSameTime(TVShow tvshow1) {
		String result="";
		if(this.startTime==tvshow1.getstartTime() && this.endTime==tvshow1.getendTime())
			return result="Same Time"; 
		
		else if(tvshow1.getstartTime() >= this.startTime && tvshow1.getstartTime() < this.endTime)
			return result="OverLaps";
		
		else 
			return result="Different Time";
		

	}
	
	/**
	 * mutator for ShowID
	 * @param s - ShowID
	 */
	
	public void setShowID(String s) {
		ShowID=s;
	}
	
	/**
	 * Accessor for ShowID
	 * @return String
	 */
	public String getShowID() {
		return ShowID;
	}
	
	/**
	 * mutator for Show Name
	 * @param s- Show Name
	 */
	public void setshowName(String s) {
		showName=s;
	}
	
	/**
	 * Accessor for Show Name
	 * @return String
	 */
	
	public String getshowName() {
		return showName;
	}
	
	/**
	 * mutator for Start Time
	 * @param s- Start Time
	 */
	
	public void setstartTime(double s) {
		startTime=s;
	}
	
	/**
	 * Accessor for Start Time
	 * @return Double
	 */
	
	public double getstartTime() {
		return startTime;
	}
	
	/**
	 * mutator for End Time
	 * @param s- End Time
	 */
	
	public void setendTime(double s) {
		endTime=s;
	}
	
	/**
	 * Accessor for End Time
	 * @return Double
	 */
	
	public double getendTime() {
		return endTime;
	}


}//TVShow
