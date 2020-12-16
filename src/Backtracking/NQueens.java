package Backtracking;

import java.util.Scanner;

public class NQueens {
    public static class Solution {

        private static boolean isSafe(int[][] board, int x, int y){
            for(int i=0; i<board.length; i++){
                if(board[i][y]==1)
                    return false;
            }
            for(int j=0; j<board.length; j++){
                if(board[x][j]==1)
                    return false;
            }
            for(int i=x, j=y; i>=0 && j>=0 && i<board.length && j<board.length; i--,j--){
                if(board[i][j]==1)
                    return false;
            }
            for(int i=x, j=y; i>=0 && j>=0 && i<board.length && j<board.length; i--,j++){
                if(board[i][j]==1)
                    return false;
            }
            for(int i=x, j=y; i>=0 && j>=0 && i<board.length && j<board.length; i++,j--){
                if(board[i][j]==1)
                    return false;
            }
            for(int i=x, j=y; i>=0 && j>=0 && i<board.length && j<board.length; i++,j++){
                if(board[i][j]==1)
                    return false;
            }
            return true;
        }

        private static void placeQueen(int[][] board, int row){
            int n = board.length;
            if(row==n){
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        System.out.print(board[i][j]+" ");
                    }
                }
                System.out.println();
            }else {
                for (int column=0; column<board.length; column++){
                    if(isSafe(board, row, column)){
                        board[row][column] = 1;
                        placeQueen(board, row+1);
                        board[row][column] = 0;
                    }
                }
            }
        }

        public static void placeNQueens(int n){
            int[][] board = new int[n][n];
            placeQueen(board, 0);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Solution.placeNQueens(n);
    }
}
