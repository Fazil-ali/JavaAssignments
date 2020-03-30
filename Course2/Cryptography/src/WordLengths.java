/*
link : https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/727CD/programming-exercise-breaking-the-caesar-cipher
 */

import edu.duke.FileResource;

public class WordLengths {
    void countWordLengths(FileResource resource, int counts[]) {
        int length, flag = 0;
        for (String words : resource.words()) {

            length = words.length();
            if (Character.isLetter(words.charAt(0)) && Character.isLetter(words.charAt(words.length() - 1)) && !words.isEmpty()) {
                length-=2;

            } else if ((Character.isLetter(words.charAt(0)) || Character.isLetter(words.charAt(words.length() - 1)) )&&!words.isEmpty()) {
                length-=1;
            }

            counts[length]+=1;


        }

    }
    void testCountWordLengths(){
        FileResource fileResource=new FileResource();
        int counts[]=new int[31];
        countWordLengths(fileResource,counts);
        for(int index=0;index<counts.length;index++){
            System.out.println(counts[index]+ "words of length"+index);
        }
        System.out.println(indexOfMax(counts));
    }
    int indexOfMax(int values[]){
        int largestElement=0,largestElementIndex=0;
        for(int index=0;index<values.length;index++){
            if(values[index]>largestElement){
                largestElement=values[index];
                largestElementIndex=index;

            }
        }
        return  largestElementIndex;


    }

    public static void main(String[] args) {
        WordLengths wordLengths=new WordLengths();
        wordLengths.testCountWordLengths();
    }

}
