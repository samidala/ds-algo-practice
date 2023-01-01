package recurrsion;

public class PrintFirstNSum {

    public static void main(String[] args) {

        sum(10,0);
        System.out.println("returned sum "+sum(10));
    }
    static void sum(int i, int sum){
        if(i == 0){
            System.out.println("sum "+sum);
            return;
        }
        sum(i-1,sum+i);
    }
    static int sum(int i){
        if(i == 0){
            return 0;
        }
        return i+ sum(i-1);
    }
}
