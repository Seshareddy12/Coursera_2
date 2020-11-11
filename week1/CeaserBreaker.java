package week1;

import week1.CeaserCipher;

public class CeaserBreaker {

    public String decrypt(String encrypt)
    {
        int count[] = new int[26];
        countFrequency(encrypt,count);
        int k = maxFrequency(count);
        //System.out.println(k);
        CeaserCipher cc = new CeaserCipher();
        int dkey = k-4;
        //System.out.println(dkey);
        if(k<4)
            dkey=26-(4-k);
        return cc.encrypt(encrypt,26-dkey);

    }
    public String decryptTwoKeys(String encrypt)
    {
        String p1="",p2="";
        for(int i=0;i<encrypt.length();i+=2)
            p1=p1+encrypt.charAt(i);
        for(int i=1;i<encrypt.length();i+=2)
            p2=p2+encrypt.charAt(i);

        p1 = decrypt(p1);
        p2 = decrypt(p2);
        //System.out.println(p1);
        StringBuffer sb = new StringBuffer();
        int j=0,k=0;
        for(int i=0;i<encrypt.length();i++)
        {
            if(i%2==0)
            {
                sb.append(p1.charAt(j));
                j++;
            }
            else
            {
                sb.append(p2.charAt(k));
                k++;
            }
        }
        return sb.toString();

    }
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
}
