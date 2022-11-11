package dsa.algorithms.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {


//    template
//    int findSubstring(string s){
//        vector<int> map(128,0);
//        int counter; // check whether the substring is valid
//        int begin=0, end=0; //two pointers, one point to tail and one  head
//        int d; //the length of substring
//
//        for() { /* initialize the hash map here */ }
//
//        while(end<s.size()){
//
//        if(map[s[end++]]-- ?){  /* modify counter here */ }
//
//        while(/* counter condition */){
//
//        /* update d here if finding minimum*/
//
//        //increase begin to make it invalid/valid again
//
//        if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//        }
//
//        /* update d here if finding maximum*/
//        }
//        return d;
//        }

    public String minWindow(String s, String t) {

        Map<Character,Integer> count = new HashMap<>(t.length());
        for(char c : t.toCharArray()){
            count.put(c, count.getOrDefault(c,0)+1);
        }
        int start = 0, minStart = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int lengthS = s.length();
        int counter = t.length();
        while(end < lengthS){
            char current = s.charAt(end);
            /*if(!count.containsKey(current)) {
                end++;
                continue;
            }*/
            int chCnt = count.getOrDefault(current,0);
            if( chCnt > 0){
                counter--;
            }
            count.put(current, chCnt-1);
            end++;
            while(counter == 0){
                if(end - start < minLen){
                    minLen = end - start;
                    minStart = start;
                }
                char charAtStartOfWindow = s.charAt(start);
                int charAtStartWindowCnt = count.getOrDefault(charAtStartOfWindow,-1) + 1;
                count.put(charAtStartOfWindow,charAtStartWindowCnt);
                if(charAtStartWindowCnt > 0)
                    counter++;
                start++;
            }
        }

        return minLen != Integer.MAX_VALUE  ? s.substring(minStart,minStart+minLen) : "";
    }
}
