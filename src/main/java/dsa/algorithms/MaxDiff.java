package dsa.algorithms;
class MaxDiff{

    private static int maxDiff(int[] a){
        int len = a.length;
        int min = a[0];
        int res = 0;
        for(int i = 1; i < len; i++){
            if(a[i] > a[i-1]){
                res = Math.max(res, a[i] - min);
            }else if(a[i] != a[i-1]){
                min = a[i];
            }
        }
        return res;
    }
    public static void main(String args[]){
        int[] a = {2, 3, 10, 6, 4, 8, 1};
        a = new int[]{7, 9, 5, 6, 3, 2};
        a = new int[] {80, 2, 6, 3, 100};
        int res = maxDiff(a);
        System.out.println(res);
    }
}
