package pps;
import java.util.Scanner;
public class Lab1A {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String full_name="";
		
		 
		 
		while(full_name=="" || full_name.length()>50) {
			full_name=sc.nextLine();
		}
		
		
		//We want to print name as LASTNAME FIRSTNAM MIDDLENAME
	
		String[] first_name=full_name.split(" ");
		//System.out.println(first_name[0]);
		
	//System.out.println(first_name.length);
		if(first_name.length==3) {
			System.out.println(first_name[2]+" "+first_name[0]+" "+first_name[1]);
		}
		
		if(first_name.length==2) {
			//first_name[1]
			String last_name=first_name[1];  
			char c=last_name.charAt(first_name[1].length()-1);
			
			//(a, e, i, o, u or A, E, I, O, U
			if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
			{
				System.out.println(first_name[1]+" "+first_name[0]);
			}
			else {
				System.out.println(first_name[0]+" "+first_name[1]);
			}
			
			
			
		}
		
		if (first_name.length<=1) {
			System.out.println(first_name[0]);
		}
		
		/*
		for (String x : first_name)
            System.out.println(x);
		*/

	
	
	
	}
	
	
}
