package Mini_Coding_Projects.Hand_Evaluator;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class HandEvaluator {

	/**
	 * adds one card object from the stack to the hand.
	 */
	public void drawCard() {
		//pop the top element of the deck and add it to the hand
		getHand().add(getDeck().pop());
	}

	/**
	 * draw a full hand of cards, up to hand size.
	 * @param handSize the number of elements in the hand arraylist.
	 */
	public void drawHand(int handSize){
		for(int i = 0; i < handSize; i++){
			drawCard();
		}
	}

	/**
	 * sort the cards in the hand using bubble sort.
	 */
	public void sortHand(){
		CardComparator comp = new CardComparator();
		//bubble sort will work since size is small.
		ArrayList<Card> theHand = getHand();
		int handSize = theHand.size();
		for(int i = 0; i < handSize - 1; i++){
			for(int j = i + 1; j < handSize; j++){
				if(comp.compare(theHand.get(i), theHand.get(j)) > 0){
					Card temp = theHand.get(i);
					theHand.set(i, theHand.get(j));
					theHand.set(j, temp);
				}
			}
		}
		setHand(theHand);
	}

	/**
	 * checks what type of hand the combination of cards creates and
	 * calculates the probability of that combination of cards occurring
	 * from a regular deck of cards.
	 * @return a String with the hand name and its probability.
	 */
	public String evaluateHand(){

		String result = "";
		sortHand();
		ArrayList<Card> theHand = getHand();
		//poker hands, in order from greatest to least:
		//make helper methods for each type.
		//royal flush
		//10, J, Q, K, A must all be the same suit.
		//if first card is ace,
		//if second is ten,
		//if third is jack,
		//if fourth is queen,
		//if fifth is king
		//and suit=suit=suit=suit=suit,
		//hand is a royal flush

		//straight flush
		//a straight of all the same suit.
		//if a = b - 1,
		//if b = c - 1,
		//if c = d - 1,
		//if d = e - 1,
		//and suit=suit=suit=suit=suit,
		//hand is a straight flush

		//four of a kind
		//four cards of the same rank.
		//after sorting first card should be different.
		//if b=c=d=e,
		//hand is four of a kind

		//full house
		//three of a kind and a pair.
		//after sorting two combinations are possible,
		//AABBB or AAABB
		//if either is true,
		//hand is a full house

		//flush
		//any five cards of the same suit, but not in sequence.
		//if a.suit = b,c,d,e suit,
		//hand is a flush

		//straight
		//any 5 cards in sequential order that are not a flush.
		//if a = b - 1,
		//if b = c - 1,
		//if c = d - 1,
		//if d = e - 1,
		//hand is a straight

		//three of a kind
		//three cards of the same rank.
		//three possible combinations,
		//AAABC or ABBBC or ABCCC
		//if any are true,
		//hand is three of a kind

		//two Pair
		//two pairs.
		//three combos,
		//AABBC or ABBCC or AABCC
		//if any are true,
		//hand is two pair

		//pair
		//two cards of the same rank.
		//four combos,
		//AABCD or ABBCD or ABCCD or ABCDD
		//if any are true,
		//hand is a pair

		//highCard
		//considers highest rank card when no special hand is drawn.
		//eg. 1, 3, 4, 7, J - Jack is high card.
		//if all of the above are false,
		//hand has high card.

		return result;
	}

	//dealHands method
	//deal an amount of hands and evaluate each.
	//number of hands is user determined
	//helper method to calculate probability of each hand from the sample
	//make sure to return hand to deck and shuffle the deck after each deal.
	
	//handProbability method
	//calculates the probability of the drawn hand.
	//use imported stats library methods to calculate.

	//shuffle methods to emulate real-life shuffling techniques.
	/*
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
				//put the card into its pile
				//move to next pile
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

	 */

	/**
	 * randomizes (shuffles) the contents of the deck.
	 */
	public void shuffleDeck(){
		Stack<Card> theDeck = getDeck();
		//make an array of the deck
		Card[] deckArray = new Card[FULL_DECK_COUNT];
		for(int i = 0; i < FULL_DECK_COUNT; i++){
			deckArray[i] = theDeck.pop();
		}
		Random r = new Random();
		int shuffleSlot;
		//for each index,
		for(int i = 0; i < FULL_DECK_COUNT; i++) {
			//get a random number in the index bounds
			shuffleSlot = r.nextInt(0, FULL_DECK_COUNT);
			//ensure it is not the current index
			while(shuffleSlot == i){
				shuffleSlot = r.nextInt(0, FULL_DECK_COUNT);
			}
			//switch the current index with that random number
			Card temp = deckArray[i];
			deckArray[i] = deckArray[shuffleSlot];
			deckArray[shuffleSlot] = temp;
		}
		//populate a new stack with the randomized deck
		for(Card c : deckArray){
			theDeck.push(c);
		}
		//set the randomized deck as the deck global
		setDeck(theDeck);
	}

	/**
	 * populates the deck with the full 52 cards (13 of each suit).
	 * @return the populated deck object.
	 */
	public Stack<Card> makeDeck() {
		Stack<Card> theDeck = new Stack<>();
		//loop for each suit to initialize deck contents
		Suit[] suits = {Suit.Clubs, Suit.Diamonds, Suit.Hearts, Suit.Spades};
		for (Suit suit : suits) {
			for (int i = 1; i < 14; i++) {
				theDeck.add(new Card(suit, i));
			}
		}
		return theDeck;
	}
	//constructor
	public HandEvaluator(int handSize){
		setDeck(makeDeck());
		setHand(new ArrayList<>(handSize));
	}
	//getters and setters
	public Stack<Card> getDeck() {
		return deck;
	}
	public void setDeck(Stack<Card> deck) {
		this.deck = deck;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	/**
	 * Emulates a deck of 52 playing cards.
	 */
	private Stack<Card> deck;
	/**
	 * Emulates a hand of playing cards.
	 */
	private ArrayList<Card> hand;
	/**
	 * Limit for amount of cards in the deck.
	 */
	private static final int FULL_DECK_COUNT = 52;
	 
	 
}
