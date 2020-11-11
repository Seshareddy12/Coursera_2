package week1;

public class CeaserCipher {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public String encrypt(String input, int key) {
            String enc = alphabet.substring(key) + alphabet.substring(0, key);
            StringBuffer sb = new StringBuffer(input);
            boolean isLc;
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (Character.isLetter(ch)) {
                    isLc = Character.isLowerCase(ch);
                    ch = Character.toUpperCase(ch);
                    int idx = alphabet.indexOf(ch);
                    if (isLc) {
                        sb.setCharAt(i, Character.toLowerCase(enc.charAt(idx)));
                    } else {
                        sb.setCharAt(i, enc.charAt(idx));
                    }
                }
            }
            return sb.toString();
        }

        public String encryptTwoKeys(String input, int key1, int key2) {
            String enc1 = alphabet.substring(key1) + alphabet.substring(0, key1);
            String enc2 = alphabet.substring(key2) + alphabet.substring(0, key2);
            StringBuffer sb = new StringBuffer(input);
            boolean isLc;
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                if (Character.isLetter(ch)) {
                    isLc = Character.isLowerCase(ch);
                    ch = Character.toUpperCase(ch);
                    int idx = alphabet.indexOf(ch);
                    if (i % 2 == 0) {
                        if (isLc) {
                            sb.setCharAt(i, Character.toLowerCase(enc1.charAt(idx)));
                        } else {
                            sb.setCharAt(i, enc1.charAt(idx));
                        }
                    } else {
                        if (isLc) {
                            sb.setCharAt(i, Character.toLowerCase(enc2.charAt(idx)));
                        } else {
                            sb.setCharAt(i, enc2.charAt(idx));
                        }
                    }
                }
            }
            return sb.toString();
        }
}
