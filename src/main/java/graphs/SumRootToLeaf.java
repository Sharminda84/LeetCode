package graphs;

import javafx.util.Pair;
import treesAndgraphs.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumRootToLeaf {

    int answer = 0;

    public static void main(String[] args) {
        TreeNode left = new TreeNode(9, new TreeNode(5), new TreeNode(1));
        TreeNode right = new TreeNode(9);
        TreeNode node = new TreeNode(4, left, right);
        SumRootToLeaf srtl = new SumRootToLeaf();
        System.out.println(srtl.sumNumbers(node));
        System.out.println(srtl.recursiveWay(node));
    }

    public int sumNumbers(TreeNode root){
        int rootToLeaf = 0;
        int currNumber = 0;

        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();

        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            currNumber = p.getValue();

            if(root != null){
                currNumber = currNumber * 10 + root.getVal();

                if(root.getLeft() == null && root.getRight() == null){
                    rootToLeaf += currNumber;
                }
                else {
                    stack.push(new Pair(root.getLeft(), currNumber));
                    stack.push(new Pair(root.getRight(), currNumber));
                }
            }
        }

        return rootToLeaf;
    }

    public int recursiveWay(TreeNode node){
        recursive(node, 0);
        return answer;
    }


    public void recursive(TreeNode node, int current){
        if(node != null){
            current = current * 10 + node.getVal();
            if(node.getLeft() == null && node.getRight() == null){
                answer = answer + current;
            }
            recursive(node.getLeft(), current);
            recursive(node.getRight(), current);
        }
    }
}
