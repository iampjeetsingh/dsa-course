package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class CodingNinjas {
    public static class Solution {
        boolean isPath(char[][] mat, String str, int x, int y, boolean[][] path){
            if(str.isEmpty())
                return true;
            if(x<0 || y<0 || x>=mat.length || y>=mat[0].length) {
                return false;
            }
            if(path[x][y]) {
                return false;
            }
            if(mat[x][y]!=str.charAt(0))
                return false;
            path[x][y] = true;
            boolean foundAtLeft = isPath(mat, str.substring(1), x-1, y, path);
            boolean foundAtRight = isPath(mat, str.substring(1), x+1, y, path);
            boolean foundAtTop = isPath(mat, str.substring(1), x, y-1, path);
            boolean foundAtBottom = isPath(mat, str.substring(1), x, y+1, path);
            boolean foundAtTopLeft = isPath(mat, str.substring(1), x-1, y-1, path);
            boolean foundAtTopRight = isPath(mat, str.substring(1), x-1, y+1, path);
            boolean foundAtBottomLeft = isPath(mat, str.substring(1), x+1, y-1, path);
            boolean foundAtBottomRight = isPath(mat, str.substring(1), x+1, y+1, path);
            path[x][y] = false;
            return foundAtLeft || foundAtBottom || foundAtRight || foundAtTop || foundAtTopLeft || foundAtTopRight || foundAtBottomLeft || foundAtBottomRight;
        }
        int solve(String[] Graph , int N, int M) {
            char[][] mat = new char[N][M];
            boolean[][] visited = new boolean[N][M];
            ArrayList<int[]> cs = new ArrayList<>();
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    mat[i][j] = Graph[i].charAt(j);
                    if(mat[i][j]=='C'){
                        cs.add(new int[]{i,j});
                    }
                }
            }
            for(int[] c : cs){
                if(isPath(mat, "CODINGNINJA", c[0], c[1], visited))
                    return 1;
            }
            return 0;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int size = 2;
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        String[] Graph = new String[input[0]];

        for (int i = 0; i < input[0]; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] Graph = takeInput();
        System.out.println(new Solution().solve(Graph,Graph.length,Graph[0].length()));
    }
}
