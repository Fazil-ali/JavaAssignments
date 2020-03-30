/*
link :https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/DvNzQ/programming-exercise-implementing-the-caesar-cipher

 */

public class WordPlay {
    boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'A'
                || ch == 'e' || ch == 'E'
                || ch == 'i' || ch == 'I'
                || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U')

            return true;

        return false;
   }
    String replaceVowels(String phrase, char ch){
        StringBuilder replacevowel=new StringBuilder(phrase);
        for(int index=0;index<phrase.length();index++){
            if(isVowel(phrase.charAt(index))){
                replacevowel.setCharAt(index,ch);
            }
        }
        return replacevowel.toString();
    }
    String emphasize(String phrase, char ch) {
        StringBuilder emphasizedphrase = new StringBuilder(phrase);
        for (int index = 0; index < phrase.length(); index++) {

            if (emphasizedphrase.charAt(index) == ch && ((index % 2) != 0)) {


                emphasizedphrase.setCharAt(index, '+');
            }
            else if(emphasizedphrase.charAt(index)==ch)
                emphasizedphrase.setCharAt(index, '*');
        }
        return emphasizedphrase.toString();
    }
    public static void main(String[] args) {
        WordPlay wp=new WordPlay();
        System.out.println(wp.replaceVowels("Hello World", '*'));
        System.out.println(wp.emphasize("dna ctgaaactga", 'a'));
    }
}


