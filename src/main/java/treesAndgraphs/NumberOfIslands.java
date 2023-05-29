package treesAndgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        grid[0][0] = '1';grid[0][1] = '1';grid[0][2] = '0';grid[0][3] = '0';grid[0][4] = '0';
        grid[1][0] = '1';grid[1][1] = '1';grid[1][2] = '0';grid[1][3] = '0';grid[1][4] = '0';
        grid[2][0] = '0';grid[2][1] = '0';grid[2][2] = '1';grid[2][3] = '0';grid[2][4] = '0';
        grid[3][0] = '0';grid[3][1] = '0';grid[3][2] = '0';grid[3][3] = '1';grid[3][4] = '1';
        NumberOfIslands islands = new NumberOfIslands();
        islands.numOfIslandsUsingBFS(grid);
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        System.out.println("r:"+r+" c:"+c);
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    public int numOfIslandsUsingBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nc = grid[0].length;
        int nr = grid.length;
        int num_islands = 0;
        for(int r = 0; r < nr ; r ++){
            for(int c = 0; c < nc ; c++){
                if(grid[r][c] == '1'){
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neigbhours = new LinkedList<Integer>();
                    neigbhours.add(r * nc + c);
                    while(!neigbhours.isEmpty()){
                        Integer current = neigbhours.remove();
                        int curr_r = current/nc;
                        int curr_c = current%nc;
                        if(curr_r -1 >=0 && grid[curr_r - 1][curr_c] == '1' ){
                            grid[curr_r - 1][curr_c] = '0';
                            neigbhours.add((curr_r - 1)*nc + curr_c);
                        }
                        if(curr_r+1 < nr && grid[curr_r + 1][curr_c] == '1'){
                            grid[curr_r + 1][curr_c] = '0';
                            neigbhours.add((curr_r + 1)*nc + curr_c);
                        }
                        if(curr_c - 1 >= 0 && grid[curr_r][curr_c - 1] == '1'){
                            grid[curr_r][curr_c-1] = '0';
                            neigbhours.add((curr_r)*nc + curr_c -1);
                        }
                        if(curr_c + 1 < nc && grid[curr_r][curr_c + 1] == '1'){
                            grid[curr_r][curr_c+1] = '0';
                            neigbhours.add((curr_r)*nc + curr_c  +1);
                        }
                    }
                }
            }
        }
        return num_islands;
    }

}
