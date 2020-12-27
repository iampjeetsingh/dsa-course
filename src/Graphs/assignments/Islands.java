package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Islands {
    public static class Solution {
        public static int numConnected(int[][] edges, int n) {
            int count = 0;
            boolean[] visited = new boolean[edges.length];
            Queue<Integer> queue = new LinkedList<>();
            if(edges.length>0){
                queue.add(0);
                visited[0] = true;
            }
            while (!queue.isEmpty()){
                int vertex = queue.remove();
                for(int j=0; j< edges.length; j++){
                    if(edges[vertex][j]==1 && !visited[j]){
                        queue.add(j);
                        visited[j] = true;
                    }
                }
                if(queue.isEmpty()){
                    count++;
                    for(int i=0; i<visited.length; i++){
                        if(!visited[i]){
                            queue.add(i);
                            visited[i] = true;
                            break;
                        }
                    }
                }
            }
            return count;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[][] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        int[][] edges = new int[n][n];
        int firstvertex, secondvertex;

        for (int i = 0; i < e; i++) {
            String[] strNums1;
            strNums1 = br.readLine().split("\\s");
            firstvertex = Integer.parseInt(strNums1[0]);
            secondvertex = Integer.parseInt(strNums1[1]);
            edges[firstvertex][secondvertex] = 1;
            edges[secondvertex][firstvertex] = 1;
        }
        return edges;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [][]edges = takeInput();

        int ans = Solution.numConnected(edges, edges.length);
        System.out.println(ans);

    }
}
