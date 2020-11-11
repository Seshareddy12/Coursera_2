package week2_3;

import edu.duke.FileResource;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String,Integer> map;
    CodonCount(){
        map = new HashMap<>();
    }
    public void buildCodonMap(int start,String dna){
        map.clear();
        for(int i=start;i<=dna.length()-3;i+=3)
        {
            String codon = dna.substring(i,i+3);
            if(map.get(codon)==null){
                map.put(codon,1);
            }
            else
            {
                map.put(codon,map.get(codon)+1);
            }
        }
    }
    public String getMostCommonCodon(){
        int max=0;
        String idx="";
        for(String s:map.keySet())
        {
            if(max<map.get(s)){
                max=map.get(s);
                idx=s;
            }
        }
        return idx;
    }
    public void printCodonCounts(int start,int end){
        for(String s:map.keySet())
        {
            if(map.get(s)>=start && map.get(s)<=end){
                System.out.println(s+" "+map.get(s));
            }
        }
    }
    public void tester(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        for(int i=0;i<3;i++)
        {
            buildCodonMap(i,dna);
            System.out.println("Reading Frame : "+i);
            System.out.println("Most Common Codon : "+getMostCommonCodon());
            printCodonCounts(2,3);
        }
    }
}
