package q1;

//i do not know if i can use compareTo because we did not study chapter 8


public class Card {

	private final String face;
	private final String suit;
	//this filed is for decide which card is bigger
	private final int power;

	public Card(String face, String suit, int power) {
		this.face = face;
		this.suit = suit;
		this.power = power;
	}

	public String getFace() {
		return this.face;
	}

	public String getSuit() {
		return this.suit;
	}
	public int getPower()
	{
		return this.power;
	}

	public String toString() {
		return this.getFace() + " of " + this.getSuit();
	}




}
