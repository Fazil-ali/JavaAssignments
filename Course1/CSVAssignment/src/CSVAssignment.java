/*
link : https://www.coursera.org/learn/java-programming/supplement/Qu17T/programming-exercise-parsing-export-data
 */

import org.apache.commons.csv.*;
import edu.duke.*;
public class CSVAssignment {
    void tester(){
        FileResource fr=new FileResource("/home/fazil/Downloads/exports/exportdata.csv");
        CSVParser parser=fr.getCSVParser();
     // countryInfo(parser,"Nauru" );
        CSVParser parser1=fr.getCSVParser();
       // listExportersTwoProducts(parser1, "fish", "nuts");
        CSVParser parser2=fr.getCSVParser();
     //  System.out.println(numberOfExporters(parser2,"sugar"));
       CSVParser parser3=fr.getCSVParser();
        bigExporters(parser3, "$999,999,999,999");
    }
    void countryInfo(CSVParser parser, String country){
        String Exports;
        String Value;
        for(CSVRecord record : parser){
            Exports=record.get("Exports");
            Value=record.get("Value (dollars)");
            if(Exports.isEmpty()){
                System.out.println("NOT FOUND ");
            }
            else{
                System.out.println(country+ ":"+Exports+":"+Value);
            }

        }

    }
    void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2 ){
        for(CSVRecord record: parser){
            if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    int numberOfExporters(CSVParser parser , String exportItem){
        int count=0;
        for(CSVRecord record : parser){
            if(record.get("Exports").contains(exportItem)){
                count++;
            }
        }
         return count;
    }
    void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record : parser){
            if(amount.length()<record.get("Value (dollars)").length()){
                System.out.println(record.get("Country") + record.get("Value (dollars)"));
            }
        }
    }
    public static void main(String[] args) {
        CSVAssignment csv=new CSVAssignment();
        csv.tester();
    }
}
