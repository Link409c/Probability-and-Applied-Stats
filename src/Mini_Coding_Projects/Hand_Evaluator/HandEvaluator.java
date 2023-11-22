package Mini_Coding_Projects.Hand_Evaluator;
import Miscellaneous.CsvAble;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * This program calculates the probability of drawing hands of playing cards.
 * The user may determine the number of hands to draw. The amount of each hand
 * will be recorded and exported to a CSV file to display using excel or another
 * plotting software.
 */
public class HandEvaluator implements CsvAble {

	/**
	 * adds one card object from the stack to the hand.
	 */
	public void drawCard() {
		//pop the top element of the deck and add it to the hand
		getHand().add(getDeck().pop());
	}

	/**
	 * draw a full hand of cards, up to hand size.
	 *
	 * @param handSize the number of elements in the hand arraylist.
	 */
	public void drawHand(int handSize) {
		for (int i = 0; i < handSize; i++) {
			drawCard();
		}
	}

	/**
	 * sort the cards in the hand using bubble sort.
	 */
	public void sortHand() {
		//bubble sort will work since size is small.
		ArrayList<Card> theHand = getHand();
		int handSize = theHand.size();
		for (int i = 0; i < handSize - 1; i++) {
			for (int j = i + 1; j < handSize; j++) {
				if(theHand.get(i).getValue() > theHand.get(j).getValue()) {
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
	 *
	 * @return a String with the hand name and its probability.
	 */
	public String evaluateHand() {
		String result;
		sortHand();
		CardComparator cardComparator = new CardComparator();
		//poker hands, in order from greatest to least:
		if (isRoyalFlush(cardComparator)) {
			result = "Royal Flush";
		}
		else if (isStraightFlush(cardComparator)) {
			result = "Straight Flush";
		}
		else if (isFourOfAKind(cardComparator)) {
			result = "Four of a Kind";
		}
		else if (isFullHouse(cardComparator)) {
			result = "Full House";
		}
		else if (isFlush(cardComparator)) {
			result = "Flush";
		}
		else if (isStraight(cardComparator)) {
			result = "Straight";
		}
		else if (isThreeOfAKind(cardComparator)) {
			result = "Three of a Kind";
		}
		else if (isTwoPair(cardComparator)){
			result = "Two Pair";
		}
		else if (isPair(cardComparator)){
			result = "One Pair";
		}
		else {
			result = highCard();
		}
		//include probability calculation here
		//append to result
		return result;
	}

	/**
	 * a Royal Flush is the hand 10,J,Q,K,A where every
	 * card has the same suit.
	 * @param cardComparator the comparator object
	 * @return true if hand is a Royal Flush
	 */
	public boolean isRoyalFlush (CardComparator cardComparator) {
		//get hand as string
		String currHand = handToString();
		//compare string to given
		String royalFlush = "110111213";
		//if match, compare suits
		if (currHand.equals(royalFlush)) {
			return isFlush(cardComparator);
		} else {
			return false;
		}
	}

	/**
	 * a Straight is any 5 cards of the same suit in numeric order
	 * that is not a Royal Flush.
	 * @param cardComparator the comparator object
	 * @return true if hand is Straight Flush.
	 */
	public boolean isStraightFlush (CardComparator cardComparator) {
		return isStraight(cardComparator) && isFlush(cardComparator);
	}

	/**
	 * Four of a Kind is any four cards of the same value.
	 * @param cardComparator the comparator object
	 * @return true if hand has Four of a Kind.
	 */
	public boolean isFourOfAKind (CardComparator cardComparator) {
		return cardComparator.compareValues(getHand().get(0), getHand().get(3))
				|| cardComparator.compareValues(getHand().get(1), getHand().get(4));
	}

	/**
	 * a Full House is a hand containing a pair and a three of a kind.
	 * @param cardComparator the comparator object
	 * @return true if hand is a Full House.
	 */
	public boolean isFullHouse (CardComparator cardComparator) {
		boolean[] pairs = getPairs(cardComparator);
		return (pairs[0] && cardComparator.compareValues(getHand().get(2), getHand().get(4)))
				|| (cardComparator.compareValues(getHand().get(0), getHand().get(2)) && pairs[3]);
	}

	/**
	 * a Flush is any 5 cards of the same suit not in numeric order.
	 * @param cardComparator the comparator object
	 * @return true if hand is a Flush.
	 */
	public boolean isFlush (CardComparator cardComparator) {
		int handSize = getHand().size();
		Card ace = getHand().get(0);
		Card next;
		boolean sameSuit = false;
		for (int i = 1; i < handSize; i++) {
			next = getHand().get(i);
			sameSuit = cardComparator.compareSuits(ace, next);
			if (!sameSuit) {
				break;
			}
		}
		return sameSuit;
	}

	/**
	 * a Straight is a hand with five cards in numeric order of
	 * different suits.
	 * @param cardComparator the comparator object
	 * @return true if hand is a Straight.
	 */
	public boolean isStraight (CardComparator cardComparator) {
		int bound = getHand().size() - 1;
		for (int i = 0; i < bound; i++) {
			Card first = getHand().get(i);
			Card second = getHand().get(i + 1);
			if(!cardComparator.oneLess(first, second)){
				return false;
			}
		}
		return true;
	}

	/**
	 * Three of a Kind is a hand with three cards of the same value.
	 * @param cardComparator the comparator object
	 * @return true if hand has Three of a Kind.
	 */
	public boolean isThreeOfAKind (CardComparator cardComparator) {
		//compare possible groupings
		//(0,2), (1,3), (2,4)
		return cardComparator.compareValues(getHand().get(0), getHand().get(2))
				|| cardComparator.compareValues(getHand().get(1), getHand().get(3))
				|| cardComparator.compareValues(getHand().get(2), getHand().get(4));
	}

	/**
	 * Two Pairs are any two pairs of cards with the same value.
	 * @param cardComparator the comparator object
	 * @return true if hand has two pairs.
	 */
	public boolean isTwoPair (CardComparator cardComparator) {
		//compare 0,1 & 2,3 or 1,2 & 3,4 or 0,1 & 3,4
		boolean[] pairs = getPairs(cardComparator);
		return (pairs[0] && pairs[2]) || (pairs[1] && pairs[3]) || (pairs[0] && pairs[3]);
	}

	/**
	 * a pair is any two cards of the same value.
	 * @param cardComparator the comparator object
	 * @return true if hand has one pair.
	 */
	public boolean isPair (CardComparator cardComparator) {
		//compare 0,1 or 1,2 or 2,3 or 3,4
		boolean[] pairs = getPairs(cardComparator);
		return pairs[0] || pairs[1] || pairs[2] || pairs[3];
	}

	/**
	 * using the custom card comparator, determines what slots of a hand contain
	 * matching pairs of cards. possible combinations are one or two pairs in a hand.
	 * @param cardComparator the comparator object.
	 * @return an array of truth values.
	 */
	public boolean[] getPairs(CardComparator cardComparator){
		boolean[] pairs = new boolean[4];
		int bound = pairs.length;
		for(int i = 0; i < bound; i++) {
			pairs[i] = cardComparator.compareValues(getHand().get(i), getHand().get(i + 1));
		}
		return pairs;
	}

	/**
	 * if a hand has none of the higher valued combinations, the highest
	 * value card is considered.
	 * @return the highest value card of the hand.
	 */
	public String highCard(){
		Card highCard = getHand().get(4);
		String result = "";
		result = result.concat("High Card: ").concat(highCard.valueToFace())
				.concat(" of ").concat(highCard.getSuit().toString());
		return result;
	}

	//dealHands method
	//deal an amount of hands and evaluate each.
	//number of hands is user determined
	//helper method to calculate probability of each hand from the sample
	//make sure to return hand to deck and shuffle the deck after each deal.

	/**
	 * deals a specified number of hands. for each hand, the type of hand is added
	 * to a list.
	 * @param trials the amount of hands to deal.
	 * @return an array of results.
	 */
	public ArrayList<String> dealHands(int trials){
		//create list to hold results
		//for loop trials
			//deal a hand
			//get the type if any
			//add the result to the list
		//return the result
		return null;
	}
	//handProbability method
	//calculates the probability of the drawn hand.
	//use imported stats library methods to calculate.

	/**
	 * calculates the probability of a dealt hand.
	 * @param handType the type of hand that was dealt.
	 * @return the probability of being dealt that hand from the deck.
	 */
	public double handProbability(String handType){
		//compare handtype to get combinations of cards associated with it
		//create stats library object
		//use combinations to calculate result
		return 0;
	}

	/**
	 * randomizes (shuffles) the contents of the deck.
	 */
	public void shuffleDeck () {
		Stack<Card> theDeck = getDeck();
		//make an array of the deck
		Card[] deckArray = new Card[FULL_DECK_COUNT];
		for (int i = 0; i < FULL_DECK_COUNT; i++) {
			deckArray[i] = theDeck.pop();
		}
		Random r = new Random();
		int shuffleSlot;
		//for each index,
		for (int i = 0; i < FULL_DECK_COUNT; i++) {
			//get a random number in the index bounds
			shuffleSlot = r.nextInt(0, FULL_DECK_COUNT);
			//ensure it is not the current index
			while (shuffleSlot == i) {
				shuffleSlot = r.nextInt(0, FULL_DECK_COUNT);
			}
			//switch the current index with that random number
			Card temp = deckArray[i];
			deckArray[i] = deckArray[shuffleSlot];
			deckArray[shuffleSlot] = temp;
		}
		//populate a new stack with the randomized deck
		for (Card c : deckArray) {
			theDeck.push(c);
		}
		//set the randomized deck as the deck global
		setDeck(theDeck);
	}

	/**
	 * populates the deck with the full 52 cards (13 of each suit).
	 * @return the populated deck object.
	 */
	public Stack<Card> makeDeck () {
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

	/**
	 * outputs the values of each card in the current hand as a single string.
	 * @return a single continuous string of card values.
	 */
	public String handToString(){
		String currHand = "";
		for (Card c : getHand()) {
			currHand = currHand.concat(String.valueOf(c.getValue()));
		}
		return currHand;
	}


	public void importObjects(String fileName) throws IOException {

	}

	/**
	 * exports the results of a run of the program to a CSV file to be used
	 * in Microsoft Excel or similar software.
	 * @param fileName the desired filename without extension.
	 * @param header the header for column names.
	 * @return a message informing the user if the export is successful.
	 * @throws IOException informs the user if the passed filename is null.
	 */

	public String exportObjects(String fileName, String header) throws IOException {
		return null;
	}

	//constructor
	public HandEvaluator( int handSize){
		setDeck(makeDeck());
		setHand(new ArrayList<>(handSize));
	}
	//getters and setters
	public Stack<Card> getDeck () {
		return deck;
	}
	public void setDeck (Stack < Card > deck) {
		this.deck = deck;
	}
	public ArrayList<Card> getHand () {
		return hand;
	}
	public void setHand (ArrayList < Card > hand) {
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