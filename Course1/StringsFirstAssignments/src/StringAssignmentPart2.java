public class StringAssignmentPart2 {
    private String findSimpleGene(String dna,int startCodon,int stopCodon ){
        int difference= stopCodon-startCodon;
        String answer="";
        if(startCodon == -1 || stopCodon==-1){
            answer=" ";
        }
        else if((difference%3)==0){
            answer= dna.substring(startCodon,stopCodon);
        }

        return answer;
    }
    private void testSimpleGene(){
        String test[]=new String[6];
        test[0]="ATATATAGAGAGATTAAATAA";
        test[1]="AAATTTTGGGATGAATATATATAGGAAGAGAG";
        test[2]="ATATATATGTGTGTGTGTTGTGTGTGTATATTATA";
        test[3]="atggtatagaggaattaa";
        test[4]="ATGGTATAGAGGAATTAA";
        test[5]="ATGGTATAGGAGGAATTAA";

        for(int i=0;i<6;i++){
            int startPosition;
            int stopPosition;
            System.out.println("DNA is : "+test[i]);
            String gene;
            if(Character.isUpperCase(test[i].charAt(i))){
                startPosition=test[i].indexOf("ATG");
                stopPosition=test[i].indexOf("TAA",startPosition);
                gene=findSimpleGene(test[i],startPosition,stopPosition).toUpperCase();
            }
            else {
                startPosition = test[i].indexOf("atg");
                stopPosition = test[i].indexOf("taa", startPosition);
                gene = findSimpleGene(test[i], startPosition, stopPosition).toLowerCase();
            }
            System.out.println("Gene is : "+gene);

        }

    }
    public static void main(String[] args) {
        StringAssignmentPart2 p2=new StringAssignmentPart2();
        p2.testSimpleGene();
    }
}
