package dsa.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int len = s.length() - 1;
        int res = 0;
        while(len >= 0 && s.charAt(len) == ' '){
            len--;
        }
        while(len >= 0 && s.charAt(len) != ' '){
            len--;
            res++;
        }

        return res;

    }
}
