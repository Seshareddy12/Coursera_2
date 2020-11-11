package week3;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public static void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("D:/Coursera2/src/week3/weblog-short_log");
        la.printAll();
    }
    public static void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("D:/Coursera2/src/week3/weblog-short_log");
        System.out.println("No of Unique IP Addresses are :"+la.countUniqueIPs());
    }
    public static void testUniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("D:/Coursera2/src/week3/weblog-short_log");
        System.out.println("No of Unique IP visits on day "+la.uniqueIPVisitsOnDay("Sep 30").toString());
    }
    public static void testcountUniqueIPsInRange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("D:/Coursera2/src/week3/short-test_log");
        System.out.println("No of Unique IPs in range "+la.countUniqueIPsInRange(300,399));
    }
    public static void testprintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("D:/Coursera2/src/week3/short-test_log");
        System.out.println("Logs with status code more than 300 ");
        la.printAllHigherThanNum(300);
    }
    public static void testAllRemaining(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("D:/Coursera2/src/week3/weblog3-short_log");
        HashMap<String,Integer> map = la.countVisitsPerIP();
        System.out.println("Visits per IP " + map);
        System.out.println("Most visits by IP "+la.mostNumberVisitsByIP(map));
        System.out.println("IPs with most visits "+la.iPsMostVisits(map).toString());
        HashMap<String,ArrayList<String>> dMap = la.iPsForDays();
        System.out.println("IPs matched to days "+dMap);
        System.out.println("Day with most IP visits "+la.dayWithMostIPVisits(dMap));
        System.out.println("IPs with most visits on Day Sep 30 "+la.iPsWithMostVisitsOnDay(dMap,"Sep 30").toString());


    }
}
