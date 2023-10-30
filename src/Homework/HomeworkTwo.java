package Homework;

import Project_1_Stats_Library.StatsLibrary;

public class HomeworkTwo {

    public static void main(String[] args) {

        //Pg. 39 2.28, 2.33, 2.34

        StatsLibrary homeworkCheck = new StatsLibrary();

        //2.28
        /*
        Four equally qualified people apply for two identical positions in a company. One and only
        one applicant is a member of a minority group. The positions are filled by choosing two of the
        applicants at random.
        a List the possible outcomes for this experiment.
        b Assign reasonable probabilities to the sample points.
        c Find the probability that the applicant from the minority group is selected for a position.
         */

        //Solution
        /*
        a. S = {A, B, C, D}
        E1 = {A,B}; E2 = {A,C}; E3 = {A,D}; E4 = {B,A}; E5 = {B,C}; E6 = {B,D}
        E7 = {C,A}; E8 = {C,B}; E9 = {C,D}; E10 = {D,A}; E11 = {D,B}; E12 = {D,C}
        b. p = 1/12
        c. P(E3uE6uE9uE10uE11uE12) = 1/2
         */

        //2.33
        /*
        The Bureau of the Census reports that the median family income for all families in the United
        States during the year 2003 was $43,318. That is, half of all American families had incomes
        exceeding this amount, and half had incomes equal to or below this amount. Suppose that four
        families are surveyed and that each one reveals whether its income exceeded $43,318 in 2003.
        a List the points in the sample space.
        b Identify the simple events in each of the following events:
            A: At least two had incomes exceeding $43,318.
            B: Exactly two had incomes exceeding $43,318.
            C: Exactly one had income less than or equal to $43,318.
        c Make use of the given interpretation for the median to assign probabilities to the simple
        events and find P(A), P(B), and P(C).
         */

        //Solution
        /*
        a. 4H = {HHHH},
           3H1L = {LHHH}, {HLHH}, {HHLH}, {HHHL},
           2H2L = {HHLL}, {LHHL}, {LLHH}, {HLLH}, {HLHL}, {LHLH},
           1H3L = {HLLL}, {LHLL}, {LLHL}, {LLLH},
           4L = {LLLL}
        b.
            a. P(>=2H) = P(4Hu3Hu2H) = 1/16 + 4/16 + 6/16 = 11/16
            b. P(2H) = 6/16
            c. P(1L) = P(3H) = 1/4
        c. above
         */

        //2.34
        /*
        Patients arriving at a hospital outpatient clinic can select one of three stations for service.
        Suppose that physicians are assigned randomly to the stations and that the patients therefore
        have no station preference. Three patients arrive at the clinic and their selection of stations is
        observed.
        a List the sample points for the experiment.
        b Let A be the event that each station receives a patient. List the sample points in A.
        c Make a reasonable assignment of probabilities to the sample points and find P(A).
         */

        //Solution
        /*
        S = {A,B,C}, p = 1/27
        a. {AAA}, {AAB}, {AAC}, {ABA}, {ABB}, {ABC}, {ACA}, {ACB}, {ACC}, {BAA}, {BAB}, {BAC}, {BBA}, {BBB},
           {BBC}, {BCA}, {BCB}, {BCC}, {CAA}, {CAB}, {CAC}, {CBA}, {CBB}, {CBC}, {CCA}, {CCB}, {CCC}
        b. A = {ABC}, {ACB}, {BAC}, {BCA}, {CAB}, {CBA}
        c. P(A) = 6/27
         */
    }

}
