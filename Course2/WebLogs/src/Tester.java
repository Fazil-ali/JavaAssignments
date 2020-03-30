import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        logAnalyzer.printAll();
        logAnalyzer.printAllHigherThanNum(400);
        System.out.println(logAnalyzer.uniqueIPVisitsOnDay("Sep 24").size());
        System.out.println(logAnalyzer.countUniqueIPs());
        System.out.println(logAnalyzer.countUniqueIPsInRange(200,299));
        System.out.println(logAnalyzer.countVisitsPerIP());
        System.out.println(logAnalyzer.mostNumberVisitsByIP(logAnalyzer.countVisitsPerIP()));
        System.out.println(logAnalyzer.iPsMostVisits(logAnalyzer.countVisitsPerIP()));
        System.out.println(logAnalyzer.iPsForDays());
        System.out.println(logAnalyzer.dayWithMostIPVisits(logAnalyzer.iPsForDays()));



    }
    public void testUniqueIP(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        System.out.println(logAnalyzer.countUniqueIPs());
    }

    public static void main(String[] args) {
        Tester tester=new Tester();
        tester.testLogAnalyzer();
        tester.testLogEntry();
        tester.testUniqueIP();

    }
}