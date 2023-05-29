package treesAndgraphs;

import java.util.*;

public class BTTraversals {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.push(1);deque.push(2);deque.push(3);deque.push(4);
        System.out.println(deque);
        deque.pop();
        System.out.println(deque);
        deque.poll();

        System.out.println(deque);

        TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(5)));
        TreeNode right = new TreeNode(7,null, new TreeNode(8, new TreeNode(9), null));
        TreeNode node = new TreeNode(6, left, right);

        BTTraversals bt = new BTTraversals();
        //pre order
        System.out.println(bt.pre_order_dfs_stacks(node));
        bt.pre_order_dfs_recursion(node);

        // in order
        List<Integer> in_order_recursive = new ArrayList<>();
        System.out.println(bt.in_order_dfs_stacks(node));
        bt.in_order_dfs_recursive(node, in_order_recursive);
        System.out.println(in_order_recursive);
        // post order
        List<Integer> post_order_stack = new ArrayList<>();
        List<Integer> post_order_recursion = new ArrayList<>();
        bt.post_order_dfs_stack(node, post_order_stack);
        bt.post_order_dfs_recursive(node, post_order_recursion);
        System.out.println(post_order_stack);
        System.out.println(post_order_recursion);

        // level order
        List<List<Integer>> levels = new ArrayList<>();
        bt.level_order_bfs(node, levels);
        System.out.println(levels);
    }

    /**
     * Root, left, right
     * @param node
     * @return
     */
    public List<Integer> pre_order_dfs_stacks(TreeNode node){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            result.add(curr.getVal());
            if(curr.getRight() != null ) stack.push(curr.getRight());
            if(curr.getLeft() != null) stack.push(curr.getLeft()); // next to be loaded
        }

        return result;
    }

    public void pre_order_dfs_recursion(TreeNode node){
        List<Integer> result = new ArrayList<>();
        pre_order_recursion(node, result);
        System.out.println(result);
    }

    public void pre_order_recursion(TreeNode node,List<Integer> preOrder){
        if(node == null) return;
        preOrder.add(node.getVal());
        pre_order_recursion(node.getLeft(), preOrder);
        pre_order_recursion(node.getRight(), preOrder);
    }

    /**
     * left, root, right
     * @param node
     * @return
     */
    public List<Integer> in_order_dfs_stacks(TreeNode node){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = node;
        while(curr != null || !stack.isEmpty()){
            //goto left most
            while(curr != null){
                stack.push(curr);
                curr = curr.getLeft();
            }
            curr = stack.pop(); // read it
            result.add(curr.getVal()); // add
            curr = curr.getRight(); // move to right
        }

        return result;
    }


    public void in_order_dfs_recursive(TreeNode node, List<Integer> result){
        if(node == null) return;

        in_order_dfs_recursive(node.getLeft(), result);
        result.add(node.getVal());
        in_order_dfs_recursive(node.getRight(), result);
    }

    /**
     * left, right, root
     * @param node
     * @param result
     */
    public void post_order_dfs_stack(TreeNode node, List<Integer> result) {
        LinkedList<Integer> resultQ = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push (node);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            resultQ.addFirst(curr.getVal());
            if(curr.getLeft() != null) stack.push(curr.getLeft());
            if(curr.getRight() != null) stack.push(curr.getRight());
        }

        result.addAll(resultQ);
    }

    public void post_order_dfs_recursive(TreeNode node, List<Integer> result){
       if(node == null) return;

       post_order_dfs_recursive(node.getLeft(), result);
       post_order_dfs_recursive(node.getRight(), result);
       result.add(node.getVal());
    }

    /**
     * left-> right
     * top -> bottom
     * @param node
     * @param result
     */
    public void level_order_bfs(TreeNode node, List<List<Integer>> result){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0;i < size ; i++){
                TreeNode current = queue.poll();
                level.add(current.getVal());
                if(current.getLeft() != null) queue.offer(current.getLeft());
                if(current.getRight() != null) queue.offer(current.getRight());
            }
            result.add(level);
        }
    }

}
