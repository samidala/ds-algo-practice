package dsa.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWaysDp {

    public static void main(String[] args) {
        String s = "10";
        System.out.println(count(s));
        System.out.println("total exec cnt "+count);
        System.out.println(countDp(s));
    }
    static int count(String s){
        if(s.length() == 0){
            return 0;
        }
        return count(s,0);
    }
    static int count = 0;
    static Map<Integer,Integer> cnt = new HashMap<>();
    static int count(String s, int n){
        ++count;
        if(n == s.length()){
            return  1;
        }
        if(cnt.containsKey(n)){
            return cnt.get(n);
        }
        if(s.charAt(n) == '0'){
            return 0;
        }
        int res = count(s,n+1) ;
        if(n < s.length() -1 && (s.charAt(n) == '2' || s.charAt(n) == '1') && s.charAt(n+1) < '7'){
            System.out.println("came inside when str is "+s.substring(n,n+2));
            res+=count(s,n+2);
        }
        cnt.put(n,res);
        return res;
    }

    static int countDp(String s){
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--)
            if(s.charAt(i)!='0') {
                dp[i]=dp[i+1];
                if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7'))
                    dp[i]+=dp[i+2];
            }
        return dp[0];
    }
    public int numDecodings(String s) {
        int n = s.length();
        int oneCount = 0;
        int twoCount = 1;
        for (int i = 1; i <= n; ++i) {
            int count = 0;
            if (s.charAt(i - 1) != '0') {
                count += twoCount;
            }
            if (i > 1 && s.charAt(i - 2) != '0'
                    && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') <= 26) {
                count += oneCount;
            }
            oneCount = twoCount;
            twoCount = count;
        }
        return count;
    }
}
