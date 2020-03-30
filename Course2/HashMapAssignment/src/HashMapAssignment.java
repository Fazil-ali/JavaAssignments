/*
 link :https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/RnGtN/programming-exercise-improving-gladlibs

 */


import edu.duke.FileResource;
import java.util.HashMap;

public class HashMapAssignment {

    private HashMap<String,Integer> map;
    public HashMapAssignment(){
        map =new HashMap<>();
    }
    void buildCodonMap(int start,String dna){
        int initial=start;
        for(int index=start;index<dna.length()-3;index+=3){
            String codon=dna.substring(initial,initial+3);
            initial=dna.indexOf(codon)+3;
            if(map.keySet().contains(codon)){
                 map.put(codon,map.get(codon)+1);
            }
          else
              map.put(codon,1);

        }

    }

    String getMostCommonCodon(){
        int codonCount=0;
        String codon="";
        for(String key : map.keySet() ){
            if(map.get(key)>codonCount){
                codonCount=map.get(key);
                codon=key;
            }
        }
        return codon;
    }
    void printCodonCounts(int start, int end){
        System.out.println("codons whose count is between "+ start+" and "+ end);
        for(String key : map.keySet()){
            if(map.get(key)>=start && map.get(key)<=end){
                System.out.println(key +" "+map.get(key));
            }
        }
    }
    void printCodonCount(){
        for(String key : map.keySet()){
                System.out.println(key +" "+map.get(key));
            }
    }

    void tester(){
        FileResource fileResource=new FileResource();
        String caseChangeDna=fileResource.asString().toUpperCase();
//        buildCodonMap(0,caseChangeDna);
//        System.out.println("Most common codon"+getMostCommonCodon());
//        printCodonCount();
//        printCodonCounts(1,5);
//        buildCodonMap(1,caseChangeDna);
//        System.out.println("Most common codon "+getMostCommonCodon());
//        printCodonCount();
//      printCodonCounts(1,5);
        buildCodonMap(2,caseChangeDna);
        System.out.println("Most common codon "+getMostCommonCodon());
        printCodonCount();
        printCodonCounts(1,5);
    }

    public static void main(String[] args) {
        HashMapAssignment hashMapAssignment=new HashMapAssignment();
        hashMapAssignment.tester();
    }
}
