package Mini_Coding_Projects.Monty_Hall_DealNoDeal;

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

    /**
     * plays the Monty Hall game a specified number of times with the option to
     * change the chosen door or not.
     * @param tries the number of trials to conduct
     * @param change if true, changes the chosen door to one of the remaining ones.
     * @return the result of the trials as a String.
     */
    public String runGames(int tries, boolean change) {
        //accepts number of tries as input and change door choice as input
        Random r = new Random();
        int bound = 4;
        int winningDoor, contestantChoice, hostDoor;
        //for each try,
        for (int i = 0; i < tries; i++) {
            //randomly assign the winning door
            winningDoor = r.nextInt(1, bound);
            //randomly pick a door as our choice
            contestantChoice = r.nextInt(1, bound);
            //pick host door
            hostDoor = -1;
            if (winningDoor == contestantChoice) {
                //host door can be two choices
                //check winningDoor
                switch (winningDoor) {
                    //if 1 host picks 2 or 3
                    case 1 -> hostDoor = r.nextInt(2, 4);
                    //if 2 host picks 1 or 3
                    case 2 -> {
                        hostDoor = r.nextInt(0, 2);
                        int[] choices = {1, 3};
                        hostDoor = choices[hostDoor];
                    }
                    //if 3 host picks 1 or 2
                    case 3 -> hostDoor = r.nextInt(1, 3);
                }
            }
            //else host has one choice
            else {
                hostDoor = getRemainingDoor(winningDoor, contestantChoice);
            }
            if (change) {
                //if winner is your door and you switch you lose
                if (winningDoor == contestantChoice) {
                    contestantChoice = getRemainingDoor(winningDoor, hostDoor);
                    //if you did not pick the winner,
                    //if you change doors you should win
                } else {
                    contestantChoice = getRemainingDoor(contestantChoice, hostDoor);
                }
            }
            //else do not change doors
            //if winner = choice, increment wins
            if (winningDoor == contestantChoice) {
                setWins(getWins() + 1);
            }
        }
        String result;
        //return a string telling user various statistics about the games
        if (change) {
            result = "In " + tries + " Games, you changed your door each time and won " + getWins() + " times.";
        } else {
            result = "In " + tries + " Games, you did not change your door and won " + getWins() + " times.";
        }
        return result;
    }

    /**
     * A helper method designed to get the remaining choice to make or change to from
     * the selection of choices provided. Based on the winning choice and user or
     * Host choice that was already made.
     * @param winningDoor the door containing the prize for this run of the game
     * @param contestantOrHost the door the contestant or host has chosen, depending
     *                         on where the method is called.
     * @return the remaining choice that can be made based on
     */
    public int getRemainingDoor(int winningDoor, int contestantOrHost){
        String doors = "123";
        char winner = Character.forDigit(winningDoor, 8);
        //contestant or host door choice
        char cOrH = Character.forDigit(contestantOrHost, 8);
        //remove passed door choices from the total
        doors = doors.replace(winner, ' ');
        doors = doors.replace(cOrH, ' ');
        doors = doors.trim();
        return Integer.parseInt(doors);
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

}
