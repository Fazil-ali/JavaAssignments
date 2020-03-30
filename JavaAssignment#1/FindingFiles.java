import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindingFiles {
    String regx;
    Pattern pattern;
    List<String> foundFiles;

    public FindingFiles(String regx){
        this.regx=regx;

        pattern=Pattern.compile(regx);

        foundFiles=new ArrayList<>();
    }

    // Checks whether regular expression matches the file name
    public boolean patternMatched(String regx, String filename){


        Matcher matcher=pattern.matcher(filename);

        return matcher.matches();
    }


    //Add files names that matched the pattern to the arraylist foundFiles
    public List<String> findFiles(File[] files){


        for(File file:files){

            if(file.isDirectory()){

                findFiles(file.listFiles());
            }

            else {

                if(patternMatched(regx,file.getName())){

                    System.out.println(file.getName());

                    foundFiles.add(file.getAbsolutePath());
                }
            }
        }
        return foundFiles;

    }

}
