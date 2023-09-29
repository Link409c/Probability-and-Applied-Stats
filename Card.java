
public class Card {
	
	private Suit suit;
	private int value;
	
	public Card(Suit theSuit, int theValue) {
		setSuit(theSuit);
		setValue(theValue);
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//test
}