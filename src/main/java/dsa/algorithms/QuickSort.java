package dsa.algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = { 6, 5, 12, 10, 9, 1 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr){
        quickSort(arr, 0,arr.length-1);
    }
    private static void quickSort(int[] arr, int start,int end){
        if(start < end){
            int mid = start + (end - start) / 2;
            int pvtVal = arr[mid];
            int left = start;
            int right = end;
            while (left < right){
                while (arr[left] < pvtVal){
                    left++;
                }
                while (arr[right] > pvtVal){
                    right--;
                }
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            quickSort(arr,start,mid);
            quickSort(arr,mid+1,end);

        }
    }
}
