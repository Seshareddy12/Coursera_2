package week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    WordFrequencies(){
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }
    public void findUnique(){
        myFreqs.clear();
        myWords.clear();
        FileResource fr = new FileResource();
        int num=0;
        for(String s:fr.words())
        {
            int idx = myWords.indexOf(s);
            if(idx==-1)
            {
                myWords.add(s);
                myFreqs.add(1);
                num++;
            }
            else
            {
                int value = myFreqs.get(idx);
                myFreqs.set(idx,value+1);
            }
        }
    }
    public int findIndexOfMax(){
        int max = 0,idx=0;
        for(int i=0;i<myFreqs.size();i++)
        {
            if(max<myFreqs.get(i)) {
                max = myFreqs.get(i);
                idx=i;
            }
        }
        return idx;
    }
    public void tester(){
        findUnique();

        for(int i=0;i<myWords.size();i++){
            System.out.println(myWords.get(i)+" "+myFreqs.get(i));
        }
        int idx = findIndexOfMax();
        System.out.println("Largest occuring word :"+myWords.get(idx)+" : "+myFreqs.get(idx));
    }
    public static void main(String args[]){
        //WordFrequencies wf = new WordFrequencies();
        //wf.tester();
        CharactersInPlay cc = new CharactersInPlay();
        cc.tester();
    }
}
