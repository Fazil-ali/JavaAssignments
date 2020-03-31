/*Write a java function that will ping any host ( given as input )
and computes the median of the time taken to ping.
Use the system ping utility, do not use any deprecated methods.
*/


import java.io.IOException;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the hostname and packetCount");

        String hostName = input.nextLine();

        int packetCount = input.nextInt();

        Ping ping = new Ping(hostName, packetCount);

        if (ping.isCountCorrect()) {
            if (ping.isHostExists(hostName)) {

                ping.getTimeList();

                ping.getMedianTime();

            } else {

                System.out.println(" Invalid host ");
            }
        } else
            System.out.println("Sorry, Packetcount number should be positive and odd ");
    }
}


/* INPUT :
 Enter the hostname and packetCount
 facebook.com
 5

 OUTPUT:
 ping -c 1 -w 5 facebook.com
 Host facebook.com:(157.240.16.35) exits
 [20.2, 20.4, 20.5, 20.9, 21.7]
 Median Time is : 20.5

 */
