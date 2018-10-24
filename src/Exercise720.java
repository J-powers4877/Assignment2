/*
Import java.util.scanner for use in reading user's values from keyboard for salesperson, product number, and sales amount.
 */
import java.util.Scanner;

/*
Exercise 7.20:
    Contains Sales().
    Sales is a public object with type void. Gathers the Salesperson Number (1-4), the product number, and their sales amount.
    This is output to the console using printf.
*/
public class Exercise720
{
    /*
    Sales: Called to receive input from the user and output the formatted table to the console.
        sInput: Scanner. Used to read the user input from the keyboard.
        iSalesPerson: Integer. Reads in value user input to get the correct Salesperson.
        dSalesArray: 2D Array. Declared to 5 x 4, one for each product and Salesperson.
        iProductNumber: Integer. Reads in value user inputs to get the right Product.
        dSalesAmount: Double. Reads in user's defined sales amount.
        dSalesPersonTotal: Double Array. Used to get the totals each salesperson sells.
     */
    public void Sales()
    {
        Scanner sInput = new Scanner(System.in);

        System.out.print("Enter salesperson number (-1 to end): ");
        int iSalesPerson = sInput.nextInt();

        double[][] dSalesArray = new double[5][4];

        /*
        Prompt user to input salesperson number. -1 Ends the loop. Read the value into iSalesPerson.
        While iSalesPerson isn't -1, have the user enter the product number and sales amount.
        Check if the salesperson and product number are all in the correct bounds, sets the correct slot in the array to the values given.
        Throw exception otherwise.
         */
        while (iSalesPerson != -1)
        {
            System.out.print("Enter product number: ");
            int iProductNumber = sInput.nextInt();
            System.out.print("Enter sales amount: ");
            double dSalesAmount = sInput.nextDouble();

            if (iSalesPerson >= 1 && iSalesPerson < 5 && iProductNumber >= 1 && iProductNumber < 6 && dSalesAmount >= 0)
            {
                dSalesArray[iProductNumber - 1][iSalesPerson - 1] += dSalesAmount;
            } else
                System.out.println("Invalid input!");

            System.out.print("Enter salesperson number (-1 to end): ");
            iSalesPerson = sInput.nextInt();
        }
        double dProductTotal[] = new double[4];

        /*
        Sets the total amount to 0 for each salesperson.
        Print out Product, Salesperson 1 - 4, and Total.
         */
        for (int iColumn = 0; iColumn < 4; iColumn++)
        {
            dProductTotal[iColumn] = 0;
        }

        System.out.printf("%8s%14s%14s%14s%14s%10s\n", "Product", "Salesperson 1", "Salesperson 2", "Salesperson 3", "Salesperson 4", "Total");

        /*
        Print out each row, print out the column, go to the next row.
        Add each row in the column, print out the product total.
        Add each row to the dProductTotal for later.
         */
        for (int iRow = 0; iRow < 5; iRow++)
        {
            double productTotal = 0.0;
            System.out.printf("%8d", (iRow + 1));

            for (int column = 0; column < 4; column++)
            {
                System.out.printf("%14.2f", dSalesArray[iRow][column]);
                productTotal += dSalesArray[iRow][column];
                dProductTotal[column] += dSalesArray[iRow][column];
            }

            System.out.printf("%10.2f\n", productTotal);
        }

        System.out.printf("%8s", "Total");

        /*
        Print out the dProductTotal of each row.
         */
        for (int column = 0; column < 4; column++)
        {
            System.out.printf("%14.2f", dProductTotal[column]);
        }

        System.out.println();
    }
}