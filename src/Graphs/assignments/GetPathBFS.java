package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GetPathBFS {
    public static class Solution {
        public static ArrayList<Integer> getPath(int[][] adjMat, int s, int d){
            boolean path[] = new boolean[adjMat.length];
            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            path[s] = true;
            map.put(s, -1);
            while (!queue.isEmpty()){
                int e = queue.poll();
                for(int i=0; i< adjMat.length; i++){
                    if(adjMat[e][i]==1 && !path[i]){
                        queue.add(i);
                        path[i] = true;
                        map.put(i, e);
                        if(i==d){
                            queue.clear();
                            break;
                        }
                    }
                }
            }
            ArrayList<Integer> output = new ArrayList<>();
            int i = d;
            while (map.containsKey(i)){
                output.add(0, i);
                i = map.get(i);
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
            ArrayList<Integer> path = getPath(adjacentMatrix, s, d);
            if(path!=null){
                for(int i=path.size()-1; i>=0; i--){
                    System.out.print(path.get(i)+" ");
                }
            }
        }
    }
}
