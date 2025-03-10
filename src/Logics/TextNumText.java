package Logics;

import java.util.HashMap;
import java.util.Map;

public class TextNumText {

    // Define the mapping of characters to numerical values
    private static final Map<Character, Integer> charToNumMap = new HashMap<>();
    private static final Map<Integer, Character> numToCharMap = new HashMap<>();

    // Initialize the mappings
    static {
        // Uppercase letters (A-Z)
        for (int i = 0; i < 26; i++) {
            charToNumMap.put((char) ('A' + i), 1 + i);
            numToCharMap.put(1 + i, (char) ('A' + i));
        }

        // Lowercase letters (a-z)
        for (int i = 0; i < 26; i++) {
            charToNumMap.put((char) ('a' + i), 27 + i);
            numToCharMap.put(27 + i, (char) ('a' + i));
        }

        // Space
        charToNumMap.put(' ', 53);
        numToCharMap.put(53, ' ');

        // Punctuation marks
        charToNumMap.put('.', 54);
        numToCharMap.put(54, '.');
        charToNumMap.put(',', 55);
        numToCharMap.put(55, ',');
        charToNumMap.put('!', 56);
        numToCharMap.put(56, '!');
        charToNumMap.put('?', 57);
        numToCharMap.put(57, '?');
    }
    // Encode a text into a single numerical value
    public static long encode(String text) {
        StringBuilder encodedValue = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (charToNumMap.containsKey(c)) {
                encodedValue.append(charToNumMap.get(c));
            } else {
                throw new IllegalArgumentException("Character not supported for encoding: " + c);
            }
        }
        return Long.parseLong(encodedValue.toString());
    }

    // Decode a single numerical value into text
    public static String decode(long encodedValue) {
        String encodedStr = Long.toString(encodedValue);
        StringBuilder decodedText = new StringBuilder();
        int i = 0;
        while (i < encodedStr.length()) {
            // Try to read 2 digits first (for numbers >= 10)
            if (i + 2 <= encodedStr.length()) {
                int num = Integer.parseInt(encodedStr.substring(i, i + 2));
                if (numToCharMap.containsKey(num)) {
                    decodedText.append(numToCharMap.get(num));
                    i += 2;
                    continue;
                }
            }
            // If 2 digits don't work, try 1 digit
            int num = Integer.parseInt(encodedStr.substring(i, i + 1));
            if (numToCharMap.containsKey(num)) {
                decodedText.append(numToCharMap.get(num));
                i += 1;
            } else {
                throw new IllegalArgumentException("Invalid encoded value: " + encodedStr);
            }
        }
        return decodedText.toString();
    }

    public static void main(String[] args) {
        String originalText = "Hello, World!";
        System.out.println("Original Text: " + originalText);

        // Encode the text into a single numerical value
        long encodedValue = encode(originalText);
        System.out.println("Encoded Value: " + encodedValue);

        // Decode the numerical value back into text
        String decodedText = decode(encodedValue);
        System.out.println("Decoded Text: " + decodedText);
   }
}


