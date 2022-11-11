package dsa.easy;

public class SqRt {

    public static void main(String[] args) {
        int x = 168;
        System.out.println(mySqrt(x));
    }
    /*
    start with a range between 1 to x/2 (square root of any number can not be greater than half of the number)
find the mid point and calculate the x/mid as quotient
we go for division instead of multiplication to avoid unwanted overflow
If quotient == mid; we have our answer
If quotient > mid; move start to mid; not to mid + 1 as mid might be a valid answer
if quotient < mid; move end to mid-1

 In our ideal situation mid * mid = x

Replace div with x/mid in all cases
Case 1: div == mid => x/mid = mid => x == mid*mid => return our answer
Case 2: div > mid => x/mid > mid => x > mid*mid => move start to mid (go to right half)
Case 3: div < mid => x/mid < mid => x < mid*mid => move end to mid-1(go to left half)
     */
    public static int mySqrt(int x) {

        if (x == 0 || x == 1) return x;

        int start = 1, end = x/2;
        while (start < end) {
            int mid = (start + (end - start) / 2) + 1;
            int div = x/mid;
            // System.out.println(x/mid);
            if( mid == div){
                return mid;
            }else if(div > mid){
                start = mid ;
            }else{
                end = mid - 1;
            }

        }
        return start ;

    }
}
