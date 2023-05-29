package onemoretime;

import java.util.Stack;

public class MaxAreaOfIslandInMatrix {

    int[][] grid;
    boolean[][] seen_1;

    public static void main(String[] args) {
        int[][] matrix = new int[8][13];

        matrix[0] = new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0};
        matrix[1] = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        matrix[2] = new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0};
        matrix[3] = new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0};
        matrix[4] = new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0};
        matrix[5] = new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0};
        matrix[6] = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        matrix[7] = new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0};
        MaxAreaOfIslandInMatrix m = new MaxAreaOfIslandInMatrix();
     //   System.out.println(m.maxAreaOfIsland_dfs_recursive(matrix));
        System.out.println(m.maxAreaofIslands(matrix));
    }

    public int maxAreaOfIsland_dfs_recursive(int[][] grid) {
        this.grid = grid;
        seen_1 = new boolean[grid.length][grid[0].length];
        int answer = 0;
        for(int r = 0; r < grid.length ; r++ ){
            for(int c = 0; c < grid[0].length; c++){
                answer = Math.max(answer, area(r,c));
            }
        }
        return answer;
    }

    public int area(int r, int c){
        if ( r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            seen_1[r][c] || grid[r][c] == 0
        ) {
            return 0;
        }

        seen_1[r][c] = true;

        return 1
                + area(r+1,c)
                + area( r-1,c)
                + area( r, c+1)
                + area( r, c-1);
    }

    // dfs iterative, using stack
    public int maxAreaofIslands(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int answer = 0;
        int[] directions_rows = new int[]{1,-1,0,0};
        int[] directions_cols = new int[]{0,0,1,-1};
        for(int rows = 0; rows < grid.length ; rows ++) {
            for(int cols = 0; cols  < grid[0].length ; cols++) {
               if(grid[rows][cols] == 1 && !seen[rows][cols]) {
                   int shape_size = 0;
                   Stack<int[]> stack = new Stack<>();
                   stack.push(new int[]{rows, cols});
                   seen[rows][cols] = true;
                   while (!stack.isEmpty()) {
                       int[] current = stack.pop();
                       int rd = current[0];
                       int cd = current[1];
                       shape_size++;
                       for (int i = 0; i < 4; i++) {
                           int new_row = rd + directions_rows[i];
                           int new_col = cd + directions_cols[i];
                           if ( 0 <= new_row && new_row < grid.length &&
                                0 <= new_col && new_col < grid[0].length &&
                                grid[new_row][new_col] == 1 &&
                                !seen[new_row][new_col]
                           ) {
                               stack.push(new int[]{new_row, new_col});
                               seen[new_row][new_col] = true;
                           }
                       }
                   }
                   answer = Math.max(answer, shape_size);
               }
            }
        }

        return answer;
    }

}
