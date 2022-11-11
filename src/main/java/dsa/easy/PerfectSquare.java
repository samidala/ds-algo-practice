package dsa.easy;

public class PerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int left = 1;
        int right = num /2;
        while(left <= right){
            int mid = left + (right - left)/2;
            int remain = num % mid;
            int div = num / mid;
            if(div == mid && remain ==0){
                return true;
            }else if(div > mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;

    }
}
