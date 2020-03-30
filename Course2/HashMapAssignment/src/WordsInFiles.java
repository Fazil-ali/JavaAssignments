/*
 link :https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/RnGtN/programming-exercise-improving-gladlibs

 */


import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> counterMap;
    public WordsInFiles(){
        counterMap=new HashMap<>();

    }
private void addWordsFromFile(File file){
     FileResource fileResource = new FileResource(file);
     for(String word: fileResource.words()){
        if(!counterMap.containsKey(word)){
            ArrayList<String> fileList = new ArrayList<>();
            fileList.add(file.getName());
            counterMap.put(word, fileList);
        }
        else{
            counterMap.get(word).add(file.getName());
        }
     }
    }
    public void buildWordFileMap(){
        DirectoryResource directoryResource = new DirectoryResource();
        for(File file: directoryResource.selectedFiles()){
            addWordsFromFile(file);
        }
    }
    public int maxNumber(){
        int maxCount = 0;
        for(String key: counterMap.keySet()){
            if(counterMap.get(key).size() > maxCount){
                maxCount = counterMap.get(key).size();
            }
        }
        return maxCount;
    }
    public  ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> exactWords = new ArrayList<>();
        for(String key: counterMap.keySet()){
            if(counterMap.get(key).size() == number){
                exactWords.add(key);
            }
        }
        return exactWords;
    }
    public void printFilesIn(String word){
        if(!counterMap.containsKey(word)) return;
        for(String file: counterMap.get(word)){
            System.out.println(file);
        }
    }

    public void tester(){
        buildWordFileMap();
        System.out.println("The word occurring maximum number of times is " + maxNumber());
        ArrayList<String> exactWords = wordsInNumFiles(3);
        for(String word: exactWords){
            System.out.println(word);
        }
        printFilesIn("cats");
    }

    public static void main(String[] args) {
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.tester();
    }
}
