package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GetPathDFS {
    public static class Solution {
        public static ArrayList<Integer> getPath(int[][] adjMat, int s, int d, boolean[] path){
            path[s] = true;
            if(s==d){
                ArrayList<Integer> output = new ArrayList<>();
                output.add(s);
                return output;
            }
            int size = Integer.MAX_VALUE;
            ArrayList<Integer> output = null;
            for(int i=0; i< adjMat.length; i++){
                if(adjMat[s][i]==1 && !path[i]){
                    ArrayList<Integer> smallOutput = getPath(adjMat, i, d, path);
                    if(smallOutput==null)
                        continue;
                    if(smallOutput.size()<size){
                        output = smallOutput;
                        size = smallOutput.size();
                    }
                }
            }
            if(output!=null){
                output.add(0, s);
            }
            return output;
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
            ArrayList<Integer> path = getPath(adjacentMatrix, s, d, new boolean[n]);
            if(path!=null){
                for(int i=path.size()-1; i>=0; i--){
                    System.out.print(path.get(i)+" ");
                }
            }
        }
    }
}
