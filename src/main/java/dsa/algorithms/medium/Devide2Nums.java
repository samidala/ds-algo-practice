package dsa.algorithms.medium;

public class Devide2Nums {

    public static void main(String[] args) {
    /*    System.out.println(Math.abs(
                -2147483648));
*/
        System.out.println(divideConstant(100,4) + " "+divide(100,4));
    }

    public static int divideConstant(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0;
        for (int x = 31; x >= 0; x--) {
            //System.out.println("x " + x);
            System.out.println("a >>>x "+(a>>>x) + " binStr(a) ="+Integer.toBinaryString((a >>> x)));
            if ((a >>> x) - b >= 0) {
                res= res + (1 << x);
                a -= b << x;
                System.out.println("res "+res + " a "+a + " x "+x);
            }
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Cornor case when -2^31 is divided by -1 will give 2^31 which doesnt exist so overflow

        boolean negative = dividend < 0 ^ divisor < 0; //Logical XOR will help in deciding if the results is negative only if any one of them is negative

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;

        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return negative ? -quotient : quotient;
    }
    public int divideNotWorking(int dividend, int divisor) {

        boolean isDividendNeg = dividend < 0 ? true : false;
        boolean isDivisorNeg = divisor < 0 ? true : false;

        int count = 0;
        if(dividend < 0){
            dividend = Math.abs(dividend);
        }
        if(divisor < 0){
            divisor = Math.abs(divisor);
        }
        while (dividend > 0 && dividend >= divisor ){
            dividend-=divisor;
            count++;
        }
        System.out.println(" dividend" +dividend);
        return isDividendNeg || isDivisorNeg ?
                (isDividendNeg && isDivisorNeg ? count : -1 * count) : count;
    }
}
