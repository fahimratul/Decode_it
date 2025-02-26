package Morsecode;

import java.util.HashMap;

public class Morsetotext {
    private HashMap<String, Character> reverseMorseCodeMap;

    public Morsetotext() {
        reverseMorseCodeMap = new HashMap<>();

        // Uppercase letters
        reverseMorseCodeMap.put(".-", 'A');
        reverseMorseCodeMap.put("-...", 'B');
        reverseMorseCodeMap.put("-.-.", 'C');
        reverseMorseCodeMap.put("-..", 'D');
        reverseMorseCodeMap.put(".", 'E');
        reverseMorseCodeMap.put("..-.", 'F');
        reverseMorseCodeMap.put("--.", 'G');
        reverseMorseCodeMap.put("....", 'H');
        reverseMorseCodeMap.put("..", 'I');
        reverseMorseCodeMap.put(".---", 'J');
        reverseMorseCodeMap.put("-.-", 'K');
        reverseMorseCodeMap.put(".-..", 'L');
        reverseMorseCodeMap.put("--", 'M');
        reverseMorseCodeMap.put("-.", 'N');
        reverseMorseCodeMap.put("---", 'O');
        reverseMorseCodeMap.put(".--.", 'P');
        reverseMorseCodeMap.put("--.-", 'Q');
        reverseMorseCodeMap.put(".-.", 'R');
        reverseMorseCodeMap.put("...", 'S');
        reverseMorseCodeMap.put("-", 'T');
        reverseMorseCodeMap.put("..-", 'U');
        reverseMorseCodeMap.put("...-", 'V');
        reverseMorseCodeMap.put(".--", 'W');
        reverseMorseCodeMap.put("-..-", 'X');
        reverseMorseCodeMap.put("-.--", 'Y');
        reverseMorseCodeMap.put("--..", 'Z');

        // Lowercase letters
        reverseMorseCodeMap.put(".-", 'a');
        reverseMorseCodeMap.put("-...", 'b');
        reverseMorseCodeMap.put("-.-.", 'c');
        reverseMorseCodeMap.put("-..", 'd');
        reverseMorseCodeMap.put(".", 'e');
        reverseMorseCodeMap.put("..-.", 'f');
        reverseMorseCodeMap.put("--.", 'g');
        reverseMorseCodeMap.put("....", 'h');
        reverseMorseCodeMap.put("..", 'i');
        reverseMorseCodeMap.put(".---", 'j');
        reverseMorseCodeMap.put("-.-", 'k');
        reverseMorseCodeMap.put(".-..", 'l');
        reverseMorseCodeMap.put("--", 'm');
        reverseMorseCodeMap.put("-.", 'n');
        reverseMorseCodeMap.put("---", 'o');
        reverseMorseCodeMap.put(".--.", 'p');
        reverseMorseCodeMap.put("--.-", 'q');
        reverseMorseCodeMap.put(".-.", 'r');
        reverseMorseCodeMap.put("...", 's');
        reverseMorseCodeMap.put("-", 't');
        reverseMorseCodeMap.put("..-", 'u');
        reverseMorseCodeMap.put("...-", 'v');
        reverseMorseCodeMap.put(".--", 'w');
        reverseMorseCodeMap.put("-..-", 'x');
        reverseMorseCodeMap.put("-.--", 'y');
        reverseMorseCodeMap.put("--..", 'z');

        // Numbers
        reverseMorseCodeMap.put("-----", '0');
        reverseMorseCodeMap.put(".----", '1');
        reverseMorseCodeMap.put("..---", '2');
        reverseMorseCodeMap.put("...--", '3');
        reverseMorseCodeMap.put("....-", '4');
        reverseMorseCodeMap.put(".....", '5');
        reverseMorseCodeMap.put("-....", '6');
        reverseMorseCodeMap.put("--...", '7');
        reverseMorseCodeMap.put("---..", '8');
        reverseMorseCodeMap.put("----.", '9');

        // Special Characters
        reverseMorseCodeMap.put("/", ' ');  // Word separator
        reverseMorseCodeMap.put("--..--", ',');
        reverseMorseCodeMap.put(".-.-.-", '.');
        reverseMorseCodeMap.put("..--..", '?');
        reverseMorseCodeMap.put("-.-.-.", ';');
        reverseMorseCodeMap.put("---...", ':');
        reverseMorseCodeMap.put("-.--.", '(');
        reverseMorseCodeMap.put("-.--.-", ')');
        reverseMorseCodeMap.put(".-.-.", '+');
        reverseMorseCodeMap.put("-....-", '-');
        reverseMorseCodeMap.put("..--.-", '_');
        reverseMorseCodeMap.put(".-..-.", '"');
        reverseMorseCodeMap.put(".----.", '\'');
        reverseMorseCodeMap.put("-..-.", '/');
        reverseMorseCodeMap.put(".--.-.", '@');
        reverseMorseCodeMap.put("-...-", '=');
        reverseMorseCodeMap.put("-.-.--", '!');
    }

    public String decodeMorseCode(String morseCode) {
        StringBuilder decodedMessage = new StringBuilder();

        // Split the input Morse code by spaces
        String[] morseWords = morseCode.trim().split(" / "); // Words are separated by ' / ' (space before and after)
        for (String word : morseWords) {
            String[] letters = word.trim().split(" "); // Letters are separated by single spaces
            for (String letter : letters) {
                if (reverseMorseCodeMap.containsKey(letter)) {
                    decodedMessage.append(reverseMorseCodeMap.get(letter));
                }
            }
            decodedMessage.append(" "); // Add space after each word
        }

        return decodedMessage.toString().trim();
    }


}