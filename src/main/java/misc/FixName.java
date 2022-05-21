package misc;

import java.util.Scanner;

public class FixName {

	public static void main(String[] args) {

		System.out.println("Enter the question name:");
		scanFromUser();
	}

	// fit to valid file name pattern _000_question_name
	public static void scanFromUser() {

		Scanner input = new Scanner(System.in);
		String inputStr;
		inputStr = input.nextLine(); // pushes a line to the String var - line ends at \n
		//outStr += input.nextLine(); // pushes another line, then adds to the previous existing string
		//outStr += input.nextLine(); // and so long...

		String fixedStr = "_";
		boolean wordCopy = false;

		for (int i = 0; i < inputStr.length(); i++) {

			char c = inputStr.charAt(i);

			if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
				wordCopy = true;
				fixedStr += c;
			}
			else {
				if(wordCopy && i < inputStr.length() - 1) {
					fixedStr += "_";
					wordCopy = false;
				}
			}
		}
		System.out.println("\033[1;32m" + fixedStr);
	}
}
