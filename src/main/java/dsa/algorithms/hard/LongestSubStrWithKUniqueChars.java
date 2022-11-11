package dsa.algorithms.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithKUniqueChars {

    public int longestkSubstr(String s, int k) {
        // code here

        if(s.length()  < k) return -1;

        Map<Character,Integer> map = new HashMap();

        int start = 0, end =0, maxLen = -1, minStart =0;
        int count = 0;
        while(end < s.length()){
            char current = s.charAt(end);

            map.put(current,map.getOrDefault(current,0)+1);

            if(map.get(current) == 1){
                count++;
            }

            end++;
            while ( count > k ){
                char charAtStart = s.charAt(start);

                int cnt =  map.get(charAtStart);
                // System.out.println( charAtStart +" cnt "+cnt);
                if(cnt ==1) count--;
                cnt--;
                map.put(charAtStart,cnt);
                start++;
            }
            maxLen = Math.max(maxLen, end - start);

        }
        if(map.size() < k) return -1;
        //  System.out.println("maxLen "+maxLen);
        return maxLen;
    }
}
