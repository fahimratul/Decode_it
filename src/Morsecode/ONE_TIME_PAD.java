package Morsecode;
import java.security.SecureRandom;
import java.util.Scanner;

public class ONE_TIME_PAD {



        // Generate a random key of the same length as the message
        public static String generateKey(int length) {
            SecureRandom random = new SecureRandom();
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < length; i++) {
                key.append((char) (random.nextInt(256))); // Random byte converted to char
            }
            return key.toString();
        }

        // Encrypt or Decrypt (XOR operation)
        public static String xorCipher(String text, String key) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                result.append((char) (text.charAt(i) ^ key.charAt(i))); // XOR each character
            }
            return result.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input plaintext
            System.out.print("Enter message to encrypt: ");
            String message = scanner.nextLine();

            // Generate a key
            String key = generateKey(message.length());
            System.out.println("Generated Key: " + key); // Key must be kept secret!

            // Encrypt the message
            String encryptedText = xorCipher(message, key);
            System.out.println("Encrypted Text: " + encryptedText);

            // Decrypt the message
            String decryptedText = xorCipher(encryptedText, key);
            System.out.println("Decrypted Text: " + decryptedText);

            scanner.close();
        }
    }

