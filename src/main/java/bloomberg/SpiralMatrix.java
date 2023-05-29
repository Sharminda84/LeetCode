package bloomberg.arrstr;

import com.sun.xml.internal.stream.buffer.sax.SAXBufferProcessor;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix sm = new SpiralMatrix();
        sm.spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int up = 0;
        int left = 0;
        int right = m - 1;
        int down = n - 1;

        while ( result.size() < n * m) {
            // travel from left to right
            for(int col = left ; col < right ; col ++) {
                result.add(matrix[up][col]);
            }
            // travel down
            for(int row = up+1 ; row <= down ; row++) {
                result.add(matrix[row][right]);
            }
            // make sure we now on a different row
            if ( up != down ){
                for (int col = right -1; col >= left ; col--){
                    result.add(matrix[down][col]);
                }
            }
            if(left!=right){
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return result;
    }
}
