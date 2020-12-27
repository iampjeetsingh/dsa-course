package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPiece {
    public static class Solution {
        static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        private static int dfs(String[] edge, int n, int x, int y, boolean[][] visited) {
            if(x<0 || y<0 || x>=n || y>=n)
                return 0;
            if(visited[x][y])
                return 0;
            if(edge[x].charAt(y)=='0')
                return 0;
            visited[x][y] = true;
            int sum = 0;
            for(int[] d : dir){
                sum += dfs(edge, n, x+d[0], y+d[1], visited);
            }
            return 1 + sum;
        }
        public static int dfs(String[] edge, int n) {
            boolean[][] visited = new boolean[n][n];
            int max = -1;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j]){
                        int ans = dfs(edge, n, i, j, visited);
                        if(ans>max)
                            max = ans;
                    }
                }
            }
            return max;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());


        String[] edge = new String[n];
        for (int i = 0; i < n; i++) {
            edge[i] = br.readLine().replaceAll("\\s", "");
        }
        return edge;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] edge = takeInput();
        int ans = Solution.dfs(edge,edge.length);
        System.out.println(ans);
    }
}
