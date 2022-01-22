package lab1;
import java.util.Scanner;

/*Not the best solution, but still working..
 * TODO I have to fix extra logics to make my code more optimum
 * 
 * Digit_checker
 * Example
 * 49927398716
 * 4 +(1+8) + 9 + (4) + 7 + (6) + 9 +(1+6) + 7 + (2) + 6 = 70
 * if sum of all digits divisible by 10 then it is valid otherwise invalid
 * print the last correct digit
 * Inputs and Outputs (Right side)
 * 49927398716 Valid
 * 513467882134 Invalid 2
 * 432876126 Valid
 */

public class Lab1B {
	
	public static int calc(long credit_no) {
		
		
				
				String temp=Long.toString(credit_no);
			    String[] credit_str=temp.split("");
			    
			    
			    int total_n1=0;
			    int total_n2=0;
			    if (credit_str.length%2==0) {
			    
			    
			    for (int i = credit_str.length-1; i >= 0; i--) {  
	
		            if(i%2==0){  
		            	int total=Integer.parseInt(credit_str[i])*2;
		            	
		            	if (Integer.toString(total).length()==2) {
		            		int total1= total%10;
		            		int total2=total/10;
		            		int total_final=total1+total2;
		            		
		            		total_n1+=total_final;
		            	
		            	}
		                
		            	
		            	if (Integer.toString(total).length()==1) {
		            		total_n1+=total;
		            
		            	}
		            	
		            	
		            }  
		            
		           
		            
		        } 
			    
			    
			 
			    for (int i = credit_str.length-1; i >= 0; i--) {
			    	
			    	
			    	 if(i%2!=0){
			    		 
			    		 total_n2+=Integer.parseInt(credit_str[i]);
			    	 }
			    }
			    
			    
			    
			}//if mod 2 
			    
			    
			    
			    
			    //start
			    else {
			    	

				    
				    for (int i = credit_str.length-1; i >= 0; i--) {  
				    	
			            if(i%2!=0){  
			            	int total=Integer.parseInt(credit_str[i])*2;
			            	
			            	if (Integer.toString(total).length()==2) {
			            		int total1= total%10;
			            		int total2=total/10;
			            		int total_final=total1+total2;
			            		
			            		total_n1+=total_final;
			            	}
			                // if()
			            	
			            	if (Integer.toString(total).length()==1) {
			            		total_n1+=total;
			            	}
			            	
			            	
			            }  
			            
			            //if 2mod==0
			            
			        } 
				    
				    
				    
				  //  int total_n2=0;
				    for (int i = credit_str.length-1; i >= 0; i--) {
				    	
				    	
				    	 if(i%2==0){
				    		 total_n2+=Integer.parseInt(credit_str[i]);
				    	 }
				    }
			    	
			    	
			    	
			    	
			    	
			    }
			    //end
				    
			    int final_total=total_n1+total_n2;
			
		
		
		return final_total;
	}
	
	
	
	
	public static void check(long ie) {
		
		
		for (int i=0; i<=9; i++) {
		
		
		
		String temp_str=Long.toString(ie)+i;
		
		int final_checker=calc(Long.parseLong(temp_str));
		if(final_checker%10==0) {
			System.out.println(i);
			
		}
		
		
	  
		
		
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		long credit_no=0;
		
		int length= Long.toString(credit_no).length();
	
		//credit_no<=Long.MAX_VALUE
		
		while(credit_no==0 || length>20) {
			credit_no=sc.nextLong();
		}
		
		int final_total=calc(credit_no);
		
		
		
		
	
		
		
	    if(final_total%10==0) {
	    	System.out.println("VALID");
	    }
	    
	    else {
	    	
	    	
	    	
	    	
	    	credit_no=credit_no/10;
	    	System.out.print("INVALID ");
	    	check(credit_no);
	    }	
	        
	 sc.close(); 
	}

}
