package pod;

/*
 * 
 * 
 * Given n non-negative integers representing a bar graph, design an algorithm that computes how
much volume of water could the bar graph hold if someone poured water from the top. Assume
each bar to have a width of 1.
 * 
 * 
 * 
 * 
 */


import java.util.Scanner;
public class Water {
	
	
	
	
 public static int calc()
    {
	 
	 
	 
	 
	    String input_blocks;
		Scanner sc= new Scanner(System.in);
		input_blocks= sc.nextLine();
		input_blocks=input_blocks.replaceAll(",", "");
		
		
		
		
		
		
		input_blocks.toCharArray();
		char[] blocks_array_char=input_blocks.toCharArray();
		
		
		int inp_length=blocks_array_char.length;
		//System.out.println(inp_length);
		
		int[] arr= new int[inp_length];
		//Manually converting type.
		
		for (int i=0; i<blocks_array_char.length; i++) {
			arr[i]=Integer.parseInt(String.valueOf(blocks_array_char[i]));
			//System.out.print(blocks_array_int[i]);
			//System.out.print(blocks_array_int[i]);
		}
	 
	 
	 
	 
	 
	 
	 sc.close();
	 
	
		int length=arr.length;
        int count = 0, left_borderline = 0, right_borderline = 0;
        int lowest = 0, highest = length - 1;
 
       
        
        
        while (lowest <= highest) {
        	
        	
        	
            if (arr[lowest] < arr[highest]) {
            	
            	
                if (arr[lowest] > left_borderline) {
                	
 
                    left_borderline = arr[lowest];}
              //System.out.println();
                else
                {
                    count += left_borderline - arr[lowest]; }
                lowest++;
                //System.out.println(lowest);
            }
            else {
                if (arr[highest] > right_borderline) {
                	
                    right_borderline = arr[highest];}
               // System.out.println(right_borderline);
 
                else
                {
                	count += right_borderline - arr[highest];}
                highest--;
            }
        }
 
        return count;
    }
	
	
	
	
	public static void main(String[] args) {
		
				
		int result = calc();
		System.out.println(result);
		
		}

}
