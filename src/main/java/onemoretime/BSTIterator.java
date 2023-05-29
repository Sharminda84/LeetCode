package onemoretime;

import treesAndgraphs.TreeNode;

import java.util.*;

public class BSTIterator {

    Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            queue.offer(current.getVal());
            current = current.getRight();
        }
    }

    public int next() {
        return !queue.isEmpty() ? queue.peek(): 0;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
