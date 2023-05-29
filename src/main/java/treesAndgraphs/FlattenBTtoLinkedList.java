package treesAndgraphs;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

public class FlattenBTtoLinkedList {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), null);
        TreeNode node = new TreeNode(1, left, right);
        FlattenBTtoLinkedList ftoLL = new FlattenBTtoLinkedList();
        ftoLL.flatten(node);
        System.out.println(node);
    }

    // Tree Node needs to pre-order traversal of the
    public void flatten(TreeNode root) {
       this.flattenTree(root);
    }

    // recursively flatten
    private TreeNode flattenTree(TreeNode node) {
        if(node == null) return null;

        if(node.left == null && node.right == null) return node;

        TreeNode leftTail = this.flattenTree(node.left);
        TreeNode rightTail = this.flattenTree(node.right);

        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }


}
