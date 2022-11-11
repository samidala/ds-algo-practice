package dsa.easy;

import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {

    public static void main(String[] args) {
        String s = "MCMXCIV";
    /*    int res = romanToInt(s);
        System.out.println( romanToInt("III"));
        System.out.println(romanToInt("MCMXCIV"));*/
        System.out.println(romanToInt("XXVII"));
        System.out.println(romanToInt("LVIII"));

    }
    public static int romanToInt(String s) {

        Map<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;

        for(int i = 0 ; i < s.length() -1 ;i++){
            char ch = s.charAt(i);
            char next = s.charAt(i+1);
            int curVal = map.get(ch);
            int nextVal = map.get(next);
            if(curVal < nextVal){
                sum = sum-curVal;
            }else{
                sum+=curVal;
            }

        }
        return  sum + map.get(s.charAt( s.length() -1));
    }
}
