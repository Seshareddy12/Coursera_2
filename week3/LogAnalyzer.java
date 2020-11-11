
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package week3;

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<>();

     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for(String s: fr.lines())
         {
             records.add(WebLogParser.parseEntry(s));

         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public int countUniqueIPs(){
         ArrayList<String> unique = new ArrayList<>();
         for(LogEntry record:records)
         {
             String ip = record.getIpAddress();
             if(unique.indexOf(ip)==-1)
             {
                 unique.add(ip);
             }
         }
         //System.out.println(records.size());
         //System.out.println(records.get(1).getAccessTime());
         return unique.size();

     }
     public void printAllHigherThanNum(int num){
         for(LogEntry record:records){
             if(record.getStatusCode()>num){
                 System.out.println(record);
             }
         }
     }

     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> al = new ArrayList<>();
         for(LogEntry record:records){
             String day = record.getAccessTime().toString();
             if(day.indexOf(someday)!=-1){
                 if (al.indexOf(record.getIpAddress() )== -1) {

                     al.add(record.getIpAddress());
                 }
             }
         }
         return al;
     }
    public int countUniqueIPsInRange(int low,int high){
        ArrayList<String> al = new ArrayList<>();
        for(LogEntry record:records){
            int s = record.getStatusCode();
            if(s>=low && s<=high){
                if (al.indexOf(record.getIpAddress() )== -1) {

                    al.add(record.getIpAddress());
                }
            }
        }
        return al.size();
    }
    public HashMap<String ,Integer> countVisitsPerIP(){
         HashMap<String,Integer> map = new HashMap<>();
         for(LogEntry record:records){
             String ip = record.getIpAddress();
             if(map.get(ip)==null){
                 map.put(ip,1);
             }
             else
             {
                 map.put(ip,map.get(ip)+1);
             }
         }
         return map;
    }

    public int mostNumberVisitsByIP(HashMap<String,Integer> map){
         int max=0;
         for(String key:map.keySet()){
             if(max<map.get(key)){
                 max=map.get(key);
             }
         }
         return max;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map){
         ArrayList<String> al = new ArrayList<>();
         int max = mostNumberVisitsByIP(map);
        for(String key:map.keySet()){
            if(map.get(key)==max){
                al.add(key);
            }
        }
        return al;
    }

    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>> map= new HashMap<>();
        for(LogEntry record:records){

            String day = record.getAccessTime().toString().substring(4,10);
            if(map.get(day)==null)
            {
                ArrayList<String> al = new ArrayList<>();
                al.add(record.getIpAddress());
                map.put(day,al);
            }
            else
            {
                map.get(day).add(record.getIpAddress());
            }

        }
        return map;
    }

    public String dayWithMostIPVisits( HashMap<String,ArrayList<String>> map) {
         String day="";int max=0;
         for(String d:map.keySet())
         {
             int size = map.get(d).size();
             if(max<size){
                 max=size;
                 day=d;
             }

         }
         return day;
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> map,String day){
        HashMap<String,Integer> ipmap= new HashMap<>();

        ArrayList<String> al = map.get(day);
        for(int i=0;i<al.size();i++)
        {
            String ip=al.get(i);
            if(ipmap.get(ip)==null){
                ipmap.put(ip,1);
            }
            else
            {
                ipmap.put(ip,ipmap.get(ip)+1);
            }
        }
        return iPsMostVisits(ipmap);
    }
}
