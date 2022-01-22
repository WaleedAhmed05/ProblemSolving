package lab2;

import java.util.Scanner;
public class Lab2A {
	
	/*inputs
	 * if age is greater than 13 then print, old enough else print too young
	 * match age with 18 april 2020 which is 18 04 2020
	 * 
	 * Input Example
	 * 3
	 * 20 01 2002
	 * 17 04 2009
	 * 15 05 2007
	 * 
	 * Output Example
	 * too young
	 * too young
	 * old enough
	 */
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int length= Integer.parseInt(sc.nextLine());
		
		
		String[] doB= new String[length];
		for (int i=0; i<length; i++) {
			doB[i]=sc.nextLine();
			
			
		}
		
		int age_date, age_month, age_year, age;
		
		for (int j=0; j<length; j++) {
			
			age_year=Integer.parseInt(doB[j].substring(6));
			age_month=Integer.parseInt(doB[j].substring(3,5));
			age_date= Integer.parseInt(doB[j].substring(0,2));
			
			age=2022-age_year;
			
			if(age>13) {
				System.out.println("old enough");
				
			}
				
				else if (age==13) {
					if(age_month==4) {
						if(age_date<=18) {
							System.out.println("old enough");
						}
						else  {
							System.out.println("too young");
						}
						
					}//==4
					
					else if(age_month<4) {
						System.out.println("old enough");
					}
					
					else {
						System.out.println("too young");
					}
				}
			
				else {
					System.out.println("too young");
				}
			
			
			
			
			
			}
			
			
			
			
			
		}
		
	}


