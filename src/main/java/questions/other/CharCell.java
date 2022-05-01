package questions.other;

public class CharCell {
	
	int  index;
	char charValue;
	
	CharCell(int num, char ch){
		
		this.index = num;
		this.charValue = ch;
	}
	
	public char getChar() {
		return this.charValue;
	}
	public int getIndex() {
		return this.index;
	}
	
}
