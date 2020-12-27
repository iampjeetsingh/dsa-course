package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ConnectingDots {
    public static class Solution {
        static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        String key(int x, int y){
            return x+":"+y;
        }
        boolean isValid(int n, int m, int x, int y){
            if(x<0 || y<0 || x>=n || y>=m)
                return false;
            return true;
        }
        boolean solve(String[] board , int n, int m, int x, int y, HashMap<String, String> path, char c) {

            boolean res = false;
            for(int[] dir : dir){
                int x1 = x+dir[0];
                int y1 = y+dir[0];
                if(isValid(n,m,x1,y1) && board[x1].charAt(y1)==c){
                    if(path.containsKey(key(x1, y1))){
                        if(path.get(key(x1,y1)).equals(""))
                            continue;
                        if(!path.get("last").equals(key(x1, y1))){
                            if(path.size()>=4)
                                return true;
                        }
                    }else {
                        path.put(key(x1, y1), key(x, y));
                        path.put("last", key(x1, y1));
                        res = solve(board, n, m, x1, y1, path, c);
                        if(res)
                            break;
                        path.remove(key(x1, y1));
                    }
                }
            }
            return res;
        }
        int solve(String[] board , int n, int m) {
            HashMap<String, String> map = new HashMap<>();
            boolean found = false;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    map.put(key(i,j), key(i,j));
                    map.put("last", key(i,j));
                    found = solve(board, n, m, i, j, map, board[i].charAt(j));
                    if(found)
                        return 1;
                    map.put(key(i,j), "");
                }
            }
            return 0;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] takeInput() throws IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");

        int N = Integer.parseInt(strNums[0]);
        int M = Integer.parseInt(strNums[1]);

        String[] Graph = new String[N];

        for (int i = 0; i < N; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String[] Graph = takeInput();
        if (new Solution().solve(Graph,Graph.length,Graph[0].length())==1){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }


    }
}
