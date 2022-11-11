package dsa.algorithms;

import java.util.Stack;

public class SmallestLexStringAfterRemovingKChars {

    public static void main(String[] args) {
   /*     test1();
        test2();
        test3();
        test4();
        test5();
        test6();*/
        test7();
        test8();
        test9();
    }

    static void test1(){
        String S = "faddbe";
        int k  = 2;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }
    static void test2(){
        String S = "gddbd";
        int k  = 2;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }
    static void test3(){
        String S = "addbdbbbbbbb";
        int k  = 2;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }

    static void test4(){
        String S = "asdfasdfasdf";
        int k  = 2;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }
    static void test5(){
        String S = "asdfasdf";
        int k  = 2;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }

    static void test6(){
        String S = "fooland";
        int k  = 2;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }

    static void test7(){
        String S = "code";
        int k  = 4;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }
    static void test8(){
        String S = "abaa";
        int k  = 2;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }
    static void test9(){
        String S = "abaaasdfasdfasdfabacabcbabcacbacbabcdancd";
        int k  = 5;
        String res = lexicographicallySmallest(S,k);
        System.out.println(S+ " ==> "+ res);
    }

    static String lexicographicallySmallest(String S, int k) {
        // code here
        int len = S.length();
        k = isPowerOfTwo(len) ? k / 2 : k * 2;
        System.out.println(" k "+k);

        if(k == 0){
            return S;
        }
        if(k >= len){
            return "-1";
        }
        char[] res = new char[len - k ];
        res[0] = S.charAt(0);
        int i = 1;
        int j = 1;

        while(i < len && k > 0 ){
            char ch = S.charAt(i);
            if(ch < res[j - 1] ){
                while( j > 0 && ch < res[j - 1] && k > 0){
                    j--;
                    k--;
                }
            }
            if(j < res.length) {
                res[j++] = ch;
            }
            i++;
        }
        while ( i < len ){
            res[j++] = S.charAt(i++);
        }

        return new String(res);

    }
    static boolean isPowerOfTwo(int value){
        return (value != 0) && ((value & (value - 1))) == 0;
    }
}
