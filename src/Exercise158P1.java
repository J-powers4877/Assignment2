/*
Import java.io.FileNotFoundException for use in outputData to catch if the file is found
Import Java.util.* for all other functions
 */
import java.io.FileNotFoundException;
import java.util.*;

/*
Exercise 15.8 Part 1:
    Contains getValue() and outputData().
    getValue is a private object with type int. It gathers the integers that the user wants to input and returns the integer value.

    outputData is a public object with type void. It creates the numbers.txt file, gets the value that is input from the user, and puts it in the pollNumbers Formatter.
    Throws an exception when the file isn't open.

 */
public class Exercise158P1
{
    /*
    getValue: Used in the outputData object. Used to get the user's input.
        iResult: Used as the variable the user's input is passed to in order to return it.
        sUserInput: Scanner. Used to read value from keyboard

        Print out message to user.
        Read in the User's value to the iResult.
        Return iResult to the object.

     */
    private int getValue()
    {
        int iResult;
        Scanner sUserInput = new Scanner(System.in);

        System.out.print("Enter integer result (1 - 5), -1 to quit: ");

        iResult = sUserInput.nextInt();

        return iResult;
    }

    /*
    pollNumbers: Formatter. Used to format the iPollValue that are received from the user to output to the numbers.txt file.
    iPollValue: Variable that the value from getValue is set as. Used to format the output.

    Try/Catch statement: Try to format the values that are received, only if the file is open.

    pollNumbers opens the numbers.txt file, otherwise creates one.
    Check if the value is from 1 to 5, otherwise run getValue again. Run until -1 is entered.
    When -1 is entered, close the file.
     */
    public void outputData()
    {
        Formatter pollNumbers;

        try
        {
            pollNumbers = new Formatter("numbers.txt");

            int iPollValue = getValue();

            while (iPollValue != -1)
            {
                if (iPollValue > 0 && iPollValue < 6)
                {
                    pollNumbers.format("%d\n", iPollValue);
                }
                iPollValue = getValue();
            }

            pollNumbers.close();
        }catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Output file cannot be found.");
        }
    }
}