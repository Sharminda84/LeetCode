
package treesAndgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), null);
        TreeNode node = new TreeNode(1, left, right);

        InorderTraversal iot = new InorderTraversal();
        System.out.println(iot.inOrder_Using_Recursion(node));
        System.out.println(iot.inOrder_using_stack(node));
    }


    /*
    Recursively traversing a tree
    time complexity O(N)
    space complexity O(N)
     */
    public List<Integer> inOrder_Using_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inOrderTraverse(root, res);
        return res;
    }

    // left -> Node  -> Right using recursive
    private void inOrderTraverse(TreeNode current, List<Integer> res) {
        if(current == null) return ;
        // travel to left
        if(current.left != null) {
           inOrderTraverse(current.left, res);
        }
        // add Node
        res.add(current.val);
        // travel to right
        if(current.right != null){
           inOrderTraverse(current.right, res);
        }
    }


    /* Iterating using stack
        time complexity O(N)
        space complexity O(N)
    */
    public List<Integer> inOrder_using_stack(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            // keep Going left first
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop(); // left most
            res.add(curr.val);
            curr = curr.right; // go to right
        }

        return res;
    }
}
