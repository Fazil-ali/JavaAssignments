/*
link : https://www.coursera.org/learn/java-programming/supplement/T8W0j/programming-exercise-finding-a-gene-and-web-links
 */



public class StringAssignmentPart1 {
    private String findSimpleGene(String dna){
        int startPosition=dna.indexOf("ATG");
        int stopPosition=dna.indexOf("TAA",startPosition);
        int difference= stopPosition-startPosition;
        String answer="";
        if(startPosition == -1 || stopPosition==-1){
            answer=" ";
        }
        else if((difference%3)==0){
            answer= dna.substring(startPosition,stopPosition);
        }

        return answer;
    }
   private void testSimpleGene(){
        String test[]=new String[5];
        test[0]="ATATATAGAGAGATTAAATAA";
        test[1]="AAATTTTGGGATGAATATATATAGGAAGAGAG";
        test[2]="ATATATATGTGTGTGTGTTGTGTGTGTATATTATA";
        test[3]="ATGGTATAGAGGAATTAA";
        test[4]="ATGGTATAGGAGGAATTAA";


        for(int i=0;i<5;i++){
            System.out.println("DNA is : "+test[i]);
            System.out.println("Gene is : "+findSimpleGene(test[i]));

        }

    }

    public static void main(String[] args) {
        StringAssignmentPart1 p=new StringAssignmentPart1();
        p.testSimpleGene();
    }


}
