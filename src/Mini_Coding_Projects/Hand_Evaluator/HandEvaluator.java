package Mini_Coding_Projects.Hand_Evaluator;

import java.util.Random;

public class HandEvaluator {
	
	//draw card method
	//adds one card to the hand from the deck
	public void drawCard() {
		getHand()[findNextIndex()] = getDeck()[getDeck().length - 1];
		getDeck()[getDeck().length - 1] = null;
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
	//calculates the probability of the achieved combinations of the
	//current set of drawn hands.
	//use imported stats library methods to calculate.

	//findNextIndex method
	//find the next empty index of the hand array
	//used to add or remove cards from the hand
	public int findNextIndex(){
		int index = 0;
		while(getHand()[index] != null && index < getHand().length){
			index++;
		}
		return index;
	}

	//shuffleDeck method
	//randomize the elements of the deck array
	public void shuffleDeck(){
		Card[] shuffledDeck = new Card[FULL_DECK_COUNT];
		Random cardFromDeck = new Random();
		int[] chosenIndices = new int[FULL_DECK_COUNT];
		//randomly assign a new index to get a card from the deck
		int index = cardFromDeck.nextInt();
		//add this index to a list
		//while deck[index] is not null and index is not in the list of used indices,
		//add this element to the shuffled deck
		//repeats until all indexes are chosen

	}

	//pileShuffle method
	public void pileShuffle() {
		//divide the deck into four equal arrays
		Card[][] piles = new Card[4][];
		for (int i = 0; i < 4; i++) {
			int pileNumber = i;
			for(int j = 0; j < 13; j++){
				piles[i][j] = getDeck()[pileNumber];
				pileNumber += 4;
			}
		}

		//combine piles 1 and 3 and riffle shuffle
		//combine piles 2 and 4 and riffle shuffle
		//combine the combined piles and riffle shuffle
	}

	//riffleShuffle method
	//given two lists of elements
	//place elements into a new list alternating between which element to place
	//split the new list into two lists of equal elements and repeat

	//makeDeck method
	public Card[] makeDeck() {
		Card[] theDeck = new Card[FULL_DECK_COUNT];
		//loop for each suit to initialize deck contents
		Suit[] suits = {Suit.Club, Suit.Diamond, Suit.Heart, Suit.Spade};
		for (Suit suit : suits) {
			for (int i = 1; i < 14; i++) {
				theDeck[i] = new Card(suit, i);
			}
		}
		return theDeck;
	}
	//constructor
	public HandEvaluator(int handSize){
		setDeck(makeDeck());
		setHand(new Card[handSize]);
	}
	//getters and setters
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

	//global variables
	private Card[] deck;
	private Card[] hand;
	private static final int FULL_DECK_COUNT = 52;
	 
	 
}
