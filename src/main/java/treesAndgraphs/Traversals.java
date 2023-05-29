package treesAndgraphs;

import java.util.*;

public class Traversals {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(5)));
        TreeNode right = new TreeNode(7,null, new TreeNode(8, null, new TreeNode(9)));
        TreeNode node = new TreeNode(6, left, right);
        Traversals t = new Traversals();
        List pre_order_r = t.pre_order_recursive(node);
        List pre_order_i = t.pre_order_iterative(node);
        List in_order_iterative = t.in_order_iterative(node);
        List in_order_recursive = t.in_order_recurisve(node);
        System.out.println(in_order_iterative);
        System.out.println(in_order_recursive);

        List post_order_r = t.post_order_recursive(node);
        List post_order_i = t.post_order_iterative(node);
        System.out.println(post_order_r);

        List bfs = t.bfs(node);
        System.out.println(bfs);
    }

    public List<Integer> pre_order_recursive(TreeNode node){
        List<Integer> list = new ArrayList<>();
        pre_order_recursive(node, list);
        return list;
    }

    private void pre_order_recursive(TreeNode node, List<Integer> list){
        if(node == null) return;

        list.add(node.getVal());
        pre_order_recursive(node.getLeft(), list);
        pre_order_recursive(node.getRight(), list);
    }

    public List<Integer> pre_order_iterative(TreeNode node){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            list.add(current.getVal());
            if(current.getRight() != null){
                stack.push(current.getRight());
            }
            if(current.getLeft() != null){
                stack.push(current.getLeft());
            }
        }
        return list;
    }

    public List<Integer> in_order_recurisve(TreeNode node){
        List<Integer> list = new ArrayList<>();
        in_order_recurisve(node, list);
        return list;
    }

    private void in_order_recurisve(TreeNode node, List<Integer> list){
        if(node == null) return;
        in_order_recurisve(node.getLeft(), list);
        list.add(node.getVal());
        in_order_recurisve(node.getRight(), list);
    }

    public List<Integer> in_order_iterative(TreeNode node){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = node;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current= current.getLeft();
            }
            current = stack.pop();
            list.add(current.getVal());
            current = current.getRight();
        }

        return list;
    }

    public List<Integer> post_order_recursive(TreeNode node){
        List<Integer> list = new ArrayList<>();
        post_order_recursive(node, list);
        return list;
    }

    private void post_order_recursive(TreeNode node, List<Integer> list){
        if ( node == null) return;
        post_order_recursive(node.getLeft(), list);
        post_order_recursive(node.getRight(), list);
        list.add(node.getVal());
    }

    public List<Integer> post_order_iterative(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            list.addFirst(curr.getVal());
            if(curr.getLeft() != null) stack.push(curr.getLeft());
            if(curr.getRight() != null) stack.push(curr.getRight());
        }

        return list;
    }

    public List<Integer> bfs(TreeNode node){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                TreeNode current = queue.poll();
                list.add(current.getVal());
                if(current.getRight() != null) {
                    queue.offer(current.getRight());
                }
                if(current.getLeft() != null) {
                    queue.offer(current.getLeft());
                }
            }
        }

        return list;
    }
}
