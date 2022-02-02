package lab3;


/**
 * @author Waleed Ahmed siddiqui
 * @version 1.0
 * Program: Text processing programs. Same strings by characters checker.
 * Problem Statement: https://labs6481.encs.concordia.ca/team/problems/9/text	
 **/


import java.util.Scanner;
public class Lab3A {

	
	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		int loop_length=Integer.parseInt(sc.nextLine());
		String[] inp_strings= new String[loop_length*2];
		
		
		for (int i=0; i<loop_length*2; i++) {
			inp_strings[i]=sc.nextLine();
		}
			
		int counter=0;
		for (int i=0; i<inp_strings.length; i++) { //0,2			
			counter=0;
			int minLength = Math.min(inp_strings[i].length(), inp_strings[i+1].length());
			
			for (int j=0; j<minLength; j++) {
				
				
				String temp=inp_strings[i].substring(j,j+1);
				String temp2=inp_strings[i+1].substring(j,j+1);
				if (temp.equals(temp2)) {
					counter++;
				}
				else {
					break;
				}
								
			}
			System.out.println(counter);
		   counter=0;
			
			i++;
		}
			
		sc.close();
	}
}
