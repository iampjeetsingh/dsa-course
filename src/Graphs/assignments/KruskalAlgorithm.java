package Graphs.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class KruskalAlgorithm {
    public static class Solution {
        private static class Edge implements Comparable<Edge>{
            public int v1, v2;
            public int weight;

            @Override
            public int compareTo(Edge e) {
                return Integer.compare(weight, e.weight);
            }
        }
        private static int findParent(int[] parents, int i){
            int parent = i, index;
            do{
                index = parent;
                parent = parents[index];
            }while (parent!=index);
            return parent;
        }

        public static Edge[] kruskalAlgorithm(Edge[] edges, int V){
            int[] parents = new int[V];
            for(int i=0; i<V; i++)
                parents[i] = i;
            int count = 0;
            Edge[] mst = new Edge[V-1];
            for(Edge edge : edges){
                int p1 = findParent(parents, edge.v1);
                int p2 = findParent(parents, edge.v2);
                if(p1!=p2){
                    if(count==V)
                        break;
                    mst[count++] = edge;
                    parents[p1] = p2;
                }
            }
            return mst;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int V = sc.nextInt();
            int E = sc.nextInt();
            Edge[] edges = new Edge[E];
            for(int i=0; i<E; i++){
                Edge edge = new Edge();
                edge.v1 = sc.nextInt();
                edge.v2 = sc.nextInt();
                edge.weight = sc.nextInt();
                edges[i] = edge;
            }
            Arrays.sort(edges);
            Edge[] mst = kruskalAlgorithm(edges, V);
            for(Edge edge : mst){
                System.out.println(Math.min(edge.v1, edge.v2)+" "+Math.max(edge.v1, edge.v2)+" "+edge.weight);
            }
        }
    }
}
