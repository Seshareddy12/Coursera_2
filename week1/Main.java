package week1;
import edu.duke.FileResource;
class WordLengths{
    public void countWordLengths(FileResource fr,int counts[]){
        for(String s:fr.words())
        {
            int c=0;
            for(int i=0;i<s.length();i++)
            {
                if(Character.isLetter(s.charAt(i))){
                    c++;
                }
            }
            counts[c]++;
        }
    }
    public int indexOfMax(int values[]){
        int max=0,idx=0;
        for(int i=0;i<values.length;i++)
        {
            if(max<values[i])
            {
                max=values[i];
                idx=i;

            }
        }
        return idx;
    }
    public void testCountWordLengths(){
        FileResource fr = new FileResource();
        int counts[] = new int[31];
        countWordLengths(fr,counts);
        System.out.println(indexOfMax(counts));

    }
}
class WordPlay{
    public boolean isVowel(char ch){
        ch=Character.toLowerCase(ch);
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch =='u'){
            return true;
        }
        return false;
    }
    public String replaceVowels(String s,char ch){
        StringBuffer sb = new StringBuffer(s);
        for(int i=0;i<sb.length();i++)
        {
            if(isVowel(sb.charAt(i)))
            sb.setCharAt(i,ch);
        }
        return sb.toString();
    }
    public String emphasize(String phrase,char ch){
        StringBuffer sb = new StringBuffer(phrase);
        ch=Character.toLowerCase(ch);
        for(int i=0;i<phrase.length();i++)
        {
            if(Character.toLowerCase(sb.charAt(i))==ch){
                if(i%2!=0)
                    sb.setCharAt(i,'*');
                else
                    sb.setCharAt(i,'+');

            }
        }
        return sb.toString();
    }

}




public class Main {

    public static void main(String[] args) {
	    WordPlay wp = new WordPlay();
        System.out.println(wp.replaceVowels("HelloWorld",'*'));
        System.out.println(wp.emphasize("baaAaaissaa Anda", 'a'));
        CeaserCipher cp = new CeaserCipher();
        /*System.out.println(cp.encrypt("FIRST LEGION ATTACK EAST FLANK!",23));
        System.out.println(cp.encrypt("First Legion",23));
        System.out.println(cp.encrypt("First Legion", 17));
        System.out.println(cp.encryptTwoKeys("First Legion",23,17));
        System.out.println(cp.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
        */
        //WordLengths wl = new WordLengths();
        //wl.testCountWordLengths();
        //String se = cp.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",23);
        FileResource fr = new FileResource();
        String se = fr.asString();
        CeaserBreaker cb = new CeaserBreaker();
        se =cp.encryptTwoKeys(se,23,2);
        System.out.println(se);
        System.out.println(cb.decryptTwoKeys(se));

    }

}
