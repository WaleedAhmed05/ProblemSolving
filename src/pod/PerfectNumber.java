package pod;

import java.util.ArrayList;
import java.util.Scanner;
public class PerfectNumber {
	
public static void PerfectChecker(int n) {
		
		int check=0;
		ArrayList<Integer> some_list= new ArrayList<Integer>();
		
			check=0;
			for(int j=1; j<n; j++) {
				
				if(n%j==0) {
					check+=j;
					some_list.add(j);
				}
			}	
				if(check==n) {
					System.out.print(n+" = ");
					for(int i=0; i<some_list.size(); i++) {
						if(i!=some_list.size()-1)
						System.out.print(some_list.get(i)+" + ");
						else
							System.out.println(some_list.get(i));
					}
				}
				
				else 
					System.out.println(n+" is NOT perfect.");
				

	}
	
	
	
	public static void main(String[] args) {
		
	Scanner sc= new Scanner(System.in);
	ArrayList<Integer> array_list= new ArrayList<Integer>();
	int temp=0;
	int i=0;
	    	while(temp!=(-1)) {
	    		temp=Integer.parseInt(sc.next());
	    		if(temp==-1)
	    			break;
	    		array_list.add(temp);

	    				}
	     
	//Console test part.
	    	for(int j=0;  j<array_list.size(); j++) {
	    		//System.out.println(array_list.get(j));
	    		PerfectChecker(array_list.get(j));
	    		}
	} 

}
