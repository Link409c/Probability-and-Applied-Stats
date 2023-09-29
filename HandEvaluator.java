public class HandEvaluator {
	
	//draw card method
	//adds one card to the hand from the deck
	public Card drawCard() {
		Card c = getDeck()[getDeck().length - 1];
		getDeck()[getDeck().length - 1] = null;
		return c;
	}
	
	//draw hand method
	//use draw card method to fill the hand
	//hands are user choice.
	
	//evaluate hand method
	//checks what type of hand the combination of cards creates. 
	//make helper methods for each type.
	
	//isPair method
	//depends on hand size
	//check if at least one pair.
	//count number of pairs in the hand.
	
	//three of a kind
	
	//four of a kind
	
	//straight
	
	//flush
	
	//full house
	
	//straight flush
	
	//royal flush
	
	//dealHands method
	//deal an amount of hands and evaluate each.
	//number of hands is user determined
	//helper method to calculate probability of each hand from the sample
	//make sure to shuffle the deck after each deal.
	
	//handsProbability method
	//use imported stats library methods to calculate.
	
	//makeDeck method
	public Card[] makeDeck() {
		Card[] theDeck = new Card[DECK_COUNT];
		//loop for each suit to initialize deck contents
		Suit[] suits = {Suit.Club, Suit.Diamond, Suit.Heart, Suit.Spade};
		for(int k = 0; k < suits.length; k++) {
			for(int i = 1; i < 14; i++) {
				theDeck[i] = new Card(suits[k], i);
			}
		}
		return theDeck;
	}
	 public Card[] getDeck() {
		return deck;
	}
	public void setDeck(Card[] deck) {
		this.deck = deck;
	}
	public Card[] getHand() {
		return hand;
	}
	public void setHand(Card[] hand) {
		this.hand = hand;
	}
	private Card[] deck;
	private Card[] hand;
	private static final int DECK_COUNT = 52;
	 
	 
}
