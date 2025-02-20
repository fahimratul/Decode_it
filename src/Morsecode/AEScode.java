

     package Morsecode;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

/**
 * AES-GCM encryption and decryption implementation.
 * Possible KEY_SIZE values are 128, 192, and 256.
 * Possible T_LEN values are 128, 120, 112, 104, and 96.
 */
public class AEScode {
    private SecretKey key;
    private final int KEY_SIZE = 128; // Key size in bits
    private final int T_LEN = 128;    // Tag length in bits
    private byte[] IV;                // Initialization Vector

    /**
     * Initializes the AES key using KeyGenerator.
     */
    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
    }

    /**
     * Initializes the key and IV from Base64-encoded strings.
     */
    public void initFromStrings(String secretKey, String IV) {
        key = new SecretKeySpec(decode(secretKey), "AES");
        this.IV = decode(IV);
    }

    /**
     * Encrypts a message using AES-GCM.
     *
     * @param message The plaintext message to encrypt.
     * @return The encrypted message as a Base64-encoded string.
     */
    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key, spec);
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        return encode(encryptedBytes);
    }

    /**
     * Decrypts an encrypted message using AES-GCM.
     *
     * @param encryptedMessage The encrypted message as a Base64-encoded string.
     * @return The decrypted plaintext message.
     */
    public String decrypt(String encryptedMessage) throws Exception {
        byte[] encryptedBytes = decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    /**
     * Encodes a byte array to a Base64 string.
     */
    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * Decodes a Base64 string to a byte array.
     */
    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    /**
     * Main method to test encryption and decryption.
     */
    public static void main(String[] args) {
        try {
            AEScode aes = new AEScode();
            // Initialize with a predefined key and IV (Base64-encoded)
            aes.initFromStrings("CHuO1Fjd8YgJqTyapibFBQ==", "e3IYYJC2hxe24/EO");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Your Message:");
            String input = scanner.nextLine();

            // Encrypt the message
            String encryptedMessage = aes.encrypt(input);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Decrypt the message
            String decryptedMessage = aes.decrypt(encryptedMessage);
            System.out.println("Decrypted Message: " + decryptedMessage);

            scanner.close();
        } catch (Exception d) {
            d.printStackTrace(); // Handle exceptions properly
        }
    }
}
