package dsa.algorithms.hard;

import java.util.regex.Pattern;

public class RegexMatchingDp {
    public static void main(String[] args) {
        String s = "abcda";
        String p = ".*b.*a";
        Pattern pat = Pattern.compile(p);
        System.out.println(pat.matcher(s).matches());

         s = "mississippi";
         p = "mis*is*ip*.";
        s = "abcda";
         p = "a*b.*a";
        System.out.println(isMatch(s,p));

    }

    public static boolean isMatch(String s, String p) {
        int strLen = s.length();
        while(p.contains("**")){
            p = p.replaceAll("\\*\\*","*");
        }
        int patLen = p.length();
        boolean dp[][] = new boolean[strLen+1][patLen+1];
        dp[0][0] = true;
        for(int i = 2; i <= patLen;i++){
            if( p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i = 1 ; i <= strLen;i++){
            char ch = s.charAt(i-1);
            for(int j =1; j <= patLen; j++){
                char pCh = p.charAt(j-1);
                if(pCh == ch || pCh == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pCh == '*'){
                    char prevCh =  p.charAt(j-2) ;
                    dp[i][j] = dp[i][j-2] || ((ch ==  prevCh || prevCh == '.') && dp[i-1][j]);
                }
            }
        }




        return dp[strLen][patLen];
    }
    public static boolean isMatchAnother(String s, String p) {

        int strLen = s.length();
        int patLen = p.length();
        int strIndex = 0;
        int patIndex = 0;

        while(strIndex  < strLen && patIndex < patLen){
            char ch = s.charAt(strIndex);
            char pCh = p.charAt(patIndex);
            if(ch == pCh){
                strIndex++;
                patIndex++;
            }else if(pCh == '.'){
                strIndex++;
                patIndex++;
            }else if(pCh == '*'){
                char prevCharBfrStar = p.charAt(patIndex - 1);
                if(prevCharBfrStar == '.'){
                    char nextCharInPat = p.charAt(patIndex+1);
                    while (ch != nextCharInPat && strIndex < strLen) {
                        System.out.println(ch + ": " + prevCharBfrStar);
                        ch = s.charAt(strIndex++);
                    }
                }else {
                    while (ch == prevCharBfrStar && strIndex < strLen) {
                        System.out.println(ch + ": " + prevCharBfrStar);
                        ch = s.charAt(strIndex++);
                    }
                    strIndex--;
                }

                patIndex++;
            }else{
                return false;
            }
        }

        return patIndex == patLen;

    }
}
