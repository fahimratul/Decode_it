package Logics;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class BlowfishExample {
    public static void main(String[] args) throws Exception {
        // Generate a Blowfish key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(448); // Key size (32 to 448 bits allowed)
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println(secretKey.getEncoded());
        // Generate a random IV (Initialization Vector)
        byte[] ivBytes = new byte[8];
        SecureRandom random = new SecureRandom();
        random.nextBytes(ivBytes);
        System.out.println(ivBytes);// Blowfish block size is 8 bytes

        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        System.out.println(ivSpec);
        // Plain text message
        String plainText = "Hello, Blowfish Encryption!";

        // Encrypt the text
        String encryptedText = encrypt(plainText, secretKey, ivSpec);
        System.out.println("Encrypted: " + encryptedText);

        // Decrypt the text
        String decryptedText = decrypt(encryptedText, secretKey, ivSpec);
        System.out.println("Decrypted: " + decryptedText);
    }

    public static String encrypt(String data, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }
}
