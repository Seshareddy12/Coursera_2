package week2_3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.lang.constant.DirectMethodHandleDesc;
import java.util.ArrayList;
import java.util.HashMap;


public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;
    WordsInFiles(){
        map = new HashMap<>();
    }
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for(String words:fr.words()){
            if(map.get(words)==null)
            {
                map.put(words,new ArrayList<>());
                map.get(words).add(f.getName());
            }
            else
            {
                if (map.get(words).indexOf(f.getName())==-1) {
                    map.get(words).add(f.getName());
                }
            }
        }
    }
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int max=0;
        for(String s:map.keySet())
        {
            if(max<map.get(s).size())
            {
                max=map.get(s).size();
            }
        }
        return max;
    }
    public ArrayList<String> wordsInNumFiles(int num){
        ArrayList<String> li = new ArrayList<>();
        for(String s:map.keySet()){
            if(map.get(s).size()==num)
                li.add(s);
        }
        return li;
    }
    public void printFilesIn(String word){
        System.out.println(word+" appears in files ");
        System.out.println(map.get(word).toString());
    }
    public void tester(){
        buildWordFileMap();
        int max = maxNumber();
        System.out.println("Max files a word occured is in : "+max);
        ArrayList<String> al = wordsInNumFiles(max);
        for(int i=0;i<al.size();i++)
        {
            String w=al.get(i);
            System.out.println(w+" is present in files "+map.get(w).toString());
        }

    }
}
