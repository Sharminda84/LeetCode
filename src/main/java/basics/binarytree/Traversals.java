package basics.binarytree;

import treesAndgraphs.TreeNode;

import java.util.*;

public class Traversals {

    //                6
    //        2            7
    //      1    4             8
    //        3      5            9

    public static void main(String[] args) {
        Traversals traversals = new Traversals();

        TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(5)));
        TreeNode right = new TreeNode(7,null, new TreeNode(8,null, new TreeNode(9)));
        TreeNode node = new TreeNode(6, left, right);
        //Pre order = root -> left sub tree -> right sub tree // time o(n), space o(n)
        System.out.println(traversals.preorder_recursive(node)); // 6,2,1,4,3,5,7,8,9
        System.out.println(traversals.preorder_iterative(node)); // 6,2,1,4,3,5,7,8,9
        //In order = left subtree -> root -> right sub tree // time o(n), space o(n)
        System.out.println(traversals.inorder_recursive(node)); // 1,2,3,4,5,6,7,8,9
        System.out.println(traversals.inorder_iterative(node)); // 1,2,3,4,5,6,7,8,9

        //Post order = left subtree -> right sub tree -> root // time o(n), space o(n)
        System.out.println(traversals.postOrder_recursive(node)); // 1,3,5,4,2,9,8,7,6
        System.out.println(traversals.post_order_iterative(node)); // 1,2,3,4,5,6,7,8,9

        //Level order traversal
        System.out.println(traversals.levelOrderTraversal(node)); //(6),(2,7), (1,4,8),(3,5,9)
    }

    public List<Integer> preorder_recursive(TreeNode root){
        List<Integer> list = new ArrayList<>();
        pre_order_recurive(root, list);
        return list;
    }

    // root first,
    // left sub tree,
    // right sub tree
    public void pre_order_recurive(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        list.add(node.getVal());
        pre_order_recurive(node.getLeft(), list);
        pre_order_recurive(node.getRight(), list);
    }

    // root first
    // left subtree
    // right subtree
    // with using stack, its traversing the opposite,
    public List<Integer> preorder_iterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        TreeNode curr = null;
        while(!stack.isEmpty()){
            curr = stack.pop();
            list.add(curr.getVal());
            if(curr.getRight()!=null){
                stack.push(curr.getRight());
            }
            if(curr.getLeft()!=null){
                stack.push(curr.getLeft());
            }
        }

        return list;
    }

    // left subtree
    // root
    // right subtree
    public List<Integer> inorder_recursive(TreeNode node){
        List<Integer> list = new ArrayList<>();
        in_order_recursive(node, list);
        return list;
    }

    public void in_order_recursive(TreeNode node, List<Integer> list){
        if(node == null) return;
        in_order_recursive(node.getLeft(), list);
        list.add(node.getVal());
        in_order_recursive(node.getRight(), list);
    }

    // left subtree
    // root
    // right subtree
    // stack LIFO, opposite add
    public List<Integer> inorder_iterative(TreeNode node){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = node;
        while(current != null || !stack.isEmpty()){
           while(current != null){
               stack.push(current);
               current = current.getLeft();
           }
           current = stack.pop();
           list.add(current.getVal());
           current = current.getRight();
        }

        return list;
    }

    // post order left subtree,right subtree, root
    public List<Integer> postOrder_recursive(TreeNode node){
        List<Integer> list = new ArrayList<>();
        post_order_recursive(node, list);
        return list;
    }

    // post order left subtress, right subtree, root
    public void post_order_recursive(TreeNode node, List<Integer> list){
        if(node == null) return;

        post_order_recursive(node.getLeft(), list);
        post_order_recursive(node.getRight(), list);
        list.add(node.getVal());
    }

    public List<Integer> post_order_iterative(TreeNode node){
        LinkedList<Integer> llist = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            llist.addFirst(curr.getVal());

            if(curr.getLeft() != null) stack.push(curr.getLeft());
            if(curr.getRight() != null) stack.push(curr.getRight());
        }
        list.addAll(llist);
        return list;
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode node){
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i < size;i++){
                TreeNode curr = queue.poll();
                subList.add(curr.getVal());
                if(curr.getLeft()!=null) queue.offer(curr.getLeft());
                if(curr.getRight()!=null) queue.offer(curr.getRight());
            }
            list.add(subList);
        }
        return list;
    }

}
