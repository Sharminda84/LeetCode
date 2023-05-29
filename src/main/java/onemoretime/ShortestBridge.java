package onemoretime;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
// https://leetcode.com/problems/shortest-bridge/discuss/189321/Java-DFS-find-the-island-greater-BFS-expand-the-island
    public int shortestBridge(int[][] grid) {
        // dfs to find first island, and mark as 2 and add first island to a queue
        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n ; i++){
            if (found) break;

            for(int j = 0; j < m; j++){
                dfs(queue, i, j, grid);
                found = true;
                break;
            }
        }
        // queue is FIFO
        // bfs to find the shortest bridge reading the queue
        int bridge = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                // find areas with zero
                if( x > 0 && grid[x-1][y] == 0) {
                    queue.offer(new int[]{x-1, y});
                    grid[x-1][y] = 2;
                }
                if ( x < n-1 && grid[x+1][y] == 0){
                    queue.offer(new int[]{x+1, y});
                    grid[x+1][y] = 2;
                }
                if( y > 0 && grid[x][y-1] == 0) {
                    queue.offer(new int[]{x, y-1});
                    grid[x][y-1] = 2;
                }
                if ( y < m-1 && grid[x][y+1] == 0){
                    queue.offer(new int[]{x, y+1});
                    grid[x][y+1] = 2;
                }

                if(x > 0 && grid[x-1][y] == 1 ||
                   x < n-1 && grid[x+1][y] == 1 ||
                   y > 0 && grid[x][y-1] == 1 ||
                   y < m-1 && grid[x][y+1] == 1
                ) {
                    return bridge;
                }
            }
            bridge ++;
        }

        return bridge;
    }

    public void dfs(Queue<int[]> queue, int row, int col, int[][] grid){
        if(row <  0 || row > grid.length || col < 0 || col > grid[0].length){
            return;
        }
        grid[row][col] = 2;
        queue.offer(new int[]{row, col});
        dfs(queue, row - 1, col, grid);
        dfs(queue, row +1, col, grid);
        dfs(queue, row, col -1, grid);
        dfs(queue, row, col + 1, grid);
    }

}
