/* Create a java program to search through the home directory and
look for files that match a regular expression.
The program should be able to take inputs repeatedly and
should print out the full absolute path of the matching files found.
 */


import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String pattern = "";
        String path=System.getProperty("user.home");
        while (!pattern.equals("quit")) {

            Scanner input = new Scanner(System.in);

            File file = new File(path);

            File[] files = file.listFiles();

            System.out.println("Enter the pattern to find file and type quit for quitting");

            pattern = input.next();

            FindingFiles findingFiles = new FindingFiles(pattern);

            for(String fileName: findingFiles.findFiles(files))

                System.out.println("Absolute paths: "+ fileName);


        }
    }
}




/*  Input:

    Enter the pattern to find file and type quit for quitting
    b.*

    Output:
    breif1.txt
    brief4.txt
    brief2.txt
    bried3.txt
    Absolute paths: /home/fazil/Documents/Java/breif1.txt
    Absolute paths: /home/fazil/Documents/Java/brief4.txt
    Absolute paths: /home/fazil/Documents/Java/brief2.txt
    Absolute paths: /home/fazil/Documents/Java/bried3.txt
    Enter the pattern to find file and type quit for quitting

    quit


 */

