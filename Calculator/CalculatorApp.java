import java.util.Scanner;
// Main class
public class CalculatorApp {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n Calculator");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Exponentiation (Power)");
            System.out.println("7. Temperature Conversion");
            System.out.println("8. Currency Conversion");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> CalculatorFunctions.addition(sc);
                case 2 -> CalculatorFunctions.subtraction(sc);
                case 3 -> CalculatorFunctions.multiplication(sc);
                case 4 -> CalculatorFunctions.division(sc);
                case 5 -> CalculatorFunctions.squareRoot(sc);
                case 6 -> CalculatorFunctions.exponentiation(sc);
                case 7 -> CalculatorFunctions.temperatureConversion(sc);
                case 8 -> CalculatorFunctions.currencyConversion(sc);
                case 9 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}
