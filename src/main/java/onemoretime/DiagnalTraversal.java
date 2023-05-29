package onemoretime;

public class DiagnalTraversal {

    public static int[] findDiagonalOrder(int[][] matrix) {
        if ( matrix == null || matrix.length == 0) return new int[0];

        int row = 0, col = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] output = new int[m * n];

        for(int pos = 0; pos < m * n ; pos++){
            output[pos] = matrix[row][col];

            if ((row + col) % 2 == 0) { // direction is always up when even
                if ( col == n - 1) {
                    row ++;
                }
                else if (row == 0) {
                    col ++;
                }
                else {
                    row --;
                    col ++;
                }
            }
            else {
                if ( row == m -1) {
                    col++;
                }
                else if ( col == 0) {
                    row++;
                }
                else {
                    row++;
                    col--;
                }
            }
        }

        return output;
    }
}
