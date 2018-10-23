import java.util.Scanner;
public class Exercise720
{
    public void Sales()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter salesperson number (-1 to end): ");
        int iSalesPerson = input.nextInt();

        double[][] sales = new double[5][4];
        while (iSalesPerson != -1)
        {
            System.out.print("Enter product number: ");
            int iProductNumber = input.nextInt();
            System.out.print("Enter sales amount: ");
            double dSalesAmount = input.nextDouble();

            if (iSalesPerson >= 1 && iSalesPerson < 5 && iProductNumber >= 1 && iProductNumber < 6 && dSalesAmount >= 0)
            {
                sales[iProductNumber - 1][iSalesPerson - 1] += dSalesAmount;
            } else
                System.out.println("Invalid input!");

            System.out.print("Enter salesperson number (-1 to end): ");
            iSalesPerson = input.nextInt();
        }
        double dSalesPersonTotal[] = new double[4];

        for(int iColumn = 0; iColumn < 4; iColumn++)
        {
            dSalesPersonTotal[iColumn] = 0;
        }

        System.out.printf("%8s%14s%14s%14s%14s%10s\n", "Product", "Salesperson 1", "Salesperson 2", "Salesperson 3", "Salesperson 4", "Total");

        for(int iRow = 0; iRow < 5; iRow++)
        {
            double productTotal = 0.0;
            System.out.printf("%8d", (iRow + 1));

            for(int column = 0; column < 4; column++)
            {
                System.out.printf("%14.2f", sales[iRow][column]);
                productTotal += sales[iRow][column];
                dSalesPersonTotal[column] += sales[iRow][column];
            }

            System.out.printf("%10.2f\n", productTotal);
        }

        System.out.printf("%8s", "Total");

        for(int column = 0; column < 4; column++)
        {
            System.out.printf("%14.2f", dSalesPersonTotal[column]);
        }

        System.out.println();
    }
}