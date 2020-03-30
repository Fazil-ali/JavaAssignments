/*
 link : https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/od7mx/programming-exercise-known-language-and-key-length
 */

import java.util.*;

public class VigenereCipher {

    CaesarCipher[] ciphers;

    public VigenereCipher(int[] key) {
        ciphers = new CaesarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CaesarCipher(key[i]);
        }
    }

    public String encrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = index % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encryptLetter(c));
            index++;
        }
        return answer.toString();
    }

    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = index % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            index++;
        }
        return answer.toString();
    }

    public String toString() {
        return Arrays.toString(ciphers);
    }

}