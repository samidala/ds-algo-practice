package dsa.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new TreeMap<>();
        for(int[] m : matches){
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        }
        System.out.println(losses);
        List<List<Integer>> r =Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player : losses.keySet())
            if(losses.get(player) <= 1)
                r.get(losses.get(player)).add(player);
        return r;
    }
    public List<List<Integer>> findWinnersv1(int[][] matches) {

        Map<Integer,Integer> count = new TreeMap();

        for(int i = 0 ; i < matches.length; i++){
            count.put(matches[i][1],count.getOrDefault(matches[i][1],0)+1);
        }
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        Set<Integer> set = new TreeSet();
        //  System.out.println("count "+count);
        res.add(new ArrayList());
        for(int i = 0 ; i < matches.length; i++){
            if(count.get(matches[i][0]) == null){
                set.add(matches[i][0]);
                //res.get(0).add(matches[i][0]);
            }
        }
        for(Map.Entry<Integer,Integer> en : count.entrySet()){
            if(en.getValue() == 1){
                res.get(1).add(en.getKey());
            }
        }
        res.set(0, new ArrayList(set));
        return res;
    }
}
