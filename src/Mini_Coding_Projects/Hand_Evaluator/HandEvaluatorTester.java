package Mini_Coding_Projects.Hand_Evaluator;

import java.util.ArrayList;

public class HandEvaluatorTester {

    public static void main(String[] args){

        int handSize = 5;
        HandEvaluator pokerHands = new HandEvaluator(handSize);

        //test deck creation
        System.out.printf("%d card Deck:\n", pokerHands.getDeck().size());
        for(Card c : pokerHands.getDeck()){
            System.out.println(c.getValue() + " of " + c.getSuit().toString());
        }
        //shuffle deck
        pokerHands.shuffleDeck();
        System.out.printf("\nShuffled %d card Deck:\n", pokerHands.getDeck().size());

        //test shuffle
        for(Card c : pokerHands.getDeck()){
            System.out.println(c.getValue() + " of " + c.getSuit().toString());
        }

        //test hand creation
        System.out.println("\nTest Hand:");
        pokerHands.drawHand(handSize);
        for(Card c : pokerHands.getHand()) {
            System.out.println(c.getValue() + " of " + c.getSuit().toString());
        }

        //test sorting
        pokerHands.sortHand();
        System.out.println("\nSorted Hand:");
        for(Card c : pokerHands.getHand()) {
            System.out.println(c.getValue() + " of " + c.getSuit().toString());
        }

        //test hand type methods
        String testResult = "Royal Flush";
        //royal flush
        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(new Card(Suit.Hearts, 10));
        testHand.add(new Card(Suit.Hearts, 13));
        testHand.add(new Card(Suit.Hearts, 1));
        testHand.add(new Card(Suit.Hearts, 12));
        testHand.add(new Card(Suit.Hearts, 11));
        pokerHands.setHand(testHand);
        System.out.println("\nTesting Hand Evaluation:\n");
        System.out.println("Royal Flush: " + pokerHands.evaluateHand().equals(testResult));
        //straight flush
        testHand.clear();
        testResult = "Straight Flush";
        testHand.add(new Card(Suit.Spades, 4));
        testHand.add(new Card(Suit.Spades, 3));
        testHand.add(new Card(Suit.Spades, 2));
        testHand.add(new Card(Suit.Spades, 1));
        testHand.add(new Card(Suit.Spades, 5));
        pokerHands.setHand(testHand);
        System.out.println("Straight Flush: " + pokerHands.evaluateHand().equals(testResult));
        //4 of a kind
        testHand.clear();
        testResult = "Four of a Kind";
        testHand.add(new Card(Suit.Spades, 10));
        testHand.add(new Card(Suit.Hearts, 10));
        testHand.add(new Card(Suit.Spades, 3));
        testHand.add(new Card(Suit.Diamonds, 10));
        testHand.add(new Card(Suit.Clubs, 10));
        pokerHands.setHand(testHand);
        System.out.println("Four of a Kind: " + pokerHands.evaluateHand().equals(testResult));
        //full house
        testHand.clear();
        testResult = "Full House";
        testHand.add(new Card(Suit.Spades, 1));
        testHand.add(new Card(Suit.Hearts, 1));
        testHand.add(new Card(Suit.Spades, 2));
        testHand.add(new Card(Suit.Diamonds, 1));
        testHand.add(new Card(Suit.Clubs, 2));
        pokerHands.setHand(testHand);
        System.out.println("Full House: " + pokerHands.evaluateHand().equals(testResult));
        //flush
        testHand.clear();
        testResult = "Flush";
        testHand.add(new Card(Suit.Spades, 1));
        testHand.add(new Card(Suit.Spades, 2));
        testHand.add(new Card(Suit.Spades, 5));
        testHand.add(new Card(Suit.Spades, 7));
        testHand.add(new Card(Suit.Spades, 9));
        pokerHands.setHand(testHand);
        System.out.println("Flush: " + pokerHands.evaluateHand().equals(testResult));
        //straight
        testHand.clear();
        testResult = "Straight";
        testHand.add(new Card(Suit.Spades, 5));
        testHand.add(new Card(Suit.Hearts, 6));
        testHand.add(new Card(Suit.Spades, 7));
        testHand.add(new Card(Suit.Diamonds, 8));
        testHand.add(new Card(Suit.Clubs, 9));
        pokerHands.setHand(testHand);
        System.out.println("Straight: " + pokerHands.evaluateHand().equals(testResult));
        //3 of a kind
        testHand.clear();
        testResult = "Three of a Kind";
        testHand.add(new Card(Suit.Spades, 1));
        testHand.add(new Card(Suit.Hearts, 4));
        testHand.add(new Card(Suit.Diamonds, 1));
        testHand.add(new Card(Suit.Diamonds, 7));
        testHand.add(new Card(Suit.Clubs, 1));
        pokerHands.setHand(testHand);
        System.out.println("Three of a Kind: " + pokerHands.evaluateHand().equals(testResult));
        //2 pair
        testHand.clear();
        testResult = "Two Pair";
        testHand.add(new Card(Suit.Spades, 10));
        testHand.add(new Card(Suit.Hearts, 12));
        testHand.add(new Card(Suit.Clubs, 10));
        testHand.add(new Card(Suit.Diamonds, 12));
        testHand.add(new Card(Suit.Clubs, 11));
        pokerHands.setHand(testHand);
        System.out.println("Two Pair: " + pokerHands.evaluateHand().equals(testResult));
        //pair
        testHand.clear();
        testResult = "One Pair";
        testHand.add(new Card(Suit.Spades, 13));
        testHand.add(new Card(Suit.Hearts, 10));
        testHand.add(new Card(Suit.Spades, 6));
        testHand.add(new Card(Suit.Diamonds, 9));
        testHand.add(new Card(Suit.Clubs, 10));
        pokerHands.setHand(testHand);
        System.out.println("One Pair: " + pokerHands.evaluateHand().equals(testResult));
        //high card
        testHand.clear();
        testResult = "High Card: King of Spades";
        testHand.add(new Card(Suit.Spades, 13));
        testHand.add(new Card(Suit.Hearts, 1));
        testHand.add(new Card(Suit.Spades, 12));
        testHand.add(new Card(Suit.Diamonds, 8));
        testHand.add(new Card(Suit.Clubs, 5));
        pokerHands.setHand(testHand);
        System.out.println("High Card: " + pokerHands.evaluateHand().equals(testResult));
    }
}
