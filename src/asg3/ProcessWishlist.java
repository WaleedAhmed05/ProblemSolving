//--------------------------------------------
//Assignment 03
//Part 2
//© Waleed Ahmed Siddiqui
//Written by: Waleed Ahmed SIDDIQUI 40186042
//--------------------------------------------
package asg3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class has main method to read files and decide which TVShow a user can watch.
 * @author Waleed Ahmed Siddiqui
 * @version 1.0
 */
public class ProcessWishlist {
	
	public static ArrayList<String> uniqueShowID= new ArrayList<String>();
	public static ArrayList<String> currentWatchingList= new ArrayList<String>();
	public static ArrayList<String> watchList= new ArrayList<String>();
	
	/**
	 * UserWatchlist() - This method decides which TVShow a user can watch.
	 * @param listOne - ShowList
	 */
	
	public static void UserWatchList(ShowList listOne) {
		
for(int i=0; i<watchList.size(); i++) {
			
			if(listOne.contains(watchList.get(i))) {

			boolean flag_same_time=false;
			boolean flag_overLaps=false;
			
			
			
				if(listOne.contains(currentWatchingList.get(0))) {
					
					String result=listOne.find(currentWatchingList.get(0)).getShow().isOnSameTime(
							listOne.find(watchList.get(i)).getShow()
							);
					
					
					if((result.equals("OverLaps") )||(result.equals("Same Time") )) {
						flag_same_time=true;
						//break;
					}
					
					
				}
				
			
			for(int j=1; j<currentWatchingList.size(); j++) {
				
				
				if(listOne.contains(currentWatchingList.get(j))) {
				String result=listOne.find(currentWatchingList.get(j)).getShow().isOnSameTime(
						listOne.find(watchList.get(i)).getShow()
						);
				
				
				//System.out.println(result);
				if((result.equals("OverLaps") )||(result.equals("Same Time") )) {
					flag_overLaps=true;
					 break;
					}
				
				}
				
			}// For loop J
			
			
			//System.out.println(flag_same_time);
			 if(flag_same_time==true ) {
					System.out.println("User can't watch show "+watchList.get(i)
					+" as he/she is not finished with a show he/she"
					+ " is watching.");
				}
			
			else if(flag_overLaps==true) {
				System.out.println("User can't watch show "+watchList.get(i)
				+" as he/she will begin another show at the same time.");
			}
			 
			
			
			else {
				System.out.println("User can watch show "+watchList.get(i)
				+" as he/she is not watching anything else during that time");
			}
			
			
			
			
			}
		}//For loop i
		
	}//UserWatchList()
	
	
	public static void testShowList(ShowList listOne) {
		
		System.out.println("Choose operation: \n"+
		"1: Add node at start. \n"+
		"2: Add node at the end. \n"+
		"3: Add node by Index position. \n"+
		"4: Delete first node. \n"+
		"5: Delete last node. \n"+
		"6: Delete node by Index position \n"+
		"7: Replace node by Index position \n"+
		"8: Find TVShow Id in list. \n"+
		"9: Check if TVShow Id exist. \n"+
		"10: Copy list from original list (Deep Copy) \n"+
		"0: Exit ");
		
		Scanner scan= new Scanner(System.in);
		int choice= scan.nextInt();
		scan.close();
		
		TVShow testShow= new TVShow("WXZ22","Black_Mirror",21.00,22.00);
		
		switch(choice) {
		case 1:{
			
			System.out.println("---------Before---------");
			listOne.show();
			System.out.println("\n---------After---------");
			listOne.addToStart(testShow);
			listOne.show();
		
			break;
			}
		case 2:{
			
			System.out.println("---------Before---------");
			listOne.show();
			System.out.println("\n---------After---------");
			listOne.insertAtend(testShow);
			listOne.show();
		
			break;
			}
		case 3:{
			
			System.out.println("---------Before---------");
			listOne.show();
			System.out.println("\n---------After---------");
			listOne.insertAtIndex(testShow, 4);
			listOne.show();
		
			break;
			}
		case 4:{
			
			System.out.println("---------Before---------");
			listOne.show();
			System.out.println("\n---------After---------");
			listOne.deleteFromStart();
			listOne.show();
		
			break;
			}
		case 5:{
			
			System.out.println("---------Before---------");
			listOne.show();
			System.out.println("\n---------After---------");
			listOne.deleteFromEnd();
			listOne.show();
		
			break;
			}
		case 6:{
			
			System.out.println("---------Before---------");
			listOne.show();
			System.out.println("\n---------After---------");
			listOne.deleteFromIndex(4);
			listOne.show();
		
			break;
			}
		case 7:{
			
			System.out.println("---------Before---------");
			listOne.show();
			System.out.println("\n---------After---------");
			listOne.replaceAtIndex(testShow, 4);
			listOne.show();
		
			break;
			}
		case 8:{
			
			System.out.println("---------LIST---------");
			listOne.show();
			System.out.println("\n--Search ID----\"PBS21\"---");
			if(listOne.findx("PBS21")!=null) {
				System.out.println("Show ID Found ");
				System.out.println("Total Iterations: "+listOne.totat_iterations);
			}
			else {
				System.out.println("No such ShowID exist...");
			}
		
			break;
			}
		case 9:{
			
			System.out.println("---------LIST---------");
			listOne.show();
			System.out.println("\n--List Contains ID---\"PBS21\"--?");
			System.out.println(listOne.contains("PBS21"));
			break;
			}
		case 10:{
			
			System.out.println("------Orignal List-------");
			listOne.show();
			ShowList cloneList = new ShowList(listOne);
			listOne.deleteFromEnd();
			listOne.deleteFromStart();
			System.out.println("\n-------Clone List---------");
			cloneList.show();
		
			break;
			}
		
		default:
			System.exit(0);
				break;
		}
	}
	
/**
 * Main method will read files content and store them in ShowList data Structure.
 * This method also ensure to store unique TVShow ids.
 *  
 */
	public static void main(String[] args) {
		
		//Default user Directory Path.
		String defaultpath=System.getProperty("user.dir")+"\\src\\asg3\\"; 
		
		ShowList listOne = new ShowList();// Primary List.
		ShowList listTwo;// Secondary List to test ShowList Functions.
		
		
		Scanner sc = null; // Scanner to read TVGuide file
		Scanner interest_sc= null; //Scanner to Read Interest file
		Scanner userInput=null; // Scanner to read user Inputs
		
		String userGivenWatchList;
		
		
		
		try {
			FileReader file_reader=new FileReader(defaultpath+"TVGuide.txt");//CHANGE this to any file name
			BufferedReader bf_reader= new BufferedReader(file_reader);
			sc= new Scanner(bf_reader);
			
			String defaultWatchList="Interest.txt";
			
			//System.out.println("Please Enter WatchList file name: "); //UNCOMMENT
			//userGivenWatchList=userInput.next();
			FileReader interest_reader=new FileReader(defaultpath+"Interest.txt");
			
			BufferedReader interest_bf= new BufferedReader(interest_reader);
			interest_sc= new Scanner(interest_bf);
			
			boolean flag=false;
			while (interest_sc.hasNextLine()) {// For reading current watching shows		
				String temp=interest_sc.next();
				if(temp.equals("Wishlist"))
					break;
				if(!temp.equals("Watching")) {
					currentWatchingList.add(temp);
				}
			}
			while (interest_sc.hasNextLine()) {// For reading future watchlist shows		
				String temp=interest_sc.next();
				watchList.add(temp);
			}
			
		
			
			while (sc.hasNextLine()) {//keep iterations running untill scanner has another line. 

				String[] oneTVShowLine= new String[6]; //temporary DS to store one Record.

				for(int i=0; i<6; i++) {
					
					String temp=sc.next();
					if(temp!="") {
					oneTVShowLine[i]=temp;	
					}

				}
				
				if(!uniqueShowID.contains(oneTVShowLine[0])) { //Store unique TVShow ID's
					uniqueShowID.add(oneTVShowLine[0]);
					
					listOne.addToStart(new TVShow(oneTVShowLine[0],oneTVShowLine[1],
							Double.parseDouble(oneTVShowLine[3]),Double.parseDouble(oneTVShowLine[5])));
					
				}//If block
							
			}//while block
				
			
		}//try block
			
		
		catch(Exception e) {// To read any undesirable file handling exception.
			System.out.println("error");
		}
		
		finally { //To close all open scanners.
			sc.close();
			interest_sc.close();
			//userInput.close();
			
		}	
		
		listTwo= new ShowList(listOne);
		
		UserWatchList(listOne);
		System.out.println();
		testShowList(listOne);
		
		/*
		System.out.println();
		Scanner sc1=new Scanner(System.in);
		System.out.print("Please Enter Show ID: ");
		String findShowID=sc1.next();
		sc1.close();
		
		
		if(listOne.findx(findShowID)!=null) {
			System.out.println("Show ID Found ");
			System.out.println("Total Iterations: "+listOne.totat_iterations);
		}
		else {
			System.out.println("No such ShowID exist...");
		}
		*/
		
		
	}
}
