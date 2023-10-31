package Mini_Coding_Projects.Monty_Hall_DealNoDeal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The Monte Hall Problem:
 * (reference Pg. 34 2.20 for this assignment.)
 */
public class MonteHall {

    /*
     * Three Doors - Two have goats and one has a car.
     * A: Play 10,000 times without changing the door picked.
     * B: Play 10,000 times changing the chosen door.
     * No more than 4 lines of code in main method.
     * Answer questions A & B in the comments.
     */

    //run games method
    public String runGames(int tries, boolean change) {
        //accepts number of tries as input and change door choice as input
        Random r = new Random();
        int bound = DOORS_SIZE+1;
        //for each try,
        for(int i = 0; i < tries; i++) {
            //randomly assign the winning door
            int winningDoor = r.nextInt(1, bound);
            //randomly pick a door as our choice
            int contestantChoice = r.nextInt(1, bound);
            int[] doors = {1, 2, 3};
            //host shows one of the non winning doors
            //remove our door from the array
            //remove winning door from the array
            //host chooses from the remaining doors
            //if change is true, change to another door
            if(change) {

            }
            //else do not change doors
            //if winner = choice, increment wins
            if(winningDoor == contestantChoice) {
                setWins(getWins() + 1);
            }
        }
        String result;
        //return a string telling user various statistics about the games
        if(change){
            result = "In 10000 Games, you changed your door each time and won " + getWins() + " times.";
        }
        else{
            result = "In 10000 Games, you did not change your door and won " + getWins() + " times.";
        }
        return result;
    }

    public MonteHall(){
        setWins(0);
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    private int wins;

    private static final int DOORS_SIZE = 3;

}
