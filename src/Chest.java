
public class Chest extends ChargesGainOrLoss {
	private char gridChar = 'C';
	
	public Chest() {
		super();
	}
	public String charges() {
		String charge = "You have gained a extra charge on ur weapon";
		return charge;
	}
	public char getGridChar() {
		return gridChar;
	}
	public String toString() {
		String rep = "Sounds the like the opening of Gold";
		return rep;
	}
}
