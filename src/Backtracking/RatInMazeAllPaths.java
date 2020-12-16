package Backtracking;

import java.util.Scanner;

public class RatInMazeAllPaths {
    public static class Solution {
        public static void ratInAMax(int[][] maze, int[][] path, int x, int y){
            if(x<0 || y<0 || x>=maze.length || y>=maze.length){
                return;
            }
            if(maze[x][y]==0)
                return;
            if(path[x][y]==1)
                return;
            path[x][y]=1;
            if(x==maze.length-1 && y==maze.length-1){
                for(int r=0; r<path.length; r++){
                    for(int c=0; c<path.length; c++){
                        System.out.print(path[r][c]+" ");
                    }
                }
                System.out.println();
            }else {
                ratInAMax(maze, path, x, y-1);
                ratInAMax(maze, path, x+1, y);
                ratInAMax(maze, path, x, y+1);
                ratInAMax(maze, path, x-1, y);
            }
            path[x][y] = 0;
        }

        public static void ratInAMaze(int maze[][]){
            int[][] path = new int[maze.length][maze.length];
            ratInAMax(maze, path, 0,0);
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
        Solution.ratInAMaze(maze);
    }
}
