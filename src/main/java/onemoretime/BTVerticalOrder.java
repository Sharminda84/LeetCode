package onemoretime;

import javafx.util.Pair;
import treesAndgraphs.TreeNode;

import java.util.*;

public class BTVerticalOrder {

    public static void main(String[] args) {

    }

    public List<List<Integer>> horizontalOrder_BFS(TreeNode node){
        Map<Integer, List<Integer>> mapOrder = new HashMap<>();

        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();

        queue.offer(new Pair<>(0, node));

        while(!queue.isEmpty()){
            Pair<Integer, TreeNode> current = queue.poll();
            int col = current.getKey();
            TreeNode c_node = current.getValue();

            if(!mapOrder.containsKey(col)){
                mapOrder.put(col, new ArrayList<>());
            }
            mapOrder.get(col).add(c_node.getVal());

            if(c_node.getLeft() != null){
                queue.offer(new Pair<>(col-1, c_node.getLeft()));
            }
            if(c_node.getRight() != null){
                queue.offer(new Pair<>(col+1, c_node.getRight()));
            }
        }

        List<Integer> keys = new ArrayList<>(mapOrder.keySet());
        Collections.sort(keys);
        List<List<Integer>> results = new ArrayList<>();
        for(Integer key: keys){
            results.add(mapOrder.get(key));
        }

        // time N + NlogN

        return results;
    }

}
