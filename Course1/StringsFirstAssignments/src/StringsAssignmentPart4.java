import edu.duke.URLResource;

public class StringsAssignmentPart4 {
    public void parser(String link) {
        URLResource url = new URLResource(link);
        String urlString= url.asString();
        String urlStringLowerCase=urlString.toLowerCase();
       // System.out.println();
        int index=urlStringLowerCase.indexOf("youtube.com");
        while(index!=-1){
            System.out.println(urlString.substring(urlString.lastIndexOf("/",index),urlString.indexOf("/",index)));
            index=urlStringLowerCase.indexOf("youtube",index+1);

        }

    }
    public static void main(String[] args) {
        StringsAssignmentPart4 p4=new StringsAssignmentPart4();
        p4.parser("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

    }

}