package dsa.algorithms.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombinations {

    public static void main(String[] args) {
        String s = "23";
        System.out.println(letterCombinations(s));
    }

    public static List<String> letterCombinations(String digits) {

        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));

            //String t = ans.peek();
            List<String> temp =  new ArrayList<>(ans);
            for(String each : temp)
                for(char s : mapping[x].toCharArray())
                    ans.add(each+s);

        }

        return ans.stream().filter(each -> each.length() == digits.length()).collect(Collectors.toList());
    }
    public List<String> letterCombinations1(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
