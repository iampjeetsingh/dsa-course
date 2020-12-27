package Graphs;

import java.util.Scanner;

public class Graphs {

    public static void dftR(int[][] adjMat, int[] path, int vertex){
        System.out.println(vertex);
        path[vertex] = 1;
        for(int j=0; j< adjMat.length; j++){
            if(path[j]==0 && adjMat[vertex][j]==1){
                dftR(adjMat, path, j);
            }
        }
    }

    public static void dftransversal(int[][] adjMat){
        int[] path = new int[adjMat.length];
        dftR(adjMat, path, 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int[][] adjacentMatrix = new int[n][n];
        for(int i=0; i<e; i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            adjacentMatrix[v1][v2] = 1;
            adjacentMatrix[v2][v1] = 1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(adjacentMatrix[i][j]+" ");
            }
            System.out.println();
        }
        dftransversal(adjacentMatrix);
    }
}
