package org.example;
import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error! Division by zero.");
        }
        return a / b;
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new ArithmeticException("Error! Square root of a negative number.");
        }
        return Math.sqrt(num);
    }

    public static double logarithm(double num) {
        if (num <= 0) {
            throw new ArithmeticException("Error! Logarithm of zero or negative number.");
        }
        return Math.log(num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Loop until the user chooses to quit
        do {
            System.out.println("\nScientific Calculator");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Logarithm");
            System.out.println("8. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            double num1, num2;

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case 2:
                    System.out.print("Enter two numbers: ");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + subtract(num1, num2));
                    break;
                case 3:
                    System.out.print("Enter two numbers: ");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + multiply(num1, num2));
                    break;
                case 4:
                    System.out.print("Enter two numbers: ");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + divide(num1, num2));
                    break;
                case 5:
                    System.out.print("Enter base and exponent: ");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + power(num1, num2));
                    break;
                case 6:
                    System.out.print("Enter number: ");
                    num1 = scanner.nextDouble();
                    System.out.println("Result: " + squareRoot(num1));
                    break;
                case 7:
                    System.out.print("Enter number: ");
                    num1 = scanner.nextDouble();
                    System.out.println("Result: " + logarithm(num1));
                    break;
                case 8:
                    System.out.println("Phir Milenge Kabhi....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 8);  // Loop continues until user chooses to quit

        scanner.close();
    }
}
