/*
 * Justin Powers
 * COP3330C Fall 2018
 * Assignment 2:
 *
 * Description: Two problems; Exercise 7.20 and 15.8.
 *
 * I used actual comments this time, Kyle!
 */

/*
Assignment 2:
    Contains main(String[] args).
    main is a public static object with type void. Calls Exercise 7.20 and 15.8 Part 1 and 2.
*/
public class Assignment2
{
    public static void main(String[] args)
    {
        Exercise720 mySales = new Exercise720();
        mySales.Sales();

        Exercise158P1 exercise158P1 = new Exercise158P1();
        exercise158P1.outputData();

        Exercise158P2 exerciseTest = new Exercise158P2();
        exerciseTest.outputFrequency();
    }
}
