package Logics;


import java.util.Scanner;

public class ROT13Example {

    public static String rot13(String input) {
        StringBuilder output = new StringBuilder();

        // Iterate through each character in the input string
        for (char c : input.toCharArray()) {
            // Apply ROT13 for uppercase letters
            if (Character.isUpperCase(c)) {
                c = (char) ('A' + (c - 'A' + 13) % 26);
            }
            // Apply ROT13 for lowercase letters
            else if (Character.isLowerCase(c)) {
                c = (char) ('a' + (c - 'a' + 13) % 26);
            }
            // If it's not a letter, don't change it
            output.append(c);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Get the string to encode or decode from the user
        System.out.print("Enter a string to apply ROT13: ");
        String input = scanner.nextLine();

        // Apply ROT13 encoding/decoding
        String result = rot13(input);

        // Output the result
        System.out.println("ROT13 Result: " + result);

        scanner.close();
    }
}