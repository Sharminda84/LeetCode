package treesAndgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        //                6
        //        1            1
        //      2    3       2      3


        SymmetricTree symm = new SymmetricTree();
        TreeNode left = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode right = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        TreeNode node = new TreeNode(6, left, right);

        TreeNode left1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode right1 = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        TreeNode node1 = new TreeNode(6, left1, right1);

        System.out.println(symm.recursive(node, node));
        System.out.println(symm.recursive(node1, node1));
        System.out.println(symm.iterative(node));
        System.out.println(symm.iterative(node1));
    }

    public boolean recursive(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }

        return t1.getVal() == t2.getVal()
                && (recursive(t1.getRight(), t2.getLeft()))
                && (recursive(t1.getLeft(), t2.getRight()));
    }
    // worst case o(n)
    // best case o(logn)

    public boolean iterative(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if(t1 == null && t1 == null) continue;
            if(t1 == null || t2 == null) return false;

            if(t1.getVal() != t2.getVal()) return false;

            queue.add(t1.getRight()); queue.add(t2.getLeft());
            queue.add(t1.getLeft()); queue.add(t2.getRight());
        }

        return true;
    }
}
