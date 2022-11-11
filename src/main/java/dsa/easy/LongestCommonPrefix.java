package dsa.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        int maxLen = 201;
        String str = "";
        for(String s : strs){
            if(s.length() < maxLen){
                maxLen = s.length();
                str = s;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <maxLen;i++){
            char ch = str.charAt(i);
            boolean found = false;
            for(String s : strs){
                if(ch == s.charAt(i)){
                    found = true;
                }else{
                    return sb.toString();
                }
            }
            if(found){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
    public String longestCommonPrefix1(String[] strs) {

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        StringBuilder sb = new StringBuilder("");

        int i = 0;
        int j = 0;
        int len =0;
        while( i < first.length() && j < last.length() &&
                first.charAt(i) == last.charAt(j)){
            i++;
            j++;
            len++;
        }
        return first.substring(0,len);


    }
}
