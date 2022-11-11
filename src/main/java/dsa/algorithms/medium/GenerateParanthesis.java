package dsa.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesisBfs(5));
    }
    public static List<String> generateParenthesisBfs(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        int count = 0;
        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        System.out.println("(" + first + ")" + second);
                        count++;
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        System.out.println("exec count "+count);
        return lists.get(lists.size() - 1);
    }
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList();

        generateParenthesis(n,0,0,list,"");
        return list;

    }

    void generateParenthesis(int n,int open, int closed, List<String> list,String s){
        if(s.length() == 2*n){
            list.add(s);
            return;
        }
        if(open < n){
            generateParenthesis(n,open+1,closed,list,s+"(");
        }
        if(closed < open){
            generateParenthesis(n,open,closed+1,list,s+")");
        }


    }

}
