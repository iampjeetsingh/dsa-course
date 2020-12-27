package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IsConnected {
    public static class Solution {
        private static boolean isConnected(int[][] adjMat){
            boolean[] path = new boolean[adjMat.length];
            Queue<Integer> queue = new LinkedList<>();
            if(adjMat.length>0){
                queue.add(0);
                path[0] = true;
            }
            while (!queue.isEmpty()){
                int e = queue.poll();
                for(int i=0; i<adjMat.length; i++){
                    if(adjMat[e][i]==1 && !path[i]){
                        queue.add(i);
                        path[i] = true;
                    }
                }
            }
            for(boolean vertex : path){
                if(!vertex)
                    return false;
            }
            return true;
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
            System.out.println(isConnected(adjacentMatrix));
        }
    }
}
