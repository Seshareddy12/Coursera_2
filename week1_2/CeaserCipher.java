package week1_2;

import edu.duke.FileResource;

public class CeaserCipher {
    private String alphabet;
    private  String shiftedAlphabet;
    int mainKey;
    CeaserCipher(int key)
    {
        mainKey=key;


        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet=alphabet.substring(key) + alphabet.substring(0, key);
    }
    public String encrypt(String input) {

        StringBuffer sb = new StringBuffer(input);
        boolean isLc;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Character.isLetter(ch)) {
                isLc = Character.isLowerCase(ch);
                ch = Character.toUpperCase(ch);
                int idx = alphabet.indexOf(ch);
                if (isLc) {
                    sb.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(idx)));
                } else {
                    sb.setCharAt(i, shiftedAlphabet.charAt(idx));
                }
            }
        }
        return sb.toString();
    }

}

class testCeaserCipher{

    public void countFrequency(String encrypt,int count[])
    {
        for(int i=0;i<encrypt.length();i++)
        {
            if(Character.isLetter(encrypt.charAt(i)))
                count[Character.toLowerCase(encrypt.charAt(i))-97]++;
        }
    }
    public int maxFrequency(int count[])
    {
        int max=0,idx=0;
        for(int i=0;i<count.length;i++)
        {
            if(max<count[i])
            {
                max=count[i];
                idx=i;

            }
        }
        return idx;
    }
    public String breakCeaserCipher(String encrypt)
    {
        int count[] = new int[26];
        countFrequency(encrypt,count);
        int k = maxFrequency(count);
        //System.out.println(k);
        week1.CeaserCipher cc = new week1.CeaserCipher();
        int dkey = k-4;
        //System.out.println(dkey);
        if(k<4)
            dkey=26-(4-k);
        return cc.encrypt(encrypt,26-dkey);

    }

    public static void main(String args[]){
        CeaserCipher cc = new CeaserCipher(22);
        FileResource fr = new FileResource();
        System.out.println(cc.encrypt(fr.asString()));

    }
}
