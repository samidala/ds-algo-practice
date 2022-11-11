package dsa.algorithms.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstringUsingSet(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if(s.length() <= 1) return s.length();
        if(s.length() == 2) return s.charAt(0) == s.charAt(1) ? 1 : 2;
        int left = 0 ;
        int right = 0;
        Map<Character,Integer> count = new HashMap<>(s.length());
        while(right < s.length()){
            if(count.containsKey(s.charAt(right))){
                left = Math.max(left,count.get(s.charAt(right)) + 1);
            }
            count.put(s.charAt(right),right);
            if(maxLen < right - left + 1){
                maxLen = right - left + 1;
            }
            right++;
        }
        return maxLen;
    }
    public static int lengthOfLongestSubstringUsingSet(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                maxLen = Math.max(maxLen,set.size());
                i++;
            }else{
                set.remove(s.charAt(j++));
            }
        }
        return maxLen;
    }
}
