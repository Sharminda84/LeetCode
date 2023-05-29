package graphs;

public class FindNumberOfConnectedGraphs {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[3][2];

        edges[0][0] = 0;
        edges[0][1] = 1; // (1,2)
        edges[1][0] = 1;
        edges[1][1] = 2; // (2,3)
        edges[2][0] = 0;
        edges[2][1] = 2; // (1,3)

        Solution solution = new Solution();
        System.out.println(solution.countComponents(n, edges));
    }
}

class Solution {

    private int find(int[] representative, int vertex) {
        if (vertex == representative[vertex]) {
            return vertex;
        }

        return representative[vertex] = find(representative, representative[vertex]);
    }

    private int combine(int[] representative, int[] size, int vertex1, int vertex2) {
        vertex1 = find(representative, vertex1);
        vertex2 = find(representative, vertex2);

        if (vertex1 == vertex2) {
            return 0;
        } else {
            if (size[vertex1] > size[vertex2]) {
                size[vertex1] += size[vertex2];
                representative[vertex2] = vertex1;
            } else {
                size[vertex2] += size[vertex1];
                representative[vertex1] = vertex2;
            }
            return 1;
        }
    }

    public int countComponents(int n, int[][] edges) {
        int[] representative = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            representative[i] = i;
            size[i] = 1;
        }

        int components = n;
        for (int i = 0; i < edges.length; i++) {
            components -= combine(representative, size, edges[i][0], edges[i][1]);
        }

        return components;
    }
}
