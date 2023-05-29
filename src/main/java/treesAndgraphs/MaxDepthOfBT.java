package treesAndgraphs;

public class MaxDepthOfBT {

    public static void main(String[] args) {

        //                6
        //        2            7
        //      1    4             8
        //        3      5            9

        MaxDepthOfBT max = new MaxDepthOfBT();
        TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(5)));
        TreeNode right = new TreeNode(7,null, new TreeNode(8,null, new TreeNode(9)));
        TreeNode node = new TreeNode(6, left, right);

        System.out.println(max.maxDepth(node));
    }

    public int maxDepth(TreeNode root){
        if(root  == null) return 0;

        int left_depth = maxDepth(root.getLeft());
        int right_depth = maxDepth(root.getRight());
        return Math.max(left_depth, right_depth) + 1;
    }
    // time complexity o(n)
    // space complexity, worst case unbalanced then its O(N)
    // best case height of the tree is logN,


}
