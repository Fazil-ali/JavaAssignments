/*
link :https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/e5ZZK/programming-exercise-unknown-language-unknown-key-length

 */
import edu.duke.FileResource;

import java.util.HashSet;

public class Tester {
    private VigenereBreaker vigenereBreaker;

    public void testSliceString(){
        vigenereBreaker = new VigenereBreaker();
        System.out.println(vigenereBreaker.sliceString("abcdefghijklm", 0, 2));
        System.out.println(vigenereBreaker.sliceString("abcdefghijklm", 2, 5));
    }

    public void testTryKeyLength(){
        vigenereBreaker = new VigenereBreaker();
        FileResource fileResource = new FileResource("/home/fazil/Documents/Assignment/athens_keyflute.txt");
        String text = fileResource.asString();
        int[] keys = vigenereBreaker.tryKeyLength(text, 5, 'e');
        for(int key: keys){
            System.out.println(key);
        }
    }

    public void testBreakVigenere(){
        vigenereBreaker = new VigenereBreaker();
        vigenereBreaker.breakVigenere();
    }

    public void testMostCommonCharIn(){
        vigenereBreaker = new VigenereBreaker();
        HashSet<String> dictionary = vigenereBreaker.readDictionary(new FileResource("/home/fazil/Documents/Assignment/dictionaries/English"));
        char ch = vigenereBreaker.mostCommonCharIn(dictionary);
        System.out.println(ch);
    }

    public static void main(String[] args) {
        Tester Tester = new Tester();
        Tester.testTryKeyLength();
        Tester.testBreakVigenere();
    }
}