package dsa.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1,0,1,0};
        nums = new int[] {-1,0,1,2,-1,-4};
        nums = new int[]{0,0,0};
        nums = new int[]{0,1,1};

        List<List<Integer>> res = threeSum(nums);

        System.out.println(res);
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> res = new ArrayList();
        for(int pos = 0 ; pos < len && nums[pos] < 1; pos++){
            int currentNo = nums[pos];
            int i = pos + 1;
            int j = len - 1;

            while ( i < j){
                List<Integer> currentRes = new ArrayList(3);
                //System.out.println("currentNo "+currentNo + " nums[i]="+nums[i]+" nums[j]="+nums[j]);
                int sum  = currentNo + nums[i] + nums[j] ;
                if(sum == 0 ){
                    //System.out.println("when sum is 0. currentNo "+currentNo + " nums[i]="+nums[i]+" nums[j]="+nums[j]+" pos "+pos+" i = "+i+" j = "+j);
                    currentRes.add(currentNo);
                    currentRes.add(nums[i]);
                    currentRes.add(nums[j]);
                    res.add(currentRes);
                    while(i < len -1 && nums[i] == nums[i+1] ){
                        i++;
                    }
                    while(j > 0  && nums[j] == nums[j-1]){
                        j--;
                    }
                        i++;
                        j--;


                }else if(sum < 0){
                    i++;
                }else{
                    j--;
                }
            }
            while(pos < len-1 && nums[pos+1] == nums[pos]){
                pos++;
            }

        }
        return res;

    }

    public List<List<Integer>> threeSumUsingBinarySearch(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) return res;
        int negCnt = 0, posCnt = 0, zeroCnt = 0, minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            if(num == 0) {zeroCnt++;}
            else if(num<0) {negCnt++;}
            else {posCnt++;}
            if (minNum > num) minNum = num;
            if (maxNum < num) maxNum = num;
        }
        if(zeroCnt > 2) res.add(Arrays.asList(0,0,0));
        if (negCnt == 0 || posCnt == 0) return res;
        minNum = Math.max(minNum, -2*maxNum);
        maxNum = Math.min(maxNum, -2*minNum);
        int[] negNums = new int[negCnt], posNums = new int[posCnt];
        int[] procNums = new int[maxNum - minNum + 1];
        negCnt = 0; posCnt = 0;
        for(int num: nums){
            if(num < minNum || num > maxNum) continue;
            if(procNums[num-minNum]++ == 0){
                if (num < 0){
                    negNums[negCnt++] = num;
                }else if (num > 0){
                    posNums[posCnt++] = num;
                }
            }
        }
        Arrays.sort(negNums, 0, negCnt--);
        Arrays.sort(posNums, 0, posCnt--);
        int l, m, r, posFrom, posTo;
        for(int posLeft = 0; negCnt >= 0 && posCnt >= 0; negCnt--){
            l = negNums[negCnt];
            posFrom = Arrays.binarySearch(posNums, posLeft, posCnt, -l/2);
            posTo = Arrays.binarySearch(posNums, posLeft, posCnt, -l*2);
            if ( posFrom < 0) posFrom = Math.max(0, -posFrom - 1);
            if (posTo < 0) posTo = Math.min(posCnt, -posTo - 1);
            posLeft = posFrom;
            for(int posI = posTo; posI >= posFrom; posI--){
                r = posNums[posI];
                m = -l - r;
                if (m > r) break;
                int numCnt = procNums[m-minNum];
                if(numCnt > 0 && m >= l && (m != l || procNums[l-minNum] > 1) && (m != r || procNums[r-minNum] > 1)){
                    res.add(Arrays.asList(l,m,r));
                }
            }
        }
        return res;
    }
}
