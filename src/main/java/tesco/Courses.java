package tesco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Courses {

    public static void main(String[] args) {

        int numCourses = 2;
        int[][] pre = {{1,0}};

        canFinish(numCourses,pre);

    }
    public static boolean canFinish(int numCourses, int[][] pre) {

        List<Integer>[] g = new ArrayList[numCourses];

        for(int i = 0 ; i < numCourses; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < numCourses; i++){
            System.out.println("before "+i+ " "+g[i]);
        }
        for(int i = 0 ; i < pre.length; i++){
            List<Integer> list = g[pre[i][1]];
            System.out.println("adding "+pre[i][1] + " and "+pre[i][0] +" read list is "+list);
            list.add(pre[i][0]);
        }
        for(int i = 0 ; i < numCourses; i++){
            System.out.println("after "+i+ " "+g[i]);
        }
        Set<Integer> v = new HashSet(numCourses);
        Set<Integer> r = new HashSet(numCourses);
        for(int i = 0 ; i < numCourses; i++){
            System.out.println("call for "+i);
            if(!v.contains(i)){
                if(isCycle(g,v,r,i,-1)){
                    System.out.println("cycle  for "+i);
                    return false;
                }
            }
        }
        return true;

    }

    static boolean  isCycle(List<Integer>[] g,Set<Integer> v,Set<Integer> r, int src, int p){

        //System.out.println("src "+src + " and parent "+p+ " visited contains src "+v.contains(src) +" rec contains src "+r.contains(src));
        System.out.println("visited "+v+" rec "+r);
        v.add(src);
        r.add(src);

        for(int dest : g[src]){
            System.out.println("All Next links for src "+src +" adj "+g[src]);
            System.out.println("src "+src + " and parent "+p+ " visited contains dest "+v.contains(dest) +" rec contains dest "+r.contains(dest) + " dest is "+dest);
            if(!v.contains(dest)){
                if(isCycle(g,v,r,dest,src)) {
                    System.out.println("visited isCycle : for src "+src+ " dest " +dest);
                    return true;
                }

            }else if(r.contains(dest)){
                System.out.println("visited  - present in r : for src "+src+ " dest " +dest);
                return true;
            }
        }
        r.remove(src);

        return false;
    }


}
