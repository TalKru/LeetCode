package strings;
/*
	Implement strStr().
	Return the index of the first occurrence of needle in haystack, 
	or -1 if needle is not part of haystack.
	
	Clarification:
	What should we return when needle is an empty string? 
	This is a great question to ask during an interview.
	
	For the purpose of this problem, we will return 0 when needle is an empty string. 
	This is consistent to C's strstr() and Java's indexOf().
	
	Example 1:
	Input: haystack = "hello", needle = "ll"
	Output: 2
	
	Example 2:
	Input: haystack = "aaaaa", needle = "bba"
	Output: -1
	
	Example 3:
	Input: haystack = "", needle = ""
	Output: 0
	 
	Constraints:
	0 <= haystack.length, needle.length <= 5 * 104
	haystack and needle consist of only lower-case English characters.
*/
public class _28_Needle_in_haystack {

	public static void main(String[] args) {

		String haystack = "aaabbc";
		String needle = "bb";
		//String haystack = "mississippi";
		//String needle = "issipp";
		//String needle = "issipi";
		//String haystack = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
		//		+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
		//		+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		//String needle = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
		//		+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";


		System.out.println("haystack: " + haystack);
		System.out.println("needle: " + needle);


		long startTime = System.currentTimeMillis();
		int ans = strStr(haystack, needle);
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Runtime: " + estimatedTime + "(ms)");

		System.out.println("begin index: " + ans);

	}



	/*Tal's implementation*/	
	public static int strStr(String haystack, String needle) {

		if(needle.equals(""))                   { return  0; }
		if(haystack.length() < needle.length()) { return -1; }

		for (int i = 0; i <= haystack.length() - needle.length() ; i++) {                 // stop loop when needle is longer than remainder of haystack

			if(haystack.charAt(i) == needle.charAt(0)) { // first char match!

				if(haystack.charAt(i+needle.length()-1) == needle.charAt(needle.length()-1)) { // last char match!

					boolean perfMatch = true;

					for (int j = 1; j < needle.length(); j++) { // j=1 since we mached the first char already

						if(haystack.charAt(j+i) != needle.charAt(j)) {
							perfMatch = false;
							break;
						}
					}
					if(perfMatch) { return i; }
				}
			}
		}
		return -1; 
	}

	//	public static int strStr(String haystack, String needle) {
	//		
	//		if (needle.isEmpty()) return 0;
	//		if (needle.length() > haystack.length()) return -1;
	//		
	//		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
	//			
	//			int j = 0; // needle itterator
	//			int k;     // saving potential match index
	//			
	//			     /*         first char match          */    /*                      last char match?                                        */
	//			if ((haystack.charAt(i) == needle.charAt(j)) && (haystack.charAt(i + needle.length() - 1) == needle.charAt(j + needle.length() - 1))) {
	//				k = i;
	//				while (k < haystack.length() && j < needle.length() && haystack.charAt(k) == needle.charAt(j)) {
	//					k++;
	//					j++;
	//				}
	//				if (j == needle.length()) return i;
	//			}
	//		}
	//		return -1;
	//	}
	
}// class




