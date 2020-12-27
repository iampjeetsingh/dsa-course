package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    public static class Solution {
        private static void bftransversal(int[][] adjMat){
            boolean[] visited = new boolean[adjMat.length];
            Queue<Integer> queue = new LinkedList<>();
            if(adjMat.length>0){
                queue.add(0);
                visited[0] = true;
            }
            while (!queue.isEmpty()){
                int vertex = queue.remove();
                System.out.print(vertex+" ");
                for(int j=0; j< adjMat.length; j++){
                    if(adjMat[vertex][j]==1 && !visited[j]){
                        queue.add(j);
                        visited[j] = true;
                    }
                }
                if(queue.isEmpty()){
                    for(int i=0; i<visited.length; i++){
                        if(!visited[i]){
                            queue.add(i);
                            visited[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int[][] adjacentMatrix = new int[n][n];
            for(int i=0; i<e; i++){
                StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());
                int v1 = Integer.parseInt(st2.nextToken());
                int v2 = Integer.parseInt(st2.nextToken());
                adjacentMatrix[v1][v2] = 1;
                adjacentMatrix[v2][v1] = 1;
            }
            bftransversal(adjacentMatrix);
        }
    }
}
