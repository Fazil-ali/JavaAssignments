import javax.annotation.processing.Processor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ping {

    String hostName;

    String ipAddress;

    int packetCount;

    List<Double> timeList;

    public Ping(String hostName,int count){

        this.hostName=hostName;

        this.packetCount=count;
    }
    public boolean isCountCorrect(){
        if(packetCount>2 && (packetCount%2)!=0)
            return true;
        return false;
    }

    public boolean isHostExists(String hostName) throws IOException {

        String command="ping -c 1 -w 5 "+hostName;

        System.out.println(command);

        Process process=Runtime.getRuntime().exec(command);

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String result1=inputStream.readLine();

        String result2=inputStream.readLine();

        //System.out.println(result1+" "+result2);
        if(result1==null || result2==null || result1.contains("service not known")){

            //ping: abc: Name or service not known
            return false;
        }

        else if(result2.contains("64")){

//            PING 172.217.26.238 (172.217.26.238) 56(84) bytes of data.
//            64 bytes from 172.217.26.238: icmp_seq=1 ttl=54 time=17.6 ms
            ipAddress=result1.substring(result1.indexOf("("),result1.indexOf(")")+1);

            return true;
        }
        else {
            return false;
        }
    }

    public void getTimeList() throws IOException{

        System.out.println("Host "+ hostName+ ":"
                +ipAddress+" exits");

        timeList=new ArrayList<Double>();
        Process process=Runtime.getRuntime()
                .exec("ping -c "+packetCount+" "+hostName);

        BufferedReader result=new BufferedReader(new
                InputStreamReader(process.getInputStream()));

        String pinginfo=result.readLine();

        for(int count=0;count<packetCount;count++){

            pinginfo=result.readLine();

            int indexOfTime=pinginfo.indexOf("time");

            int indexOfMs=pinginfo.indexOf("ms");

            String time=pinginfo.substring(indexOfTime+5,indexOfMs);

            timeList.add(Double.parseDouble(time));
        }

    }
    // gets the medium element index
    public int getMedianIndex(int packetCount){
        return (packetCount/2)+1;
    }
    public void getMedianTime(){

        //Sorting the timeList
        Collections.sort(timeList);

        System.out.println(timeList);
        int medianIndex=getMedianIndex(packetCount);
        System.out.println("Median Time is : "+timeList.get(medianIndex));

        //Middle element gives the median time
    }

}
