package questions.extra;

public class TwoSumSorted {

	public static void main(String[] args) {
		
		int[] arr = {2,5,8,12,17,19,90};
		int k = 25;
		twoSumSorted(arr, k);
		
	}
	
	public static void twoSumSorted(int[] arr, int k) {
		
		int i = 0;
		int j = arr.length-1;
		
		while(i < j) {
			
			if(arr[i] + arr[j] == k) {
				
				System.out.println(i);
				System.out.println(j);
				return;
			}
			
			if(arr[i] + arr[j] > k) {
				j--;
			}
			else {
				i++;
			}
			
			
		}
		
		
		
	}
	
} // class
