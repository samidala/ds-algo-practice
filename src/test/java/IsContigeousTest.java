import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tesco.Problem1;

import java.util.Arrays;
import java.util.List;

public class IsContigeousTest {

    @Test
    public void testSuccess(){

        Problem1.Interval interval1 = new Problem1.Interval();
        interval1.setStartTime(800);
        interval1.setEndTime(1000);
        Problem1.Interval interval2 = new Problem1.Interval();
        interval2.setStartTime(1400);
        interval2.setEndTime(1900);

        Problem1.Interval interval3 = new Problem1.Interval();

        interval3.setStartTime(1000);
        interval3.setEndTime(1200);
        Problem1 p = new Problem1();
        List<Problem1.Interval> list =
                p.mergeAndReturn(new Problem1.Interval[] {interval1,interval2,interval3});

       // Assertions.assertEquals(2,list.size());
        System.out.println(list);
    }
    @Test
    public void testError(){

        Problem1.Interval interval1 = new Problem1.Interval();
        interval1.setStartTime(800);
        interval1.setEndTime(1000);
        Problem1.Interval interval2 = new Problem1.Interval();
        interval2.setStartTime(900);
        interval2.setEndTime(1200);

        Problem1.Interval interval3 = new Problem1.Interval();
        interval3.setStartTime(1400);
        interval3.setEndTime(1900);

        Problem1 p = new Problem1();
        List<Problem1.Interval> list =
                p.mergeAndReturn(new Problem1.Interval[] {interval1,interval2,interval3});

        System.out.println(list);
    }

    @Test
    public void testError2(){

        Problem1.Interval interval1 = new Problem1.Interval();
        interval1.setStartTime(800);
        interval1.setEndTime(1000);
        Problem1.Interval interval2 = new Problem1.Interval();
        interval2.setStartTime(1100);
        interval2.setEndTime(1200);

        Problem1.Interval interval3 = new Problem1.Interval();
        interval3.setStartTime(1200);
        interval3.setEndTime(1400);

        Problem1.Interval interval4 = new Problem1.Interval();
        interval4.setStartTime(1300);
        interval4.setEndTime(1900);

        System.out.println(Arrays.toString(new Problem1.Interval[] {interval1,interval2,interval4,interval3}));
        Problem1 p = new Problem1();
        List<Problem1.Interval> list =
                p.mergeAndReturn(new Problem1.Interval[] {interval1,interval2,interval4,interval3});

        System.out.println(list);
    }
}
