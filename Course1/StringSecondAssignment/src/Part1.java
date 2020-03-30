/*
 link : https://www.coursera.org/learn/java-programming/supplement/FzhKr/programming-exercise-finding-many-genes
 */
public class Part1 {

    int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3 );
        while (currIndex != -1) {
            if (((currIndex - startIndex) % 3) == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }

        }
        return dna.length();
    }

    public void testFindStopCodon() {
        String dna = "ATTTGTATGTGTGTTAATAA";
        int startIndex = dna.indexOf("ATG");
        int stopCodonindex = findStopCodon(dna, startIndex, "TAA");
        if ((startIndex == -1) || (stopCodonindex == dna.length())) {
            System.out.println("No gene in "+ dna);

        } else {
            System.out.println(dna.substring(startIndex, stopCodonindex+3));
        }
    }

    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        int minIndex=0;
        if(startIndex==-1)
            return " ";
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna, startIndex,"ATG");
        if(taaIndex == -1) taaIndex = dna.length();
        if(tagIndex == -1) tagIndex = dna.length();
        if(tgaIndex == -1) tgaIndex = dna.length();

        minIndex = Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
        if(minIndex < dna.length()) return dna.substring(startIndex,minIndex + 3);
        else return "";
    }

    public void printAllGenes(String dna){
        int startIndex = dna.indexOf("ATG");
        while(startIndex != -1){
            String gene = findGene(dna.substring(startIndex));
            System.out.println(gene);
            startIndex = dna.indexOf("ATG",startIndex + gene.length());
        }
    }

    public void testFindGene(){

        String DNA1="AATAGGAA";
        String DNA2="AATAGGAAATGAGGTTTAGTAA";
        String DNA3="ATATGGATATTAGGGATAAAAATGA";
        String DNA4="ATATGGATATTTTAGGGATATAAAATGAA";
        System.out.println(findGene(DNA1));
        System.out.println(findGene(DNA2));
        System.out.println(findGene(DNA3));
        System.out.println(findGene(DNA4));

    }

    public static void main(String[] args) {
        Part1 part1=new Part1();
        part1.testFindStopCodon();
        System.out.println(part1.findGene("ATTTGTATGTGTGTTAATAA"));
        part1.testFindGene();
    }
}
