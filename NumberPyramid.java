import java.util.Scanner;
public class NumberPyramid
{
    public static void main(String[] args)
    {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Get the number of rows from the user
        System.out.print("Enter the number of rows for the pyramid: ");
        int rows = scanner.nextInt();

        // Loop through each row
        for (int i = 1; i <= rows; i++)
        {
            // Print spaces before numbers to center the pyramid
            for (int j = rows; j > i; j--)
            {
                System.out.print(" ");
            }

            // Print numbers in increasing order for each row
            for (int k = 1; k <= i; k++)
            {
                System.out.print(k + " ");
            }

            // Move to the next line after printing each row
            System.out.println();
        }

        scanner.close();
    }
}
