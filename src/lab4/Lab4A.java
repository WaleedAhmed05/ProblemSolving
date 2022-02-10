package lab4;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Lab4A {

	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String inp_string= sc.nextLine();
		
		char[] inp_char= new char[inp_string.length()];
		for(int i=0; i<inp_char.length; i++) {
			inp_char[i]=inp_string.charAt(i);
			
		}
		
	
		Map<Character, Integer> char_length= new HashMap<Character, Integer>();	
		
		for(int i=0; i<inp_char.length; i++) {
			
			
			if(!char_length.containsKey(inp_char[i])) {
				char_length.put(inp_char[i], 1);
			
			
		
			for (int j=i+1; j<inp_char.length; j++) {
						
				if(inp_char[i]==inp_char[j]) {
					int previous=char_length.get(inp_char[i]);
					char_length.replace(inp_char[i],++previous);
				}
				
				
			}
			
			}
		}
		

		List<Character> isogram= new ArrayList<Character>();
		List<Character> non_isogram = new ArrayList<Character>();
		
		for( Map.Entry<Character, Integer> entry : char_length.entrySet() ){
						
			if(entry.getValue()%2==0) {
				isogram.add(entry.getKey());
			}
			
			else {
				non_isogram.add(entry.getKey());
			}
		   // System.out.println( entry.getKey() +" " + entry.getValue() );
		}
		
		Collections.sort(isogram);
		Collections.sort(non_isogram);
		
		
		if(non_isogram.size()>0) {
			
			for(int i=0; i<non_isogram.size(); i++) {
			System.out.print(non_isogram.get(i)+" ");
			}
			System.out.print("no");
		}
		
		else {
			
			for(int i=0; i<isogram.size(); i++) {
				System.out.print(isogram.get(i)+ " ");
				
				}
			System.out.print("yes");
			
		}
				
	}
}
