package Morsecode;
import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;
import java.util.Scanner;




    public class RSA {

        private PrivateKey privateKey;
        private PublicKey publicKey;

        // Constructor to generate RSA key pair
        public RSA() throws Exception {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048); // RSA key size
            KeyPair keyPair = keyGen.generateKeyPair();
            this.privateKey = keyPair.getPrivate();
            this.publicKey = keyPair.getPublic();
        }

        // Encrypt with Public Key
        public String encrypt(String message) throws Exception {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }

        // Decrypt with Private Key
        public String decrypt(String encryptedMessage) throws Exception {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
            return new String(decryptedBytes);
        }

        public static void main(String[] args) {
            try {
                RSA rsaCipher = new RSA();
                Scanner scanner = new Scanner(System.in);

                // Ask user for input
                System.out.println("Enter a message to encrypt: ");
                String message = scanner.nextLine();

                // Encrypting user input
                String encryptedMessage = rsaCipher.encrypt(message);
                System.out.println("Encrypted Message: " + encryptedMessage);

                // Asking for decryption
                System.out.println("Enter the encrypted message to decrypt: ");
                String encryptedInput = scanner.nextLine();

                // Decrypting user input
                String decryptedMessage = rsaCipher.decrypt(encryptedInput);
                System.out.println("Decrypted Message: " + decryptedMessage);

                scanner.close();  // Close the scanner resource

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



