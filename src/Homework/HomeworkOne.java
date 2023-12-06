package Homework;

import Project_1_Midterm.Stats_Library_Set_Operations.StatsLibrary;

public class HomeworkOne {

    public static void main(String[] args) {

        StatsLibrary homeworkCheck = new StatsLibrary();

        //Pg. 32 2.10, 2.11, 2.14, 2.18

        //2.10
        /*
        The proportions of blood phenotypes, A, B, AB, and O, in the population of all Caucasians in
        the United States are approximately .41, .10, .04, and .45, respectively. A single Caucasian is
        chosen at random from the population.

        a List the sample space for this experiment.
        b Make use of the information given above to assign probabilities to each of the simple events.
        c What is the probability that the person chosen at random has either type A or type AB
        blood?
        */

        //Solution
        /*
        a, b. P(E1) = .41 "A"
              P(E2) = .10 "B"
              P(E3) = .04 "AB"
              P(E4) = .45 "O"

           c. P(E1uE3) = .41 + .04 = .45
         */

        //2.11
        /*
        A sample space consists of five simple events, E1, E2, E3, E4, and E5.

        a If P(E1) = P(E2) = 0.15, P(E3) = 0.4, and P(E4) = 2P(E5), find the probabilities of
        E4 and E5.
        b If P(E1) = 3P(E2) = 0.3, find the probabilities of the remaining simple events if you
        know that the remaining simple events are equally probable.
        */

        //Solution
        /*
        a. P(E1uE2uE3) = .15 + .15 + .40 = .70
           P(E4uE5) = 1 - P(E1uE2uE3) = .30 = 3P(E5)
           P(E5) = .10
           P(E4) = .20

        b. P(E1) = .30
           P(E2) = .10
           P(E3) = P(E4) = P(E5) = .20
         */

        //2.14
        /*
        A survey classified a large number of adults according to whether they were diagnosed as
        needing eyeglasses to correct their reading vision and whether they use eyeglasses when reading.
        The proportions falling into the four resulting categories are given in the following table:

                        Uses Glasses For Reading
        Needs Glasses      YES          NO
            YES            .44         .14
            NO             .02         .40

        If a single adult is selected from the large group, find the probabilities of the events defined below.
        The adult
        a needs glasses.
        b needs glasses but does not use them.
        c uses glasses whether the glasses are needed or not.

         */

        //Solution
        /*
        P(E1) = .44 P(E2) = .14 P(E3) = .02 P(E4) = .40
        a. P(E1uE2) = .44 + .14 = .58
        b. P(E20 = .14
        c. P(E1uE3) = .44 + .02 = .46
         */

        //2.18
        /*
        Suppose two balanced coins are tossed and the upper faces are observed.
        a List the sample points for this experiment.
        b Assign a reasonable probability to each sample point. (Are the sample points equally
        likely?)
        c Let A denote the event that exactly one head is observed and B the event that at least one
        head is observed. List the sample points in both A and B.
        d From your answer to part (c), find P(A), P(B), P(A ∩ B), P(A ∪ B), and P(A' ∪ B).
         */

        //Solution
        /*
        a. E1 = {HH}, E2 = {HT}, E3 = {TH}, E4 = {TT}
        b. P(H) = 1/2, P(T) = 1/2
           P(E1) = P(E2) = P(E3) = P(E4) = .25
        c. A = E2, E3; B = E1, E2, E3
        d. P(A) = 1/2
           P(B) = 3/4
           P(AnB) = 1/2
           P(AuB) = 3/4
           P(A'uB) = 1
         */
    }

}
