package onemoretime;

import javafx.util.Pair;
import treesAndgraphs.TreeNode;

import java.util.Stack;

public class SumRootToLeaf {

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        int curr = 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, 0));

        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            curr = p.getValue();

            if(root != null){
                curr = curr * 10 + root.getVal();
                if(root.getLeft() == null && root.getRight() == null){
                    sum = sum + curr;
                }
                else {
                    stack.push(new Pair(root.getLeft(), curr));
                    stack.push(new Pair(root.getRight(), curr));
                }
            }
        }

        return sum;
    }
}
