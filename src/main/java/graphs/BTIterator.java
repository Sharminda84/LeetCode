package graphs;

import treesAndgraphs.TreeNode;

import java.util.Stack;

public class BTIterator {

    Stack<TreeNode> stack;

    public BTIterator(TreeNode node){
        stack = new Stack<>();
        add(node);// will add to stack the left most node;
    }

    public void add(TreeNode node){
        //keep going until left most
        while(node != null){
            stack.push(node);
            node = node.getLeft();
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next(){
        if(!stack.isEmpty()){
            TreeNode node = stack.pop();
            add(node.getRight());
            return node.getVal();
        }
        else {
            return -1;
        }
    }
}
