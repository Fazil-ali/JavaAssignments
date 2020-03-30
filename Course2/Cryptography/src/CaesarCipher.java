/*
 link : https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/DvNzQ/programming-exercise-implementing-the-caesar-cipher
 */

import edu.duke.FileResource;

public class CaesarCipher {
    String encrypt(String input, int key){
        StringBuilder encrypt=new StringBuilder(input);
        String upperCaseAlphabtes="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseAlphabet="abcdefghijklmnopqrstuvwxyz";
        String shiftedLowerCaseAlphabets=lowerCaseAlphabet.substring(key)+lowerCaseAlphabet.substring(0,key);
        String shiftetdUpperAplhabets=upperCaseAlphabtes.substring(key)+upperCaseAlphabtes.substring(0,key);
        for(int index=0;index<encrypt.length();index++){
             char curChar=encrypt.charAt(index);
            int indexOfChar;
             if(curChar>='a' && curChar<='z'){
                 indexOfChar=lowerCaseAlphabet.indexOf(curChar);
                     if(indexOfChar!=-1){
                         char newChar=shiftedLowerCaseAlphabets.charAt(indexOfChar);
                         encrypt.setCharAt(index,newChar);
                    }
             }
             else if(curChar>='A' && curChar<='Z'){
                 indexOfChar=upperCaseAlphabtes.indexOf(curChar);
                 if(indexOfChar!=-1){
                     char newChar=shiftetdUpperAplhabets.charAt(indexOfChar);
                     encrypt.setCharAt(index,newChar);
                 }

             }

             }
        return encrypt.toString();
    }
    String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypt=new StringBuilder(input);
        for(int index=0; index<encrypt.length();index++){

            char currChar;
            if((index%2)==0){
                currChar = input.charAt(index);
                String encrypted=encrypt(Character.toString(currChar),key1);
                encrypt.setCharAt(index,encrypted.charAt(0));
            }
            else {
                currChar = input.charAt(index);
                String encrypted=encrypt(Character.toString(currChar),key2);
                encrypt.setCharAt(index,encrypted.charAt(0));
            }

        }
        return encrypt.toString();
    }
    void testCaesar(){
        FileResource fileResource=new FileResource();
        String message = fileResource.asString();
        String encrypted = encrypt(message, 23);
        System.out.println("key is " + 23 + "\n" + encrypted);
    }

    public static void main(String[] args) {

        CaesarCipher caesarCipher=new CaesarCipher();
        System.out.println(caesarCipher.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        caesarCipher.testCaesar();
        System.out.println(caesarCipher.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
    }


}
