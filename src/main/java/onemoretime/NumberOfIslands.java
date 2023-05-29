package onemoretime;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {


    public int numIslands(char[][] grid) {
        int numberofislands = 0;


        for(int row = 0; row < grid.length ; row++){
            for(int col = 0; col < grid[0].length ; col++){
                if(grid[row][col] == '1'){
                    numberofislands++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, col});
                    grid[row][col] = '0';
                    while(!queue.isEmpty()){
                        int[] current = queue.poll();
                        int r = current[0];
                        int c = current[1];
                        if(0 <= r && grid[r-1][c] == '1') {
                            queue.add(new int[]{r-1, c});
                            grid[r-1][c] = '0';
                        }
                        if(r < grid.length && grid[r+1][c] == '1') {
                            queue.add(new int[]{r+1, c});
                            grid[r+1][c] = '0';
                        }
                        if(0 <= c && grid[r][c-1] == '1') {
                            queue.add(new int[]{r, c-1});
                            grid[r][c-1] = '0';
                        }
                        if(c < grid[0].length && grid[r][c+1] == '1') {
                            queue.add(new int[]{r, c+1});
                            grid[r][c+1] = '0';
                        }
                    }
                }
            }
        }
        return numberofislands;
    }

}
