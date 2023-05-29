package onemoretime;

import treesAndgraphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size ; i ++){
                TreeNode node = queue.poll();
                if(i == size - 1){
                    list.add(node.getVal());
                }
                if(node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if(node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
        }

        return list;
    }
}
