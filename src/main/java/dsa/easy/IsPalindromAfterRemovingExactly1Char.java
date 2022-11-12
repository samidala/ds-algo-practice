package dsa.easy;

public class IsPalindromAfterRemovingExactly1Char {
    public boolean validPalindrome(String s) {

        int i = 0 ;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return validPalindrome(s,i+1,j) || validPalindrome(s,i,j-1);
            }else{
                i++;
                j--;
            }

        }
        return true;

    }
    public boolean validPalindrome(String s,int i, int j) {
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;

            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}
