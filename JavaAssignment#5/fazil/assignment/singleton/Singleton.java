/*Create another class in package yourname.assignment.singleton
containing a non static String member variable.
Add a static method that takes String as parameter and
initialize the member variable and then return object of that class.
Add a non static method to print the String.
 */

package fazil.assignment.singleton;

public class Singleton {

    String str="Default";
    private static Singleton instance=null;


    public static Singleton staticMethod(){

        // str="Assignment5";
        // Non static variable cannot be referenced from static methods.
        //Static methods belong to the class with only one instance created initially
        // Non static variables are initialize every time a new object is created.
        if(instance==null)
            instance=new Singleton();

        return instance;
    }

    public void printStr(){

        System.out.println(instance.str);
    }
}
