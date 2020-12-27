package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HasPath {
    public static class Solution {
        private static boolean hasPathDFS(int[][] adjMat, int s, int d, boolean[] path){
            if(s==d)
                return true;
            path[s] = true;
            for(int i=0; i<adjMat.length; i++){
                if(adjMat[s][i]==1 && !path[i]){
                    boolean foundPath = hasPathDFS(adjMat, i, d, path);
                    if(foundPath)
                        return true;
                }
            }
            return false;
        }
        private static boolean hasPathBFS(int[][] adjMat, int s, int d){
            boolean[] path = new boolean[adjMat.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            path[s] = true;
            while (!queue.isEmpty()){
                int e = queue.poll();
                if(e==d)
                    return true;
                for(int i=0; i<adjMat.length; i++){
                    if(adjMat[e][i]==1 && !path[i]){
                        queue.add(i);
                        path[i] = true;
                    }
                }
            }
            return false;
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
            StringTokenizer st3 = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(st3.nextToken());
            int d = Integer.parseInt(st3.nextToken());
            // System.out.println(hasPathDFS(adjacentMatrix, s, d, new boolean[n]));
            System.out.println(hasPathBFS(adjacentMatrix, s, d));
        }
    }
}
