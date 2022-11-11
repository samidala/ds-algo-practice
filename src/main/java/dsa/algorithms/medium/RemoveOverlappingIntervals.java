package dsa.algorithms.medium;

import java.util.Arrays;

public class RemoveOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        //Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int end = intervals[0][1];

        int count = 1;
        for(int i  =1; i <intervals.length; i++){
            if(intervals[i][0] >= end){
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;

    }

    public int eraseOverlapIntervalsDebug(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {
                count++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }

    public int eraseOverlapIntervalsDebugUsingMap(int[][] intervals) {
        //If there is only 1 value, we won't remove anything
        if(intervals.length <= 1) {
            return 0;
        }

        //Starting at the top, we find the minimum and maximum of the 2nd value
        //This is done in reverse to reduce the number of times to access the intervals.length
        int max = intervals[intervals.length-1][1];
        int min = max;
        for(int i=intervals.length-2; i>=0; i--) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }


        int shift = 1 - min;//Shift is to move all values so they are in order starting from 1

        int range = max - min + 2;
//         System.out.println("Max:   "+max);
//         System.out.println("Min:   "+min);
//         System.out.println("Shift: "+shift);
//         System.out.println("Range: "+range);

//         System.out.println("");

        //Loops through the intervals, and  puts them in an map where the location
        //stores the highest start value
        int[] intervalMap = new int[range];
        for(int[] interval : intervals) {
            int start = interval[0] + shift;
            int end = interval[1] + shift;
            // System.out.println("\nStart: "+start);
            // System.out.println("End:   "+end);
            // System.out.println("Map:   "+intervalMap[end]);
            if(start > intervalMap[end]) {
                intervalMap[end] = start;
            }
            // System.out.println("EMap:  "+intervalMap[end]);

        }
        // System.out.println(Arrays.toString(intervalMap));


        //We then loop through the map, and if the location in  the map has a value > 0
        //It has an actual place
        //IF that value is higher than the previous starting value, we know it is valid.
        int totalValidSequence = 1;
        int start = 1;
        for(int i = 1; i < range; i++) {
            if(intervalMap[i] >= start) {
                start = i;
                totalValidSequence++;
            }
        }
        //Then we subtract the total valid sequences from the total length to see how many bad
        //intervals there are
        return intervals.length - totalValidSequence;



        /*Way to do it wit sorting
        //Sort based on the second element in ascending order
        Arrays.sort(intervals, (a, b) -> a[1] - b[1] );

        int end=intervals[0][1];//We start end based on the first element to allow us to skip one value
        int removal=0;//0 removals are done on the first element

        for(int i=1; i<intervals.length; i++){
            int[] interval= intervals[i];
            if(interval[0]>=end){
                end=interval[1];
            }
            else{
                removal++;
            }
        }
        return removal;

        */


    }
}
