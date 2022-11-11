package dsa.algorithms.hard;

public class WildcardMatchingDp {

    public boolean isMatch(String s, String p) {

        int strLen = s.length();

        while(p.contains("**")){
            //System.out.println("inside while");
            p = p.replaceAll("\\*\\*","*");
        }
        int patLen = p.length();

        boolean[][] dp = new boolean[strLen+1][patLen+1];

        dp[0][0] = true;
        // System.out.println("outside if patLen "+patLen);
        if(patLen >= 1 && p.charAt(0) == '*'){
            //    System.out.println("inside if ");
            dp[0][1] = true;
        }

        for(int i = 1; i <= strLen;i++){
            for(int j=1; j <= patLen;j++){
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = false;
                }

            }
        }



        return dp[strLen][patLen];
    }

    boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
