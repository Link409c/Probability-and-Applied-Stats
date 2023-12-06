package Project_1_Midterm.Mini_Coding_Projects.Monty_Hall_DealNoDeal;

public class MonteHallTester {
    public static void main(String[] args) {

        MonteHall monteHall = new MonteHall();

        /*
        Simple Probability of random choice is ~ 1/3.

        Probability of picking the winning door after seeing a dud is ~ 2/3.
         */

        System.out.println("\nThe Monty Hall Game");
        System.out.println(monteHall.runGames(10000, true));
        monteHall.setWins(0);
        System.out.println(monteHall.runGames(10000, false));
    }
}
