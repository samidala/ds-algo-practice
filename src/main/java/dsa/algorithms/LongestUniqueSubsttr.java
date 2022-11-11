package dsa.algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubsttr {

    public static void main(String[] args) {
        String str = "abcabcdebb";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(resStr);

    }
    static String resStr = "";
    public static int lengthOfLongestSubstring(String str){
        Map<Character, Integer> map = new HashMap<>(str.length());

        int start = 0;
        int maxLength = 0;
        for(int index = 0; index < str.length();index++){
            char ch = str.charAt(index);
            if(map.containsKey(ch)){
                start = Math.max(start,map.get(ch) + 1);
            }
            map.put(ch,index);
            if(index - start + 1 > maxLength){
                maxLength = index - start + 1;
                resStr = str.substring(start,index+1);
                System.out.println(" index "+index+" start "+start+ " str "+resStr);
            }
        }
        return maxLength;

    }
}
