package Mini_Coding_Projects.Monty_Hall_DealNoDeal;

public class MonteHallTester {
    public static void main(String[] args) {
        MonteHall monteHall = new MonteHall();
        /*
        Simple Probability of random choice is 1/3.

        Probability of picking the winning door after seeing a dud is
         */

        //test choices

        //test removing doors from choices to simulate seeing a goat


        System.out.println(monteHall.runGames(10000, true));
        System.out.println(monteHall.runGames(10000, false));
    }
}
