package lab3;
/**
 * @author Waleed Ahmed siddiqui
 * @version 1.0
 * Program: Team players rank on Statistics.
 * Problem Statement: https://labs6481.encs.concordia.ca/team/problems/9/text	
 **/


import java.util.Scanner;
public class Lab3B {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int[] inp_1 = new int[2];
		inp_1[0]=Integer.parseInt(sc.next()); //total playes
		inp_1[1]=Integer.parseInt(sc.next()); //rank
		
		String[] player_names=new String[inp_1[0]]; // Array for storing all players names.
		double[] player_values=new double[inp_1[0]*4]; //Array for storing player foul shots, field goals, baskets made & no's of minutes
		double[] final_score=new double[inp_1[0]]; //Storing final scores of all players.
		int[] rounded_values= new int[inp_1[0]]; //Storing final round off score values.
		
		
		
		int ultra_counter=0;
		for (int i=0; i<inp_1[0]; i++) {
			player_names[i]=sc.next();
			
			player_values[ultra_counter]=Integer.parseInt(sc.next());
			ultra_counter++;
			player_values[ultra_counter]=Integer.parseInt(sc.next()); //1
			player_values[ultra_counter]*=2;
			ultra_counter++;
			
			
			player_values[ultra_counter]=Integer.parseInt(sc.next()); //2
			player_values[ultra_counter]*=3;
			ultra_counter++;
			
			player_values[ultra_counter]=Integer.parseInt(sc.next()); //3
			ultra_counter++;
		}
		
	
		
		      //score_calculator
		        ultra_counter=0;
				for (int i=0; i<inp_1[0]; i++) {
					//System.out.println("inside loop");
					final_score[i]+=player_values[ultra_counter];
					ultra_counter++;
					final_score[i]+=player_values[ultra_counter];
					ultra_counter++;
					final_score[i]+=player_values[ultra_counter];
					ultra_counter++;					
					final_score[i]/=player_values[ultra_counter];
					ultra_counter++;
					final_score[i]*=1000;
				    rounded_values[i]=(int)Math.round(final_score[i]);
					
					
				}
		
		
		//Sorting players scores with relevent names.
		for (int i = 0; i < rounded_values.length; i++)   
		{  
		for (int j = i + 1; j < rounded_values.length; j++)   
		{  
		int tmp = 0; 
		String tmp2="";
		if (rounded_values[i] > rounded_values[j])   
		{
			
		tmp = rounded_values[i];  
		rounded_values[i] = rounded_values[j];  
		rounded_values[j] = tmp; 
		
		tmp2=player_names[i];
		player_names[i]=player_names[j];
		player_names[j]=tmp2;
		}
	
		}  
		
		}
				
		System.out.println(player_names[inp_1[1]]+" "+rounded_values[inp_1[1]]);
		sc.close();
		
	
	}

}
