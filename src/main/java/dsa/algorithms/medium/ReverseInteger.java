package dsa.algorithms.medium;

import sun.security.rsa.RSAUtil;

import java.util.Arrays;

public class ReverseInteger {
    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);
       // System.out.println(reverse(1563847412));
        System.out.println(Integer.MAX_VALUE);
        //  int c = 2147483651;
        int x =  (Integer.parseInt("9") * 1000000000) + 646324315; //1534236469
        System.out.println(x);
    }
    static int reverse(int x) {

        //Arrays.binarySearch()
        int revNo = 0;
        int prevNo = 0;
        String strX = String.valueOf(x);
        boolean checkForLen = (x < 0 ?  strX.length() == 11 : strX.length() == 10);
        while ( x != 0){
            int rem = x % 10;
            prevNo = revNo;
            revNo = (revNo * 10 + rem);
            if(checkForLen &&  (revNo - rem) /10 != prevNo){
                return 0;
            }
            x /= 10;
        }
        return revNo;
    }
}
