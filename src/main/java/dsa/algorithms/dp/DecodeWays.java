package dsa.algorithms.dp;

public class DecodeWays {
    public static void main(String[] args) {

        String no = "1234";
        int count = count(no);
        System.out.println(count);
    }
    static int count(String no){
        int count = 1;

        //110/100 or 110/10
        for( int i = 0 ; i < no.length() - 1; i++){
            int val = Integer.parseInt(no.substring(i,i+2));
            if(val > 0 && val <= 26){
                count++;
            }
        }
        return count;
    }
}
