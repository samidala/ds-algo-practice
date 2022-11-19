package dsa.algorithms.medium;

public class CountAndSay {

    public String countAndSay(int n) {
        if(n ==1 )return "1";
        StringBuilder sb = new StringBuilder("1");
        return countAndSay(n,sb).toString();

    }
    public StringBuilder countAndSay(int n,StringBuilder s) {
        if(n == 1) return s;
        int len = s.length();
        int i = 0 ;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while( i < len){
            int count = 0;
            j = i;
            while(i < len && s.charAt(i) == s.charAt(j)){
                i++;
                count++;
            }

            sb.append(count);
            sb.append(s.charAt(j));

        }
        return countAndSay(n-1,sb);
    }




    public String countAndSayv1(int n) {
        if(n < 1) return "-1";
        StringBuilder res = new StringBuilder("1");
        for(int i = 1; i < n; i++){
            res=build(res);
        }
        return res.toString();
    }

    private StringBuilder build(StringBuilder s){
        int len = s.length();
        int i = 0 ;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while( i < len){
            int count = 0;
            j = i;
            while(i < len && s.charAt(i) == s.charAt(j)){
                i++;
                count++;
            }

            sb.append(count);
            sb.append(s.charAt(j));

        }
        return sb;
    }
}
