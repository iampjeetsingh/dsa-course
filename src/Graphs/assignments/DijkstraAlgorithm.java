package Graphs.assignments;

import java.util.Arrays;
import java.util.Scanner;

public class DijkstraAlgorithm {
    public static class Solution {
        public static int[] dijkstraAlgorithm(int[][] adjMat, int v){
            int[] distances = new int[v];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[0] = 0;
            boolean[] visited = new boolean[v];
            int index = 0;
            while (true){
                visited[index] = true;
                int distance = distances[index];
                for (int i=1; i<v; i++){
                    if(adjMat[index][i]>0 && !visited[i] && distance+adjMat[index][i]<distances[i]){
                        distances[i] = distance+adjMat[index][i];
                    }
                }
                int minVertex = -1;
                for(int i=0; i<v; i++){
                    if(!visited[i] && (minVertex==-1 || distances[i]<distances[minVertex])){
                        minVertex = i;
                    }
                }
                if(minVertex==-1)
                    break;
                index = minVertex;
            }
            return distances;
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
            int[] mst = dijkstraAlgorithm(adjMat, V);
            for(int i=0; i<mst.length; i++){
                System.out.println(i+" "+mst[i]);
            }
        }
    }
}
