package Logics;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAExample {
    public static void main(String[] args) {
        String input = "Hello, Secure Hash Algorithm!";

        System.out.println("SHA-1:    " + hash(input, "SHA-1"));
        System.out.println("SHA-256:  " + hash(input, "SHA-256"));
        System.out.println("SHA-512:  " + hash(input, "SHA-512"));
    }

    public static String hash(String data, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashBytes = digest.digest(data.getBytes());
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing Algorithm Not Found", e);
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}

