/*
Import java.io.File for use in reading from the file.
Import java.io.FileNotFoundException for use in outputData to catch if the file is found.
Import Java.util.* for all other functions.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
Exercise 15.8 Part 2:
    Contains outputFrequency().
    outputFrequency is a public object with type void. It gathers the integers from the numbers.txt file and gathers the frequency. It then outputs the frequency to the output.txt file.
*/

public class Exercise158P2
{
    /*
    outputFrequency: Called to output to "output.txt" the frequency of each number entered from 1-5.
        iFrequencyArray: Declared as a 6 int long int array.
        fWriter: Formatter. Declared later as the output.txt. Will create file if needed.
        sPollNumbers: Scanner. Declared later as the number.txt file from Exercise158P1.

        Output's "Rating" and "Frequency" to output.txt.
        Keep adding the numbers from the numbers.txt file to the iFrequencyArray while there are values to be read to the respective rating.
        Starting at 1, output to the "output.txt" file the Rating (1-5) and the Frequency gathered from the numbers.txt file.

        Catch file read error; File not open & No Files.
     */
    public void outputFrequency()
    {
        int iFrequencyArray[] = new int[6];

        Formatter fWriter;
        Scanner sPollNumbers;

        try
        {
            sPollNumbers = new Scanner(new File("numbers.txt"));

            fWriter = new Formatter("output.txt");

            fWriter.format("%-12s%-12s\n", "Rating", "Frequency");

            while (sPollNumbers.hasNext())
                ++iFrequencyArray[sPollNumbers.nextInt()];

            for (int rating = 1; rating < iFrequencyArray.length; rating++)
                fWriter.format("%-12d%-12d\n", rating, iFrequencyArray[rating]);
        } catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error: Files cannot be opened.");
        } catch (FormatterClosedException formatterClosedException)
        {
            System.err.println("Error: Output file is closed.");
        } catch (IllegalStateException illegalStateException)
        {
            System.err.println("Error: Input file is closed.");
        }
    }
}
