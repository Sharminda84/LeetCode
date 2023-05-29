package onemoretime;

import treesAndgraphs.TreeNode;

public class LCABT {

    private TreeNode answer;

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestore(TreeNode root, TreeNode p, TreeNode q){
        recursiveSearch(root, p, q);
        return this.answer;
    }

    public boolean recursiveSearch(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;

        int left = recursiveSearch(node.getLeft(), p, q)?1:0;
        int right = recursiveSearch(node.getRight(), p, q)?1:0;

        int mid = (node == p || node == q) ? 1: 0;

        if(mid + left + right > 2){
            this.answer = node;
        }

        return (mid + right + left) > 0;
    }
}
