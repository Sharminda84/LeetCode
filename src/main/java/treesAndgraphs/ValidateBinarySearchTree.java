package treesAndgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {

    private static Integer prev_inorder;

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode node = new TreeNode(2, left, right);
        System.out.println(isValidBST(node));
    }

    public static boolean isValidBST(TreeNode root) {
        // validateByDFS(root, null, null);
        return inorder(root);
    }

    /*
    use DFS in order traversal to find out the if BST is true
     */
    public static boolean inorder(TreeNode root) {
        if(root == null) return true;
        if(!inorder(root.left)) return false;
        if(prev_inorder != null && root.val <= prev_inorder) return false;
        prev_inorder = root.val;
        return inorder(root.right);
    }

    /*
    * using stacks to traverse the BST
     */
    public static List<Integer> inorder_traversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode curr = root;
        while ( curr != null || !stack.isEmpty() ) {
            while ( curr != null ){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    // depth First Search Time: O(N), Space: O(N)
    public static boolean validateByDFS(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;

        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        return validateByDFS(root.left, low, root.val) && validateByDFS(root.right, root.val, high);
    }

}
