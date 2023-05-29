package graphs;

import javafx.util.Pair;
import treesAndgraphs.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class BTVerticalOrderTraversal {

    Map<Integer, List<Integer>> verticalMap = new HashMap<>();

    public static void main(String[] args) {
        TreeNode p = new TreeNode(9, null, null);
        TreeNode q = new TreeNode(11, null, null);
        TreeNode left = new TreeNode(2, new TreeNode(4, new TreeNode(8), p), new TreeNode(5, new TreeNode(10), q));
        TreeNode right = new TreeNode(3, new TreeNode(6, new TreeNode(12), new TreeNode(13)), new TreeNode(7, new TreeNode(14), new TreeNode(15)));
        TreeNode node = new TreeNode(1, left, right);

        BTVerticalOrderTraversal bt = new BTVerticalOrderTraversal();
        bt.bfs(node);
        List<List<Integer>> result = bt.verticalOrder(node);
        System.out.println(result);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        // DFS
        int vertical_location = 0;
        dfs(root, vertical_location);
        List<Integer> sortedLocations = verticalMap.keySet().stream().sorted().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        for(Integer loc: sortedLocations){
            result.add(verticalMap.get(loc));
        }
        return result;
    }

    public void dfs(TreeNode current, int vertical_location){
        if(current == null) return;

        dfs(current.getLeft(), vertical_location-1);
        if(!verticalMap.containsKey(vertical_location)){
            verticalMap.put(vertical_location, new ArrayList<>());
        }
        verticalMap.get(vertical_location).add(current.getVal());
        dfs(current.getRight(), vertical_location+1);
    }

    public void bfs(TreeNode node){
        Map<Integer, List<Integer>> map = new HashMap<>();
        int column = 0;
        Queue<Pair<Integer,TreeNode>> stack = new ArrayDeque<>();
        stack.offer(new Pair(column, node));
        while (!stack.isEmpty()){
            Pair pair = stack.poll();
            column = (int) pair.getKey();
            node = (TreeNode) pair.getValue();
            if(node != null){
                if(!map.containsKey(column)){
                    map.put(column, new ArrayList<>());
                }
                map.get(column).add(node.getVal());

                stack.offer(new Pair<>(column-1, node.getLeft()));
                stack.offer(new Pair<>(column+1, node.getRight()));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> keys = map.keySet().stream().sorted().collect(Collectors.toList());
        for(Integer key: keys){
            result.add(map.get(key));
        }
        System.out.println(result);
    }

}
