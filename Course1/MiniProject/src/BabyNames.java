/*
    link: https://www.coursera.org/learn/java-programming/home/week/4
 */




import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyNames {
    public void totalBirths(FileResource fr) {
        int totalBirth = 0;
        int totalBoysName = 0;
        int totalGirlsName = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirth += numBorn;
            if (record.get(1).equals("M")) {
                totalBoysName++;
            } else {
                totalGirlsName++;
            }
        }
        System.out.println("total births = " + totalBirth);
        System.out.println("total boys name is:  " + totalBoysName);
        System.out.println("total girls name is " + totalGirlsName);
    }

    int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource();
        long rank = -1;
        for (CSVRecord record : fr.getCSVParser(false)) {
            String thisName = record.get(0);
            String thisGender = record.get(1);
            if (thisName.equals(name) && thisGender.equals(gender)) {
                rank=record.getRecordNumber();
            }

        }
        return (int)rank;
    }

    int getRank(int year, String name, String gender, FileResource fr) {
        long rank = -1;
        for (CSVRecord record : fr.getCSVParser(false)) {
            String thisName = record.get(0);
            String thisGender = record.get(1);
            if (thisName.equals(name) && thisGender.equals(gender)) {
                rank=record.getRecordNumber();
            }

        }

        return (int)rank;
    }

    String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource("/home/fazil/Downloads/us_babynames_small/testing/yob"+year+".csv");
        String name = "NO NAME";
        for (CSVRecord record : fr.getCSVParser(false)) {
            int thisRank = getRank(year, record.get(0), gender, fr);
            if (thisRank > 0) {
                if (thisRank == rank)
                    name = record.get(0);
            }


        }
        return name;
    }

    void whatIsNameInYear(String name, int year, String gender, int newYear) {
       // DirectoryResource dr=new DirectoryResource();
        String newName="";
//        for(File file: dr.selectedFiles()) {
            FileResource fileResource=new FileResource("/home/fazil/Downloads/us_babynames_small/testing/yob"+year+".csv");
            int rank = getRank(year, name, gender,fileResource);
            if (rank == -1) {
                System.out.println("no such name exist!");
            }
             newName = getName(newYear, rank, gender);
        FileResource fr2 = new FileResource("/home/fazil/Downloads/us_babynames_small/testing/yob"+year+".csv");
//        String newName = null;
        for (CSVRecord record2 : fr2.getCSVParser(false)) {
            if(record2.get(1).equals(gender) && record2.getRecordNumber() == rank) {
                newName = record2.get(0);
            }
        }
        System.out.println(name + " born in " + year + " would be "
                + newName + " if she was born in " + newYear + ".");

    }

    int yearOfHighestRank(String name, String gender) {
        int highestRank = 0;
        int yearWithHighestRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            String filename = file.getName();
            System.out.println("the file we select is: " + filename);
            int year = Integer.parseInt(filename.substring(3, 7));
            FileResource fileResource = new FileResource(file);
            for (CSVRecord record : fileResource.getCSVParser(false)) {
                int rank = getRank(year, name, gender, fileResource);
                if (rank > highestRank) {
                    highestRank = rank;
                    yearWithHighestRank = year;
                }


            }
        }
        return yearWithHighestRank;
    }

    double getAverageRank(String name, String gender) {

        int numOfFiles = 0;
        long totalRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            for (CSVRecord record : fr.getCSVParser(false)) {
                if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                    totalRank = totalRank + record.getRecordNumber();
                    numOfFiles++;
                }
            }
        }
        //(totalRank/numOfFiles);
        return  totalRank/numOfFiles;

    }


    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int totalBirths = 0;
        int rank = getRank(year, name, gender);
        FileResource fr = new FileResource("/home/fazil/Downloads/us_babynames_small/testing/yob"+year+".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            long currentRank = record.getRecordNumber();
            if(record.get(1).equals(gender) && currentRank < rank ) {
                totalBirths = totalBirths += Integer.parseInt(record.get(2));
            }
        }
        return totalBirths;
    }

    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public static void main(String[] args) {
        FileResource fr=new FileResource();
        BabyNames babyNames=new BabyNames();
        babyNames.testTotalBirths();
        System.out.println(babyNames.getRank(2012,"Mason","M"));
        babyNames.whatIsNameInYear("Isabella",2012,"F",2014);
        System.out.println(babyNames.yearOfHighestRank("Mason", "M"));
        System.out.println(babyNames.getAverageRank("Mason","M"));
        System.out.println(babyNames.getTotalBirthsRankedHigher(2012,"Ethan","M"));

    }
}
