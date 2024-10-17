import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");

        // Step 1: Input temperature value
        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();

        // Step 2: Choose conversion direction
        System.out.println("Choose conversion direction:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        double convertedTemperature;

        // Step 3: Perform conversion based on user's choice
        if (choice == 1) {
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f Celsius = %.2f Fahrenheit\n", temperature, convertedTemperature);
        } else if (choice == 2) {
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f Fahrenheit = %.2f Celsius\n", temperature, convertedTemperature);
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }

        // Step 4: Test with different values (can be done during program execution)
        scanner.close();
    }
}
