/*
 link: https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/xGjL5/programming-exercise-finding-unique-ip-addresses
  link2 : https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/ygOPU/programming-exercise-counting-website-visits
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
        private ArrayList<LogEntry> records;

        public LogAnalyzer() {
            records=new ArrayList<>();
        }

        public void readFile(String filename) {
            FileResource fileResource = new FileResource(filename);
            for (String lines : fileResource.lines()) {
                LogEntry logEntry = WebLogParser.parseEntry(lines);
                records.add(logEntry);


            }
        }

        public void printAll(){
            for (LogEntry le : records) {
                System.out.println(le);
            }
        }
        public int countUniqueIPs(){
            ArrayList<String> uniqueIPs=new ArrayList<>();
            for(LogEntry logEntry: records){
                String ipAddr= logEntry.getIpAddress();
                if(!uniqueIPs.contains(ipAddr)){
                    uniqueIPs.add(ipAddr);
                }
            }
            return uniqueIPs.size();
        }
        void printAllHigherThanNum(int num){
            for(LogEntry logEntry: records){
                int status=logEntry.getStatusCode();
                if(status>num){
                    System.out.println(logEntry);
                }
            }

        }
        public ArrayList<LogEntry> uniqueIPVisitsOnDay(String someday){
            ArrayList<LogEntry> items=new ArrayList<>();
            for(LogEntry logEntry: records){
                String date=logEntry.getAccessTime().toString();
                if(date.substring(4,10).equals(someday)){
                    items.add(logEntry);
                }
            }
            return items;

        }

        int countUniqueIPsInRange(int low,int high){
            ArrayList<String> logEntries=new ArrayList<>();
            for (LogEntry logEntry: records){
                int statusCode=logEntry.getStatusCode();
                String ipAddr=logEntry.getIpAddress();
                if(!logEntries.contains(ipAddr) && (statusCode>=low && statusCode<=high))
                    logEntries.add(ipAddr);

            }

            return logEntries.size();
        }
        HashMap<String,Integer> countVisitsPerIP(){
            HashMap<String,Integer> map=new HashMap<>();
            for(LogEntry logEntry: records){
                String ipAddr=logEntry.getIpAddress();
                if(map.containsKey(ipAddr)){
                    map.put(ipAddr,map.get(ipAddr)+1);
                }
                else
                    map.put(ipAddr,1);

            }
            return map;
        }
        int mostNumberVisitsByIP(HashMap<String, Integer>  map){
            int count=0;
            for(LogEntry logEntry: records){
                String ipAddr=logEntry.getIpAddress();
                if(map.get(ipAddr)>count){
                    count++;
                }
            }
            return count;
        }
    ArrayList<String> iPsMostVisits(HashMap<String, Integer> map){
            ArrayList<String> ipAddresses=new ArrayList<>();
            int maximumVisits=mostNumberVisitsByIP(map);
            for (LogEntry logEntry: records){
                String ipAddr=logEntry.getIpAddress();
                if(map.get(ipAddr)==maximumVisits && !ipAddresses.contains(ipAddr)){
                    ipAddresses.add(ipAddr);
                }
            }

            return ipAddresses;
    }
    HashMap<String, ArrayList<String>> iPsForDays(){
            HashMap<String, ArrayList<String>> map=new HashMap<>();

            for(LogEntry logEntry: records){
                String date=logEntry.getAccessTime().toString().substring(4,10);
                String ipaddr=logEntry.getIpAddress();

                if(map.containsKey(date)){
                    ArrayList<String> ipAddress=map.get(date);
                    ipAddress.add(ipaddr);
                    map.put(date,ipAddress);
                }
                else { ArrayList<String> ipAddresses=new ArrayList<>();
                    ipAddresses.add(ipaddr);
                    map.put(date,ipAddresses);
                }
            }
            return map;


    }
    String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){

                map=iPsForDays();
                int count=0;
                String dayWithMostIPs="";
                for(String day:map.keySet()){
                    if(map.get(day).size() > count){
                        count=map.get(day).size();
                        dayWithMostIPs=day;

                    }


            }
                return dayWithMostIPs;
    }


}
