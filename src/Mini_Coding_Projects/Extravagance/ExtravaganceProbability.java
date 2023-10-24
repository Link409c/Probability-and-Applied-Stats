package Mini_Coding_Projects.Extravagance;
import java.util.ArrayList;


/**
 * This program allows the user to calculate the probability
 * involved in using the Yu-Gi-Oh! card, "Pot of Extravagance".
 * Author: Link409c
 * Version: 0.01 | 10/23/23
 **/
public class ExtravaganceProbability {

    //error reduction methods:
    //method to check extra deck size
    //method to check card amounts in ED
    //method to check banish amount
    //method to check card names
    //method to check targets array size

    //supplemental methods:
    //method to construct the extra deck
    //method to add / remove cards
    //method to return the extra deck as a formatted list
    //method to return the targets of the probability
    //method to calculate probability of targets

    //method to "activate" extrav
    //method to return results strings
    //method to format printed output

    //user prompt methods:
    //prompt banish amount
    //prompt names to target
    //prompt quit or continue

    //high level of what the program does / example run
    //opens with the name, version, author, maybe some ASCII art.
    //succinctly describe the program for the user
    //prompt the user to build the extra deck
    //user enters names and quantities
    //once extra deck is full, prompt user to continue
    //on continue, prompt for use of extrav or modify ED.
    //when extrav is chosen, user chooses banish amount.
    //based on banish amount, display the permutations of that choice.
    //


    //method to run the program
        //prompt user to populate extra deck
        //user inputs card names and quantities
        //loops while quit is false
            //activate extrav
            //

    //what goes in main?
    //all print statements
    //all user inputs
    //

    /**
     * The list of cards comprising the Extra Deck.
     */
    private ArrayList<String> extraDeck;

    /**
     * The limit for size of the extra deck.
     */
    private static final int EXTRA_DECK_LIMIT = 15;

    /**
     * The number of cards to pay as cost to activate
     * Pot of Extravagance. Must be 3 or 6.
     */
    private int numberToBanish;

    /**
     * A list of cards, if any, to specify as targets
     * of the probability calculation.
     */
    private String[] targets;
}
