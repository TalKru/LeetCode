package misc;

public class RuntimeMilisec {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		//////////////////////////////////////////... do something ...

		//////////////////////////////////////////... do something ...
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Runtime: " + estimatedTime + "(ms)");


		try { 
			Thread.sleep(300); // sleep for 300ms
		}  
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
