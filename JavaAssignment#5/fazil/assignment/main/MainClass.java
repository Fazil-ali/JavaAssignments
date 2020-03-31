/* Create main class in package yourname.assignment.main,
create object of first class and call both the methods to print the values.
 Create object of second class using static method and
 then call the other method to print the String.
 */

package fazil.assignment.main;

import fazil.assignment.data.DefaultInitializationAssignment;

import fazil.assignment.singleton.*;

public class MainClass {

    public static void main(String[] args) {

        DefaultInitializationAssignment defaultInitializationAssignment =
                new DefaultInitializationAssignment();

        defaultInitializationAssignment.printFields();

        defaultInitializationAssignment.printLocalFields();

        Singleton singleton=
                Singleton.staticMethod();

        singleton.printStr();

    }
}
