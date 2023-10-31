package Mini_Coding_Projects.Hand_Evaluator;

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

    }


}
