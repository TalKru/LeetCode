package extra;

public class Fibonacci {

	public static void main(String[] args) {
		
		int index = 47;
		
		System.out.println("Fibonacci numbers:");
		System.out.print("fiboIter: ");
		for (int i = 0; i < index; i++) {
			System.out.print("(" + fiboIter(i) + ")->");
		}
		System.out.println();
		System.out.print("fiboRec:  ");
		for (int i = 0; i < index; i++) {
			System.out.print("(" + fiboRec(i) + ")->");
		}
	}

		
	public static long fiboRec(int n) {
		
		if(n <= 1) {
			return n;
		}
		return fiboRec(n-1) + fiboRec(n-2); 
	}
	
	public static long fiboIter(int n) {
		
		if(n < 2) return n;
		
		long a = 0;
		long b = 1;
		long res = 0;
		
		for (int i = 2; i <= n; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
	}
	
	
}








