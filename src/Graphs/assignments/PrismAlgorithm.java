package Graphs.assignments;

import java.util.*;

public class PrismAlgorithm {
    private static class Edge implements Comparable<Edge>{
        public int v1, v2;
        public int weight;

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(weight, e.weight);
        }
    }
    public static class Solution {

        public static Edge[] prismAlgorithm(int[][] adjMat, int v){
            int[] parents = new int[v];
            int[] weights = new int[v];
            boolean[] visited = new boolean[v];
            Arrays.fill(weights, Integer.MAX_VALUE);
            int vertex = 0;
            while (true){
                visited[vertex] = true;
                for(int i=0; i<v; i++){
                    if(adjMat[vertex][i]>0 && weights[i]>adjMat[vertex][i] && !visited[i]){
                        weights[i] = adjMat[vertex][i];
                        parents[i] = vertex;
                    }
                }
                int minWeight = Integer.MAX_VALUE, minWeightVertex = 0;
                for(int i=0; i<v; i++){
                    if(i==vertex)
                        continue;
                    if(!visited[i]){
                        if(weights[i]<minWeight){
                            minWeight = weights[i];
                            minWeightVertex = i;
                        }
                    }
                }
                if(minWeight==Integer.MAX_VALUE)
                    break;
                vertex = minWeightVertex;
            }
            Edge[] edges = new Edge[v-1];
            for(int i=1; i<v; i++){
                Edge edge = new Edge();
                edge.v1 = i;
                edge.v2 = parents[i];
                edge.weight = weights[i];
                edges[i-1] = edge;
            }
            return edges;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] adjMat = new int[V][V];
            for(int i=0; i<E; i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int weight = sc.nextInt();
                adjMat[v1][v2] = weight;
                adjMat[v2][v1] = weight;
            }
            Edge[] mst = prismAlgorithm(adjMat, V);
            for(Edge edge : mst){
                System.out.println(Math.min(edge.v1, edge.v2)+" "+Math.max(edge.v1, edge.v2)+" "+edge.weight);
            }
        }
    }
}
