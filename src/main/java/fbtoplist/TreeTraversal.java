package fbtoplist;

import java.util.*;

public class TreeTraversal {
    List<Integer> list = new ArrayList<>();
    private Map<Integer, List<Integer>> columnMap = new HashMap<>();


    public List<Integer> preOrderTraversal(TreeNode root){
        if(root == null) return list;

        list.add(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> postList = new ArrayList<Integer>();
        if(root == null) return postList;
        postOrder(root, postList);
        return postList;
    }

    private void inOrder(TreeNode root, List<Integer> postList){
        if(root == null) return;
        inOrder(root.left, postList);
        postList.add(root.val);
        inOrder(root.right, postList);
    }

    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> postList = new ArrayList<Integer>();
        if(root == null) return postList;
        postOrder(root, postList);
        return postList;
    }

    private void postOrder(TreeNode root, List<Integer> postList){
        if(root == null) return;
        postOrder(root.left, postList);
        postOrder(root.right, postList);
        postList.add(root.val);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        inOrderTraversal(root, 0);
        List<Integer> keys = new ArrayList<>(columnMap.keySet());
        Collections.sort(keys);
        List<List<Integer>> output = new ArrayList<>();
        for(int key: keys){
            output.add(columnMap.get(key));
        }
        return output;
    }

    private void inOrderTraversal(TreeNode node, Integer column){
        if(node == null) return;
        inOrderTraversal(node.left, --column);
        if(columnMap.get(column) == null){
            columnMap.put(column, new ArrayList<Integer>());
        }
        columnMap.get(column).add(node.val);
        inOrderTraversal(node.right, ++column);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
