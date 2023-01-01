package tesco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        Parent p = new Child();
        System.out.println(p.x);
    }
    static class Parent {
        public int x = 10;
        public void m1() throws RuntimeException{
            System.out.println("do somethings");
        }
        public void m2() throws Exception{

        }
        public void m3() throws Exception{

        }
        public void m4() throws Exception{

        }
        public void m5() throws RuntimeException{

        }
    }
    static class  Child extends Parent{
        private int x = 20;

        @Override
        public void m1()  {
            System.out.println("child m1");
        }

        @Override
        public void m2()  {
            System.out.println("it is okay not to throw exception");
        }

        @Override
        public void m3() throws SQLException {
            System.out.println("nothing");
        }

        @Override
        public void m4() throws RuntimeException {
            System.out.println("it is allowed");
        }

        @Override
        public void m5() throws RuntimeException {
            super.m5();
        }
    }

    static interface MyInterface{
        void m1() throws RuntimeException;
        void m2() throws Exception;

    }
    class MyClass implements MyInterface{

        @Override
        public void m1() throws RuntimeException {

        }

        @Override
        public void m2() throws RuntimeException {

        }
    }
   public static class Interval{
        private int startTime;
        private int endTime;

       @Override
       public String toString() {
           return "Interval{" +
                   "startTime=" + startTime +
                   ", endTime=" + endTime +
                   '}';
       }

       public int getStartTime() {
           return startTime;
       }

       public void setStartTime(int startTime) {
           this.startTime = startTime;
       }

       public int getEndTime() {
           return endTime;
       }

       public void setEndTime(int endTime) {
           this.endTime = endTime;
       }
   }

    public List<Interval> mergeAndReturn(Interval[] intervals){

        if(intervals == null || intervals.length == 0){
            //validate and return error
        }

        if(intervals.length != 3){
            //validate and return error response
        }

        Arrays.sort(intervals, Comparator.comparingInt(start -> start.startTime));

        List<Interval> schedule = new ArrayList<>();

        int start = intervals[0].startTime;
        int end = intervals[0].endTime;
        for(int i = 1 ; i < intervals.length;i++){

            if(intervals[i].getStartTime() <= end){
                end = Math.max(end,intervals[i].endTime);
            }else{
                Interval newInterval = new Interval();
                newInterval.setStartTime(start);
                newInterval.setEndTime(end);
                schedule.add(newInterval);
                start = intervals[i].startTime;
                end = intervals[i].endTime;
            }
        }

        Interval last = new Interval();
        last.startTime = start;
        last.endTime = end;
        schedule.add(last);
        return schedule;
    }

    boolean isOverlapping(Interval current, Interval prev){
        if(current.startTime <= prev.endTime){
            return true;
        }
        return false;
    }

    Interval canMerge(Interval current, Interval prev){
       if(isOverlapping(current,prev)){
           Interval newInterval = new Interval();
           newInterval.setStartTime(prev.getStartTime());
           newInterval.setEndTime(current.getEndTime());

           return newInterval;
       }else{
           return current;
       }
    }
}
