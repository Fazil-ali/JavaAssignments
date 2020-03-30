/*
 link : https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/AbpYj/programming-exercise-telling-a-random-story
 */

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> charactersCount;
    public CharactersInPlay(){
        characters=new ArrayList<>();
        charactersCount=new ArrayList<>();
    }
    void update(String person){
                int index=characters.indexOf(person);
                if(index==-1) {
                    characters.add(person);
                    charactersCount.add(1);
                }
                else{
                    int currCount=charactersCount.get(index);
                    charactersCount.set(index,currCount+1);
                }


    }
    void findAllCharacters(){
            FileResource fileResource=new FileResource();
            for(String lines:fileResource.lines()){
                     int index=lines.indexOf(".");
                     if(index!=-1) {
                         lines = lines.substring(0, index).trim();
                         update(lines);
                     }
            }

    }
    void tester(){
        findAllCharacters();
        for(int index=0;index<charactersCount.size();index++)
        System.out.println(characters.get(index)+" "+
                charactersCount.get(index));
       // charactersWithNumParts(10,15);
    }
    void charactersWithNumParts(int num1,int num2){
        for(int index=0;index<charactersCount.size();index++){
            int numberIndex=charactersCount.get(index);
            if(numberIndex>=num1 && numberIndex<=num2){
                System.out.println(characters.get(index));
            }
        }
    }

    public static void main(String[] args) {
        CharactersInPlay charactersInPlay=new CharactersInPlay();
        charactersInPlay.tester();;
    }

}