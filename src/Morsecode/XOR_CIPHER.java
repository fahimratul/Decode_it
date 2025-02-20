package Morsecode;
import java.util.Scanner;
public class XOR_CIPHER {




        // XOR Encryption and Decryption (Same function for both)
        public static String xorEncryptDecrypt(String input, char key) {
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                output.append((char) (input.charAt(i) ^ key));
            }

            return output.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Asking user for input
            System.out.print("Enter a message to encrypt: ");
            String message = scanner.nextLine();

            // Asking for a single-character key
            System.out.print("Enter a single-character key: ");
            char key = scanner.next().charAt(0);

            // Encrypt the message
            String encryptedMessage = xorEncryptDecrypt(message, key);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Decrypt the message (XOR works both ways)
            String decryptedMessage = xorEncryptDecrypt(encryptedMessage, key);
            System.out.println("Decrypted Message: " + decryptedMessage);

            scanner.close();
        }
    }

