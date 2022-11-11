package dsa.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class PatternMatching {

    public static void main(String[] args) {

        String str = "abcdxabcdxabcdabcdabcdabcdabcdabcdabcdabcdabcdxabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
        String pat = "abcdx";
        System.out.println(isFound(str,pat));

        str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

         pat = "aaaaaaaaaaaaba";
        System.out.println(isFound(str,pat));
        System.out.println(str.length() * pat.length());

    }
    static boolean isFound(String str, String pat){
        int len = pat.length();
        char first = pat.charAt(0);
        char last = pat.charAt(len -1);
        List<Integer> positions = new ArrayList<>();
        for(int i = 0 ; i < str.length(); i++){
            char each = str.charAt(i);
            if(each == first && i + len -1< str.length() && str.charAt(i+len-1) == last){
                positions.add(i);
            }
        }

        int count = 0;
        System.out.println("positions "+positions);
        for(int pos : positions){
            int j = pos;
            int i =0;
            for(; i < len && j < str.length();i++,j++){
                count++;
                if(str.charAt(j) != pat.charAt(i)){
                    break;
                }
            }
            if(i == len){
                System.out.println(str.substring(pos,i));
                return true;
            }
        }
        System.out.println("exec ount "+count);
        return false;

    }
}
