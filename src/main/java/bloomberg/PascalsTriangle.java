package bloomberg.arrstr;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        pt.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for(int i = 0; i < numRows ; i++){
            List<Integer> current = new ArrayList<>();
            current.add(1);
            if(!triangle.isEmpty()){
              List<Integer> previous = triangle.get(i-1);
              for(int x = 1;x <= i;x++){
                  if(x >= previous.size()) {
                      current.add(1);
                  }
                  else {
                      current.add(previous.get(x-1) + previous.get(x));
                  }
              }
            }
            triangle.add(current);
        }

        return triangle;
    }
}
