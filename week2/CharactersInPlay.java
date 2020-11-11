package week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {

        private ArrayList<String> myWords;
        private ArrayList<Integer> myFreqs;
        CharactersInPlay(){
            myWords = new ArrayList<>();
            myFreqs = new ArrayList<>();
        }

        public void update(String person){

            int num=0;
                int idx = myWords.indexOf(person);
                if(idx==-1)
                {
                    myWords.add(person);
                    myFreqs.add(1);
                    num++;
                }
                else
                {
                    int value = myFreqs.get(idx);
                    myFreqs.set(idx,value+1);
                }
        }
        public void findAllCharacters(){
            myFreqs.clear();
            myWords.clear();
            FileResource fr = new FileResource();
            for(String s:fr.lines())
            {
                int idx = s.indexOf('.');
                if(idx!=-1)
                update(s.substring(0,idx));
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
            findAllCharacters();
            int idx = findIndexOfMax();
            System.out.println("Main Character is "+myWords.get(idx)+" "+myFreqs.get(idx));
            characterWithNumParts(2,5);
        }
        public void characterWithNumParts(int num1,int num2){
            for(int i=0;i<myFreqs.size();i++)
            {
                if(myFreqs.get(i)>=num1 && myFreqs.get(i)<=num2) {
                    System.out.println(myWords.get(i)+" "+myFreqs.get(i));
                }
            }
        }
 }

