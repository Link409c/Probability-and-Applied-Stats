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
		CardComparator comp = new CardComparator();
		//bubble sort will work since size is small.
		ArrayList<Card> theHand = getHand();
		int handSize = theHand.size();
		for (int i = 0; i < handSize - 1; i++) {
			for (int j = i + 1; j < handSize; j++) {
				if (comp.compare(theHand.get(i), theHand.get(j)) > 0) {
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
		String result = "";
		sortHand();
		//poker hands, in order from greatest to least:
		//royal flush
		if (isRoyalFlush()) {
			result = "Royal Flush";
		}
		//straight flush
		else if (isStraightFlush()) {
			result = "Straight Flush";
		}
		//four of a kind
		else if (isFourOfAKind()) {
			result = "Four of a Kind";
		}
		//full house
		else if (isFullHouse()) {
			result = "Full House";
		}
		//flush
		else if (isFlush()) {
			result = "Flush";
		}
		//straight
		else if (isStraight()) {
			result = "Straight";
		}
		//three of a kind
		else if (isThreeOfAKind()) {
			result = "Three of a Kind";
		}
		//two Pair
		else if (isTwoPair()){
			result = "Two Pair";
		}
		//pair
		else if (isPair()){
			result = "One Pair";
		}
		//highCard
		else {
			result = highCard();
		}
		return result;
	}

	//10, J, Q, K, A must all be the same suit.
	public boolean isRoyalFlush () {
		//get hand as string
		String currHand = handToString();
		//compare string to given
		String royalFlush = "110111213";
		//if match, compare suits
		if (currHand.equals(royalFlush)) {
			return isFlush();
		} else {
			return false;
		}
	}

	//a straight of all the same suit.
	//if a = b - 1,
	//if b = c - 1,
	//if c = d - 1,
	//if d = e - 1,
	//and suit=suit=suit=suit=suit,
	//hand is a straight flush
	public boolean isStraightFlush () {
		return isStraight() && isFlush();
	}

	//four cards of the same rank.
	//after sorting first or last card should be different.
	//if a=b=c=d or b=c=d=e,
	//hand is four of a kind
	public boolean isFourOfAKind () {
		//get hand as string
		String currHand = handToString();
		//if char 0 = char 3 or char 1 = char 4, return true
		return currHand.charAt(0) == currHand.charAt(3) || currHand.charAt(1) == currHand.charAt(4);
	}

	//three of a kind and a pair.
	//after sorting two combinations are possible,
	//AABBB or AAABB
	//if either is true,
	//hand is a full house
	public boolean isFullHouse () {
		//get first and last card values
		int first = getHand().get(0).getValue();
		int last = getHand().get(4).getValue();
		//return comparison of hand to either AABBB or AAABB
		String currHand = handToString();
		return currHand.equals(String.valueOf(first) + first + last + last + last)
				|| currHand.equals(String.valueOf(first) + first + first + last + last);
	}

	//any five cards of the same suit, but not in sequence.
	//if a.suit = b,c,d,e suit,
	//hand is a flush
	public boolean isFlush () {
		CardComparator crp = new CardComparator();
		int handSize = getHand().size();
		Card ace = getHand().get(0);
		Card next;
		boolean sameSuit = false;
		for (int i = 1; i < handSize; i++) {
			next = getHand().get(i);
			sameSuit = crp.compareSuits(ace, next);
			if (!sameSuit) {
				break;
			}
		}
		return sameSuit;
	}

	//any 5 cards in sequential order that are not a flush.
	//if a = b - 1,
	//if b = c - 1,
	//if c = d - 1,
	//if d = e - 1,
	//hand is a straight
	public boolean isStraight () {
		boolean oneLess = true;
		for (int i = 0; i < getHand().size(); i++) {
			int first = getHand().get(i).getValue();
			int second = getHand().get(i + 1).getValue();
			oneLess = (first == second);
			if (!oneLess) {
				break;
			}
		}
		return oneLess;
	}

	//three cards of the same rank.
	//three possible combinations,
	//AAABC or ABBBC or ABCCC
	//if any are true,
	//hand is three of a kind
	public boolean isThreeOfAKind () {
		//get hand as string
		String currHand = handToString();
		//compare first char to last char of possible groupings
		return currHand.charAt(0) == currHand.charAt(2) || currHand.charAt(1) == currHand.charAt(3)
				|| currHand.charAt(2) == currHand.charAt(4);
	}

	//two pairs.
	//three combos,
	//AABBC or ABBCC or AABCC
	//if any are true,
	//hand is two pair
	public boolean isTwoPair () {
		//get hand as string
		String currHand = handToString();
		//compare 0,1 & 2,3 or 1,2 & 3,4 or 0,1 & 3,4
		boolean pairsA = (currHand.charAt(0) == currHand.charAt(1)
				&& currHand.charAt(2) == currHand.charAt(3));
		boolean pairsB = (currHand.charAt(1) == currHand.charAt(2)
				&& currHand.charAt(3) == currHand.charAt(4));
		boolean pairsC = (currHand.charAt(0) == currHand.charAt(1)
				&& currHand.charAt(3) == currHand.charAt(4));
		return pairsA || pairsB || pairsC;
	}

	//two cards of the same rank.
	//four combos,
	//AABCD or ABBCD or ABCCD or ABCDD
	//if any are true,
	//hand is a pair
	public boolean isPair () {
		//get hand as string
		String currHand = handToString();
		//compare 0,1 or 1,2 or 2,3 or 3,4
		boolean pairA = currHand.charAt(0) == currHand.charAt(1);
		boolean pairB = currHand.charAt(1) == currHand.charAt(2);
		boolean pairC = currHand.charAt(2) == currHand.charAt(3);
		boolean pairD = currHand.charAt(3) == currHand.charAt(4);
		return pairA || pairB || pairC || pairD;
	}

	//considers highest rank card when no special hand is drawn.
	//eg. 1, 3, 4, 7, J - Jack is high card.
	//if all of the above are false,
	//hand has high card.
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