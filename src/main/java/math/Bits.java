package math;

public class Bits {

    public static void main(String[] args) {
        for(int i = 1; i <=100; i++){
            if((i&1) == 0) {
                System.out.println(Integer.toBinaryString(i) + " "+ i);
            }
        }

        int n = 16;
        int m = 2;//n * Math.pow(2,m)

        int x = 10;
        x = ~x;
        x+=1;
        System.out.println("x is " +x);


        System.out.println("left shift by 1 is multiplication 2 " + ((n << m) == (n * Math.pow(2,m))));
        System.out.println("right shift by 1 is division by 2 " + ((n >> m) == (n *(1/(Math.pow(2,m))))));

    }

}
