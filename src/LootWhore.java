
public class LootWhore extends ChargesGainOrLoss { // this guy steals charges from the player when in the same room
	private char gridChar = 'L';
	
	public LootWhore() {
		super();
	}
	public char getGridChar () {
		return gridChar;
	}
	public String charges() {
		String charge = "You have lost a durability on ur weapon\nDamn LootWhores";
		return charge;
	}
	public String toString() {
		String rep = "I hear the sounds of a looter";
		return rep;
	}
}

