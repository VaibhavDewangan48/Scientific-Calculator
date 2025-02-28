package com.vaibhav;

import java.util.Scanner;

public class Calculator {
    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x == 0) return 1;
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }

    public static double naturalLog(double x) {
        return Math.log(x);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Logarithm");
            System.out.println("4. Power Function");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            if (choice == 5) break;

            System.out.print("Enter number: ");
            double num1 = scanner.nextDouble();
            double result = 0;

            switch (choice) {
                case 1 -> result = squareRoot(num1);
                case 2 -> result = factorial((int) num1);
                case 3 -> result = naturalLog(num1);
                case 4 -> {
                    System.out.print("Enter exponent: ");
                    double num2 = scanner.nextDouble();
                    result = power(num1, num2);
                }
                default -> System.out.println("Invalid option!");
            }
            System.out.println("Result: " + result);
        }
        scanner.close();
    }
}
