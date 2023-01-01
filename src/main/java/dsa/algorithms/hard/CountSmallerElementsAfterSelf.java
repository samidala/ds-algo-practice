package dsa.algorithms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerElementsAfterSelf {

    public static void main(String[] args) {
        int[] a = {5,11,2,3,4,2,6,1};
        CountSmallerElementsAfterSelf obj = new CountSmallerElementsAfterSelf();
        System.out.println(obj.countMinsRight(a));
        System.out.println(Arrays.toString(a));
    }

    static class Pair{
        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    '}';
        }

        int index;
        int val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    List<Integer> countMinsRight(int[] a){
        int[] indices = new int[a.length];
        for(int i = 0; i < a.length; i++){
            indices[i] = i;
        }
        Pair[] pairs = new Pair[a.length];
        for(int i = 0; i < a.length; i++){
            pairs[i] = new Pair(i,a[i]);
        }
        int[] count = new int[a.length];
        //mergeSort(indices,a,0, a.length - 1, count);
        mergeSort(pairs,a,0, a.length - 1, count);
        List<Integer> list = new ArrayList<>();
        for(int c : count){
            list.add(c);
        }
        return list;

    }

    void mergeSort(Pair[] pairs, int[] a, int low, int high, int[] count){
        if(low >= high) return;

        int mid = low + (high - low) / 2;
        mergeSort(pairs,a,low,mid,count);
        mergeSort(pairs,a,mid+1,high,count);
        mergeAndCount(pairs,a,low,mid,high,count);
        //merge(a,low,mid,high);

    }

    void mergeSort(int[] indices, int[] a, int low, int high, int[] count){
        if(low >= high) return;

        int mid = low + (high - low) / 2;
        mergeSort(indices,a,low,mid,count);
        mergeSort(indices,a,mid+1,high,count);
       mergeAndCount(indices,a,low,mid,high,count);
        //merge(a,low,mid,high);

    }

    void mergeAndCount(Pair[] pairs, int[] a, int low, int mid, int high, int[] count) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        Pair[] temp = new Pair[high - low + 1];
        int countMinAtRight = 0;
        while (i <= mid && j <= high) {
            if (pairs[i].val > pairs[j].val) {
                countMinAtRight++;
                temp[k++] = pairs[j++];
            } else {
                count[pairs[i].index] += countMinAtRight;
                temp[k++] = pairs[i++];

            }
        }

        while (i <= mid) {
            count[pairs[i].index] += countMinAtRight;
            temp[k++] = pairs[i++];

        }
        while (j <= high) {
            temp[k++] = pairs[j++];
        }
        for (i = low; i <= high; i++) {
            pairs[i] = temp[i - low];
        }


    }
    void mergeAndCount(int[] indices, int[] a, int low, int mid, int high, int[] count){
        int i = low ;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high - low + 1];
        int countMinAtRight = 0;
        while( i <= mid &&  j <= high){
            if(a[indices[i]] > a[indices[j]]){
                countMinAtRight++;
                temp[k++] = a[indices[j++]];
            }else{
                count[indices[i]]+=countMinAtRight;
                temp[k++] = a[indices[i++]];
            }
        }

        while (i <= mid){
            count[indices[i]]+=countMinAtRight;
            temp[k++] = a[indices[i++]];
        }
        while (j <= high){
            temp[k++] = a[indices[j++]];
        }
        for( i = low; i <= high;i++){
            a[i] = temp[i-low];
        }

    }

    void merge(int[] nums, int start, int mi, int end){
        int lp = start;
        int rp = mi + 1;
        int[] buffer = new int[end-start+1];
        int t = 0; //buffer pointer

        while (lp <= mi && rp <= end){
            if (nums[lp] < nums[rp]){
                buffer[t++] = nums[lp++];
            }else{
                buffer[t++] = nums[rp++];
            }
        }

        while (lp <= mi) buffer[t++] = nums[lp++];
        while (rp <= end) buffer[t++] = nums[rp++];
        //Now copy sorted buffer into original array
        for (int i = start; i <= end; i++){
            nums[i] = buffer[i-start];
        }
    }

}
