package Logics;
import java.security.*;
import java.util.Base64;

public class ECCExample {
    public static void main(String[] args) throws Exception {
        // Generate an ECC key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256); // 256-bit ECC key
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Original message
        String message = "Hello, ECC Digital Signature!";

        // Sign the message
        String signature = signMessage(message, privateKey);
        System.out.println("Signature: " + signature);

        // Verify the signature
        boolean isValid = verifySignature(message, signature, publicKey);
        System.out.println("Signature Valid: " + isValid);
    }

    public static String signMessage(String message, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] signedBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signedBytes);
    }

    public static boolean verifySignature(String message, String signature, PublicKey publicKey) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withECDSA");
        verifier.initVerify(publicKey);
        verifier.update(message.getBytes());
        byte[] signatureBytes = Base64.getDecoder().decode(signature);
        return verifier.verify(signatureBytes);
    }
}

