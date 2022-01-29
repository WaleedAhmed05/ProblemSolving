package lab2;


import java.util.Scanner;


public class Lab2B {
	
/*
 * @author Waleed Ahmed siddiqui
 * @version 1.0
 * Program: Snake/Ladder
 * Problem Statement: https://labs6481.encs.concordia.ca/team/problems/6/text	
 */
	
	
	/**
	 * sort_func - It will sort the Snakes and Ladder values in ascending order.
	 * @param unordered array.
	 * @return ascending_order_sorted_array 
	 **/
	
public static int[] sort_func(int arr[]) {
		
	
				for (int i = 0; i < arr.length; i++)   
				{  
				for (int j = i + 2; j < arr.length; j++)   
				{  
				//Swapping the minimum value on each iteration
				int tmp = 0; 
				int tmp2=0;
				if (arr[i] > arr[j])   
				{
					
				tmp = arr[i];  
				arr[i] = arr[j];  
				arr[j] = tmp; 
				
				//Swapping the 2nd value of each pair.
				tmp2=arr[i+1];
				arr[i+1]=arr[j+1];
				arr[j+1]=tmp2;
				
				}
				j++;
				}  
				i++;
				}
				
		//return sorted array
		return arr;
	}
	

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int quantity=sc.nextInt(); //Number of times, you want to place Snake & Ladder on board
		int Snake_ladder_digits[]= new int[quantity*2]; //All Snakes/Ladder initial and ending values.
		
		for (int i=0; i<quantity*2; i++) {
			
			while(Snake_ladder_digits[i]<1 || Snake_ladder_digits[i]>=100 )
			{
				
			Snake_ladder_digits[i]=Integer.parseInt(sc.next()); }
		}
			
		//Sorting an unordered array by first value in ascending order.
		Snake_ladder_digits=sort_func(Snake_ladder_digits);
			
		int numberOfTurns=0;
		
		while(numberOfTurns==0 || numberOfTurns%2==1)
		{
		numberOfTurns=sc.nextInt(); //Number of moves.
		}
		
		int[] players_turns = new int[numberOfTurns]; //All moves from 1 to 6 store in this array.
	
		for (int k=0; k<numberOfTurns; k++) {
			
			players_turns[k]=-1;
			while(players_turns[k]<0 || players_turns[k]>=7) {
				
			players_turns[k]=Integer.parseInt(sc.next());}
			
		}
		
		int score_A=1;
		int score_B=1;
		for(int i=0; i<numberOfTurns; i++) {
		score_A+=players_turns[i];
		score_B+=players_turns[i+1];
		
		
			for (int j=0; j<Snake_ladder_digits.length; j++) {
			
				if (score_A==100 || score_B==100) {
					break;
				}
				if (score_A==Snake_ladder_digits[j]) {
					score_A=Snake_ladder_digits[j+1];
					
				}
				
				if (score_B==Snake_ladder_digits[j]) {
					score_B=Snake_ladder_digits[j+1];
					
				}
				
				
								
				j++;
				
			}
			
			i++;
			}
		
		
		
		//Checking the max score, which is nearest to 100.
		
		if(score_A<score_B) {
			System.out.println("B"+" "+score_B);
		}
		else {
			System.out.println("A"+" "+score_A);
		}
	    
	sc.close();
		
	}//main

}//Class
