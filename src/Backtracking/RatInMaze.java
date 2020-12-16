package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RatInMaze {
    public static class Solution {
        public static boolean ratInAMax(int[][] maze, int[][] path, int x, int y){
            if(x<0 || y<0 || x>=maze.length || y>=maze.length){
                return false;
            }
            if(maze[x][y]==0)
                return false;
            if(path[x][y]==1)
                return false;
            path[x][y]=1;
            if(x==maze.length-1 && y==maze.length-1){
                for(int r=0; r<path.length; r++){
                    for(int c=0; c<path.length; c++){
                        System.out.print(path[r][c]+" ");
                    }
                    System.out.println();
                }
                return true;
            }
            if(ratInAMax(maze, path, x, y-1) || ratInAMax(maze, path, x+1, y) || ratInAMax(maze, path, x, y+1) || ratInAMax(maze, path, x-1, y))
                return true;
            return false;
        }

        public static boolean ratInAMaze(int maze[][]){
            int[][] path = new int[maze.length][maze.length];
            return ratInAMax(maze, path, 0,0);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int maze[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                maze[i][j] = s.nextInt();
            }
        }
        System.out.println(Solution.ratInAMaze(maze));
    }
}
