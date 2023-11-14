package Mini_Coding_Projects.Hand_Evaluator;


/**
 * A Data Container emulating a playing card. Has an enum Suit and a value.
 */
public class Card {
	/**
	 * provides a string output for face cards.
	 * @return the name of a face card as determined by its value.
	 */
	public String valueToFace(){
		if(getValue() == 1){
			return "Ace";
		}else if(getValue() == 11){
			return "Jack";
		}else if(getValue() == 12){
			return "Queen";
		}else if(getValue() == 13){
			return "King";
		}
		return String.valueOf(getValue());
	}

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

	/**
	 * Represents the suit of a playing card: Heart, Diamond, Club, or Spade.
	 */
	private Suit suit;
	/**
	 * The numeric value of a playing card.
	 * Face cards are represented by the numbers 11-13 (J,Q,K).
	 */
	private int value;

}