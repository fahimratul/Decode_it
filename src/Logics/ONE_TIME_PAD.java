package Logics;
import java.security.SecureRandom;
import java.util.Scanner;

public class ONE_TIME_PAD {

        public static String generateKey(int length) {
            SecureRandom random = new SecureRandom();
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < length; i++) {
                key.append((char) (random.nextInt(93)+33)); // Random byte converted to char
            }
            return key.toString();
        }
         
        public static String xorCipher(String text, String key) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                result.append((char) (text.charAt(i) ^ key.charAt(i))); // XOR each character
            }
            return result.toString();
        }

    }

