package dsa.algorithms;

import java.util.Arrays;

public class MergeSort {

    static int[] arr;
    public static void main(String[] args) {
        int arr[] = { 6, 5, 12, 10, 9, 1 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr){
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length - 1);

    }
    private static void mergeSort(int[] arr, int start, int end){

        if(start < end){
            int mid = start + (end - start) / 2;
            mergeSort(arr, start,mid);
            mergeSort(arr,mid+1, end);
            merge(arr,start,mid,end);
        }

    }
    private static void merge(int[] arr, int start, int mid,int end){

        int leftLen = mid - start + 1; //left side array length
        int rightLen = end - mid ; // right side array
        int[] left = new int[leftLen];
        int[] right = new int[rightLen];



        for(int i = 0 ; i < leftLen;i++){
            left[i] = arr[i + start];
        }
        for(int i = 0 ; i < rightLen; i++){
            right[i] = arr[i+mid+1];
        }
        System.out.println(Arrays.toString(left) + "\t\t "+ Arrays.toString(right));
        int leftIndex = 0;
        int rightIndex = 0;
        int index = start;

        while (leftIndex < leftLen && rightIndex < rightLen){
            if(left[leftIndex] < right[rightIndex]){
                arr[index++] = left[leftIndex++];
            }else{
                arr[index++] = right[rightIndex++];
            }
        }

        while (leftIndex < leftLen){
            arr[index++] = left[leftIndex++];
        }

        while (rightIndex < rightLen){
            arr[index++] = right[rightIndex++];
        }


    }
}
