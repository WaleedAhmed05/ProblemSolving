package asg1;

public class Swapper {
	
	public static void main(String[] args) {
		
		String random_str="assignment1";
		char[] char_array= new char[random_str.length()];
		
		for(int i=0; i<random_str.length(); i++) {
			char_array[i]=random_str.charAt(i);
		}
		
		for(int i=1; i<char_array.length; i++) {
			
			if(i==char_array.length-1) {
				break;
			}
			else {
			char temp=char_array[i+1];
			char_array[i+1]=char_array[i-1];
			char_array[i-1]=temp;
			}
			
		}
		
		
		for(int i=0; i<char_array.length; i++) {
			System.out.print(char_array[i]);
		}
	}

}
