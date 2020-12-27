package Graphs.assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ThreeCycle {
    public static class Solution {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static void findCycles (boolean[][] graph, int vertex, HashMap<String, Boolean> cycles, HashMap<Integer, ArrayList<Integer>> parents, boolean[] visited) {
            visited[vertex] = true;
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            queue.add(vertex);
            queue.add(-1);
            int count = 1;
            // Getting list of elements at a distance of 2
            while (!queue.isEmpty()){
                int e = queue.poll();
                if(e==-1){
                    if(count--==0){
                        queue.clear();
                        break;
                    }
                    queue.add(-1);
                    continue;
                }
                for(int i=0; i<graph.length; i++){
                    if(graph[e][i] && !visited[i]){
                        queue.add(i);
                        if(count==0)
                            set.add(i);
                        ArrayList<Integer> pList = parents.containsKey(i) ? parents.get(i) : new ArrayList<>();
                        pList.add(e);
                        parents.put(i, pList);
                    }
                }
            }
            // Check whether a direct path exists between them
            for(int e : set){
                if(graph[vertex][e]){
                    for(int parent : parents.get(e)){
                        if(parent==vertex)
                            continue;
                        int[] cycle = {vertex, parent, e};
                        Arrays.sort(cycle);
                        String key = cycle[0]+"-"+cycle[1]+"-"+cycle[2];
                        if(!cycles.containsKey(key))
                            cycles.put(key, true);
                    }
                }
            }
            parents.clear();
        }
        public static int solve(boolean[][] graph, int n) {
            HashMap<String, Boolean> cycles = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> parents = new HashMap<>();
            boolean[] visited = new boolean[n];
            for(int i=0; i<n; i++){
                if(!visited[i])
                    findCycles(graph, i, cycles, parents, visited);
            }
            return cycles.size();
        }

        public static boolean[][] takeInput() throws IOException {
            String[] strNums;
            strNums = br.readLine().split("\\s");
            int n = Integer.parseInt(strNums[0]);
            int m = Integer.parseInt(strNums[1]);

            boolean[][] graphs = new boolean[n][n];
            int firstvertex, secondvertex;

            for (int i = 0; i < m; i++) {
                String[] strNums1;
                strNums1 = br.readLine().split("\\s");
                firstvertex = Integer.parseInt(strNums1[0]);
                secondvertex = Integer.parseInt(strNums1[1]);
                graphs[firstvertex][secondvertex] = true;
                graphs[secondvertex][firstvertex] = true;
            }
            return graphs;
        }

        public static void main(String[] args) throws NumberFormatException, IOException {
            boolean[][] graphs = takeInput();

            int ans = solve(graphs, graphs.length);
            System.out.println(ans);

        }
    }
}
