import java.util.Scanner;


class CalculatorFunctions {

    // Basic Arithmetic Operations
    public static void addition(Scanner sc) {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.println("Result = " + (a + b));
    }

    public static void subtraction(Scanner sc) {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.println("Result = " + (a - b));
    }

    public static void multiplication(Scanner sc) {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.println("Result = " + (a * b));
    }

    public static void division(Scanner sc) {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
        } else {
            System.out.println("Result = " + (a / b));
        }
    }

    // Scientific Calculations
    public static void squareRoot(Scanner sc) {
        System.out.print("Enter number: ");
        double num = sc.nextDouble();
        System.out.println("Square Root = " + Math.sqrt(num));
    }

    public static void exponentiation(Scanner sc) {
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter exponent: ");
        double exp = sc.nextDouble();
        System.out.println("Result = " + Math.pow(base, exp));
    }

    // Unit Conversions
    public static void temperatureConversion(Scanner sc) {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter temperature value: ");
        double temp = sc.nextDouble();

        if (choice == 1) {
            double result = (temp * 9 / 5) + 32;
            System.out.println("Fahrenheit = " + result);
        } else if (choice == 2) {
            double result = (temp - 32) * 5 / 9;
            System.out.println("Celsius = " + result);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void currencyConversion(Scanner sc) {
        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        double rate = 87.95; 

        if (choice == 1) {
            System.out.println("INR = " + (amount * rate));
        } else if (choice == 2) {
            System.out.println("USD = " + (amount / rate));
        } else {
            System.out.println("Invalid choice!");
        }
    }
}

