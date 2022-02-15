package asg1;

public class ClosestFurtherest {
	
public static int digit_sum(int n1) {
		
		int e1=n1, e2, digit_sum=0;
		
		while(e1>0) {
			
		digit_sum+= e1%10;
		e1=e1/10;
		
		//System.out.println(e1);
		}
		if(digit_sum>=10) {
			digit_sum=digit_sum(digit_sum);
		}
		
		return digit_sum;
		
	}
	
	
	public static void main (String[] args) {
		System.out.println(digit_sum(888));
		int[] arr= {20, 52, 400, 3, 30, 70, 72, 47, 28, 38, 41, 53, 21};
		
		int sum_1=0;
		
		int element3=0, element4=0;
		int e1 , e2 =0;
		int digit_sumOld=0;
	
		int element1=0, element2=0;
		int max_diff=0;
		for(int i=0; i<arr.length; i++) {
		
			if(i!=arr.length-1) {
				
			int temp=digit_sum(arr[i])-digit_sum(arr[i+1]);

			
			System.out.println(digit_sum(arr[i]) +"-"+digit_sum(arr[i+1])+"="+temp);
				
			if(temp>max_diff) {
				element1=arr[i];
				element2=arr[i+1];
				max_diff=temp;
			} 
			
			
			}
			
		}
			
		System.out.println(element1+" "+element2);
		
		for(int i=0; i<arr.length; i++) {
			
			if(i!=arr.length-1) {
				
				int biggest_diff=0;
				if((arr[i]-arr[i+1])>biggest_diff) {
					biggest_diff=arr[i]-arr[i+1];
					element3=arr[i];
					element4=arr[i+1];
					
				}
				
				
			}
			
			
			
			
			
			for(int j=i+1; j<arr.length; j++) {
				
				
				
				
			}
		}
		//System.out.println(element3 +" "+ element4);
		
		
		
	}
}
