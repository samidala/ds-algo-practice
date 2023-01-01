package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
                new Comparator<Pair>(){
                    public int compare(Pair p0, Pair p1){
                        return p0.dist - p1.dist;
                    }
                });

        pq.offer(new Pair(S,0));
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S] = 0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.node;
            for(ArrayList<Integer> it : adj.get(node)){

                int v = it.get(0);
                int distV = it.get(1);
                if (dist[node] + distV < dist[v]) {
                    dist[v] = dist[node] + distV;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        return dist;

    }
    static class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}
