public class StringAssignmentPart3 {
    Boolean twoOccurrences(String stringa, String stringb) {
        Boolean answer = false;


        int index = stringb.indexOf(stringa);
        if (index != -1) {
            int secondOcuurence = stringb.indexOf(stringa, index + stringa.length());
            if (secondOcuurence != -1) {
                answer = true;

            }
        }
        return answer;

    }
    void testing(){
       System.out.println("String1=by  String=A story by Abby Long , is string1 occured atleast twice   "+ twoOccurrences("by", "A story by Abby Long"));
        System.out.println("String1=a  String=banana , is string1 occured atleast twice    "+twoOccurrences("bob", "bobob"));
        System.out.println("String1=atg  String=ctgtatgta , is string1 occured atleast twice  "+twoOccurrences("atg", "ctgtatgta"));
        System.out.println("The part of the string after an in banana is "+ lastPart("an", "banana") );
        System.out.println("The part of the string after zoo in forest is "+ lastPart("zoo", "forest") );
    }
    String lastPart(String stringa, String stringb){
        int index=stringb.indexOf(stringa);
        if(index!=-1)
            return stringb.substring(index+stringa.length());
        else
            return stringb;
    }
    public static void main(String[] args) {
        StringAssignmentPart3 p3 = new StringAssignmentPart3();
       p3.testing();




    }

}
