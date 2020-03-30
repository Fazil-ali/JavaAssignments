/*
 link : https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/AbpYj/programming-exercise-telling-a-random-story
 */


import edu.duke.FileResource;
import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords=new ArrayList<>();
        myFreqs=new ArrayList<>();
    }
    int findUnique(){
        myFreqs.clear();
        myWords.clear();
        int numberOfitems=0;
        FileResource fileResource=new FileResource();
        for(String words : fileResource.words()){
            words=words.toLowerCase();
            int index= myWords.indexOf(words);
            if(index==-1){
                myWords.add(words);
                myFreqs.add(1);
                numberOfitems++;
            }
            else
            {
                int currItems=myFreqs.get(index);
                myFreqs.set(index, currItems+1);
            }
        }
        return numberOfitems;
    }
    void tester(){
       int uniqueWords=findUnique();
        System.out.println("Number of unique words :"+uniqueWords);
        for(int index=0;index<myWords.size();index++){
            System.out.println(myFreqs.get(index)+"  "+myWords.get(index) );
        }
        int indexOfMax=findIndexOfMax();
        System.out.println("The word that occurs most often and its count are : "
                +myWords.get(indexOfMax)
                +myFreqs.get(indexOfMax));
    }
    int findIndexOfMax(){
        int largestIndex=0;
        int largestValue=myFreqs.get(0);
        for(int index=0;index<myFreqs.size();index++) {
            if (myFreqs.get(index) >= largestValue) {
                if (!(largestValue == myFreqs.get(index))) {
                    largestValue = myFreqs.get(index);
                    largestIndex = index;
                }

            }
        }
        return largestIndex;
    }

    public static void main(String[] args) {
        WordFrequencies wordFrequencies=new WordFrequencies();
        wordFrequencies.tester();
    }
}
