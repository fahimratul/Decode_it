package Logics;

import java.util.Base64;
import java.util.Scanner;

public class Base64Example {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Get the string to encode from the user
        System.out.print("Enter the string to encode: ");
        String stringToEncode = scanner.nextLine();

        // Get the string to decode from the user
        System.out.print("Enter the Base64 string to decode: ");
        String stringToDecode = scanner.nextLine();

        // Encode the stringToEncode
        String encodedString = Base64.getEncoder().encodeToString(stringToEncode.getBytes());

        // Decode the stringToDecode
        byte[] decodedBytes = Base64.getDecoder().decode(stringToDecode);
        String decodedString = new String(decodedBytes);

        // Output results
        System.out.println("Original String to Encode: " + stringToEncode);
        System.out.println("Encoded String: " + encodedString);
        System.out.println("String to Decode: " + stringToDecode);
        System.out.println("Decoded String: " + decodedString);

        // Close the scanner to avoid resource leak
        scanner.close();
}
}
