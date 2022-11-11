package dsa.algorithms.medium;

public class CountPrimes {

    public static void main(String[] args) {
        int dividend = 30;
        int divisor = 3;
        int count = 0;
        while (dividend >= divisor){
            dividend>>>=1;
            System.out.println(dividend);
            count+=divisor;
        }
        System.out.println("count "+ count);
        System.out.println(50 >> 2);
        System.out.println(50 >>> 2);
    }
    public int countPrimes(int n) {

        int count = 0;
        boolean prime[] = new boolean[n];
        for(int i = 2; i < n;i++){
            if(prime[i] == false){
                count++;
                for(int j = 2; i * j < n;j++){
                    prime[i*j] = true;
                }
            }

        }
        return count++;
    }
}
