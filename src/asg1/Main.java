// --------------------------------------------
// Assignment 01
// Part 2B
// © Waleed Ahmed Siddiqui
// Written by: Waleed Ahmed SIDDIQUI 40186042
// --------------------------------------------

package asg1;

import java.util.Scanner;
import asg1.Vaccine.brand;

public class Main {
	
	

	private static int total_attempts=0; //Total login attempt.
	static int maxVaccines=0; //Max Vaccines.
	static int total_Vaccines=0; //total Vaccines capacity.
	static Vaccine inventory[]; //Vaccine storage Capacity.
	
	
	/**
	 * it will count all login attempts and if login attempts reached 12...
	 * ...it will shut down the program.
	 * 
	 */
	public static void securityWall() {
		total_attempts++;
		if(total_attempts==12) {
			System.out.println
			("Program detected suspicious activities and will terminate immediately!");
			System.exit(0); //terminating the program.
		}
		
	}
	
	/**
	 * Main display page
	 * This method will display all 5 options to user.
	 * 
	 */
	public static void displayMainMsg() {
		
		System.out.print("\nWhat do you want to do? \n"
				+ "1. Enter new vaccines (Password required) \n"
				+ "2. Change information of a vaccine (Password required) \n"
				+ "3. Display all the vaccines by a specific brand \n"
				+ "4. Display all the vaccines under a certain a price. \n"
				+ "5. Quit \n"
				+ "Please enter your choice >");
		
		Scanner sc0=new Scanner(System.in);
		int option=0;
		boolean flag=true;
		while(option<=0 || option>5) { //ask user to enter option from 1 to 5 only.
			
			
			
			if(flag!=false) {//except first attempt, it will ask choice again & again.
			    option= Integer.parseInt(sc0.next());
			    }
			
			else {//except first attempt, it will ask choice again & again.
				System.out.print("Please enter your choice between 1 to 5: ");
			    option= Integer.parseInt(sc0.next());
			    }
			
			    flag=false;
			}
		
		
		switch(option) { //after user input, choosing relevant method to proceed.
		case 1: {
			enterNewVaccine(); // to enter new vaccines
			break; }
			
		case 2:{
			changeVaccineInfo(); // to change current Vaccines entry.
			break; }

		case 3: { // to display only selected brand vaccines.
			
			System.out.print("Choose 1 for Astrazenecca \n"+
					"Choose 2 for Pfizer \n"+
					"Choose 3 for JohnsonAndJohnson \n"+
					"Please enter your choice >");
			
			Scanner sc = new Scanner(System.in);
			int op=Integer.parseInt(sc.next());
			 brand xbrand;
			switch (op){ //Since brand is in enum, we will ask user to enter digit to save Brand name
			case 1:
				xbrand=brand.Astrazenecca; //1- For AstraZenneca.
				findVaccinesByBrand(xbrand);
				break;
			case 2:
				xbrand=brand.Pfizer; //2- For Pfizer
				findVaccinesByBrand(xbrand);
				break;
			case 3:
				xbrand=brand.JohnsonAndJohnson;//3- For JohnsonAndJohnson
				findVaccinesByBrand(xbrand);
				break; 
				
			}//nested switch
			break;
			
		}//case 3
		
		case 4: {// to Show only less than input price vaccines.
			System.out.print("Please enter the price: ");
			Scanner sc = new Scanner(System.in);
			int select_price=Integer.parseInt(sc.next());
			findCheaperThan(select_price);
			break;
		}
		
		case 5:{
			    System.out.println("Program Closed"); // Program Close message.
				System.exit(0); }
			
		}
	}
	
	/**
	 * @author Waleed Ahmed SIDDIQUI 40186042
	 * this method will display information of selected vaccine.
	 * @param inventory_no
	 */
    public static void displayVaccineChangeMenu(int inventory_no) { //2.4
		
    	int inv_no=inventory_no;
		System.out.print("What information would you like to change? \n"
				+ "1. Brand \n"
				+ "2. Dose \n"
				+ "3. Expiry \n"
				+ "4. Price \n"
				+ "5. Quit \n"
				+ "Please enter your choice >");
		
		Scanner sc= new Scanner(System.in);
		int choice=0;
		
		while(choice<=0 || choice>5) { //Restrict user input from 1 to 5 only.
		choice=Integer.parseInt(sc.next()); }
		
		switch(choice) {
				
		case 1: {// to change brand name.
			System.out.print("Choose 1 for Astrazenecca \n"+
					"Choose 2 for Pfizer \n"+
					"Choose 3 for JohnsonAndJohnson \n"+
					"Please enter your choice >");
			
             int op=Integer.parseInt(sc.next());
			 brand xbrand;
			switch (op){ //Since brand is in enum, we will ask user to enter digit to save Brand name
			case 1:
				xbrand=brand.Astrazenecca; //1- For AstraZenneca.
				inventory[inventory_no].setBrand(xbrand);
				break;
			case 2:
				xbrand=brand.Pfizer; //2- For Pfizer
				inventory[inventory_no].setBrand(xbrand);
				break;
			case 3:
				xbrand=brand.JohnsonAndJohnson;//3- For JohnsonAndJohnson
				inventory[inventory_no].setBrand(xbrand);
				break; 
				
			}//nested switch
			displaySelectedVaccineInfo(inv_no); //Display Selected Vaccine information.
			displayVaccineChangeMenu(inv_no); 
			break;
			
			}//case 1	   
		
		case 2: {
			System.out.print("Enter new Dose: "); //to change dose.
			double dose=Double.parseDouble(sc.next());
			inventory[inventory_no].setDose(dose);
			displaySelectedVaccineInfo(inv_no);
			displayVaccineChangeMenu(inv_no);
			break;
		}//case 2
		
		case 3:{		//to change expiry date.
			System.out.print("Enter new Expiry Date -ie (01-12-2000): ");
			String e_date=sc.next();
			inventory[inventory_no].setExpiry_Date(e_date);
			displaySelectedVaccineInfo(inv_no);
			displayVaccineChangeMenu(inv_no);
			break;
			}//case 3
		
		case 4: { //to change price tag.
			System.out.print("Enter new Price: ");
			double price=Double.parseDouble(sc.next());
			inventory[inventory_no].setPrice_tag(price);
			displaySelectedVaccineInfo(inv_no);
			displayVaccineChangeMenu(inv_no);
			break;
			}//case 4
		
		
		case 5:{ //to go back to main menu.
			displayMainMsg();
			break;
		}//case 5
		
		}//Main switch
		
	}
	
    /**
     * To find vaccines with less then input price
     * @param price 
     */
	public static void findCheaperThan(double price) { //option 5.
		
         for(int i=0; i<total_Vaccines; i++) {
			
			if(inventory[i].getPrice_tag()<price) { // display only those vaccines which has less price.
				displaySelectedVaccineInfo(i);
			}
		}
		
		
	}
	
	/**
	 * Display selected vaccine information.
	 * @param inventory_no - ID number of Vaccine.
	 */
	public static void displaySelectedVaccineInfo(int inventory_no) {//2.3
		System.out.println("Vaccine: "+inventory_no);
		System.out.println("ID: "+(long) inventory[inventory_no].getId());
		System.out.println("Brand: "+inventory[inventory_no].getBrand());
		System.out.println("Dose: "+inventory[inventory_no].getDose());
		System.out.println("Expiry: "+inventory[inventory_no].getExpiry_Date());
		System.out.println("Price: "+inventory[inventory_no].getPrice_tag());
	
	}
	
	/**
	 * Find vaccines by only this brand name.
	 * @param xbrand - Brand name of Vaccine.
	 */
	public static void findVaccinesByBrand(brand xbrand) {// Option 3
		for(int i=0; i<total_Vaccines; i++) {
			
			if(inventory[i].getBrand().equals(xbrand)) {
				displaySelectedVaccineInfo(i);
			}
		}
	}
	
	
	/**
	 * to update any vaccine information.
	 */
	public static void updateVaccine() {//option 2.1
		
		Scanner sc= new Scanner(System.in);		
		System.out.print("Enter Vaccine number you wish to update: ");
		int vaccineNumber=Integer.parseInt(sc.next());
		
		try { //if vaccine id exist then do display all information.
			long id=(long) inventory[vaccineNumber].getId();
			displaySelectedVaccineInfo(vaccineNumber);			
			displayVaccineChangeMenu(vaccineNumber);			
			
		}
		
		catch(Exception e) {// if vaccine id doesn't exist then ask user to enter id again.
			System.out.print("Invalid Vaccine number \n"
					+ "Enter '1' For again  \n"
					+ "Enter '0' to go back to Main Menu \n"
					+ "----------------------------------> ");
			
			int choice = Integer.parseInt(sc.next());
			if(choice==1) {
				//Send to method.
				updateVaccine(); //if option is selected then do recursion of updateVaccine() method.
			}
			else
				displayMainMsg(); // else go back to main menu.
		}
		
	}//changeVaccineInfo()
	
	/**
	 * to enter new vaccine.
	 * @param n- number's of vaccines to be create.
	 */
	public static void newVaccineEntry(int n) { //option 1.1
		
		
		brand xbrand=brand.Astrazenecca;
		double dose;
		String expiry_date;
		long id;
		double price_tag;
		
		
		Scanner sc1= new Scanner(System.in);
		
		System.out.println("Only 3 Brands vaccine can be added:");
		System.out.println("Choose 1 for Astrazenecca \n"+
		"Choose 2 for Pfizer \n"+
		"Choose 3 for JohnsonAndJohnson \n");
		
		for(int i=0; i<n; i++) {
			System.out.println("Please enter #"+(i+1)+" Vaccine information.");
			System.out.print("Brand name: ");
			int op=sc1.nextInt();
			
			switch (op){ //Since brand is in enum, we will ask user to enter digit to save Brand name
			case 1:
				xbrand=brand.Astrazenecca; //1- For AstraZenneca.
				break;
			case 2:
				xbrand=brand.Pfizer; //2- For Pfizer
				break;
			case 3:
				xbrand=brand.JohnsonAndJohnson;//3- For JohnsonAndJohnson
				break; }
			
		    System.out.print("Dose : ");
		    dose= Double.parseDouble(sc1.next());
		    
		    System.out.print("Expiry Date Date-Month-Year i.e DD-MM-YYYY : ");
		    expiry_date= sc1.next();
		    
		    
		    id= i; //Vaccine id will be default serial number.
		    
		    
		    System.out.print("Price Tag : ");
		    price_tag= Double.parseDouble(sc1.next());
		    
		    //Submitting all information in through each new object.
		    inventory[i]=new Vaccine(xbrand,dose, expiry_date, id, price_tag); 
		    total_Vaccines=inventory[i].findNumberOfCreatedVaccines(); //storing each new vaccine quantity
			}
			//sc1.close();
			
		}
	
	
	
	
	/**
	 * Ask user for password in order to change vaccine.
	 * If password is right then check if vaccines inventory capacity enough to take new N Vaccines.
	 * else if password if wrong show user left login attempts.
	 */
	
	public static void enterNewVaccine() { //option 1:
		Scanner sc= new Scanner(System.in);
		final String pass="password";
		String user_pass="";
		int new_vaccines;
		
		System.out.print("Please enter password: ");
		
		
		int login_attempt=2;
		while(login_attempt>=0 ) { // count remaining login attempts.
			user_pass= sc.nextLine();
			
			if(user_pass.equals(pass)) { // if password is correct then.
				total_attempts=0;
				System.out.print("How many vaccines you would like to enter: ");
				new_vaccines=sc.nextInt();
				
				
				if(total_Vaccines==0 && new_vaccines<=maxVaccines) {//if input is less then vaccines capacity.
					newVaccineEntry(new_vaccines);//add N vaccines.
					System.out.print(new_vaccines+" new Vaccine has been added.");
					
				}
				
				else if(new_vaccines<=maxVaccines-total_Vaccines && total_Vaccines!=0) { //if input vacciness less then inventory. 

					newVaccineEntry(new_vaccines);
					System.out.print(new_vaccines+" new Vaccine has been added.");
					//displayMainMsg();
					}
				
				else { //Prompt user that inventory can hold only this amount of vaccines.
					
					
					System.out.print("You can enter upto "+(maxVaccines-total_Vaccines)+" Vaccines."); }
				    displayMainMsg();
				
				
				break; //break the loop once password matched.
				}
			else {
			System.out.println("Invalid Password");
			System.out.print("Login attempt left: "+ login_attempt+"\n");
			securityWall(); // on each failed login, securityWall func will be called to increment failed login counter.
			login_attempt--;		
				}
			
		}
		//sc.close();
		if(login_attempt==-1) { //after 3 failed login, show main display message.
			displayMainMsg();
		}
		
		
		
		
	}//option 1
	
	
	public static void changeVaccineInfo() {//option 2
		
		
		Scanner sc= new Scanner(System.in);
		final String pass="password";
		String user_pass="";	
		System.out.print("Please enter password: ");
			
		int login_attempt=2;
		while(login_attempt>=0 ) { //count remaining login attempts.
			user_pass= sc.nextLine();
			
			if(user_pass.equals(pass)) { //if password is correct then update vaccine.
				
				updateVaccine();
				
				
				break;//break the loop once password matched.
			}
			
				
	else {
	System.out.println("Invalid Password");
	System.out.print("Login attempt left: "+ login_attempt+"\n");
	login_attempt--; }
					
		}//while
			
		if(login_attempt==-1) { //after 3 failed login, show main display message.
			displayMainMsg();
		}
		
	}//option 2
	
	
	
	
	public static void main(String[] args) {
		
		
		
		System.out.print("Please enter the maximum Vaccine capacity: ");
		Scanner sc0= new Scanner(System.in);
		maxVaccines=Integer.parseInt(sc0.next()); //Take input from user on the max vaccines capacity.
		
		inventory= new Vaccine[maxVaccines]; //Initializing Inventory space.

		displayMainMsg(); //Display Main menu.	
	}

}
