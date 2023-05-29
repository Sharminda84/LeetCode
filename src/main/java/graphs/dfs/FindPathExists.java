package graphs.dfs;

import java.util.*;

public class FindPathExists {

    boolean found = false;

    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}};

        FindPathExists pathExists = new FindPathExists();
        System.out.println(pathExists.validPath(n, edges, 7, 5));
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) return true;

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(graph, start, end, visited);
        return found;
    }

    public void dfs(Map<Integer, Set<Integer>> graph, int start, int end, boolean[] visited) {
        for (int vertex : graph.get(start)) {
            if (vertex == end) {
                found = true;
                break;
            } else {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    dfs(graph, vertex, end, visited);
                }
            }
        }
        return;
    }
}
