package queuestacks;

import treesAndgraphs.LCABT;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        Node nG = new Node(7);
        Node nF = new Node(6, Arrays.asList(nG));
        Node nE = new Node(5);
        Node nB = new Node(2, Arrays.asList(nE));
        Node nC = new Node(3, Arrays.asList(nE, nF));
        Node nD = new Node(4, Arrays.asList(nG));
        Node nA = new Node(1, Arrays.asList(nD,nC, nB));
        System.out.println(minSteps(nA, nG));
    }

    static int minSteps(Node node, Node target){
        int steps = 0;
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int curr_q_size = queue.size();
            for(int i = 0;i < curr_q_size;i++){
                Node curr = queue.poll();
                if(curr.equals(target)){
                    return steps;
                }
                for(Node child: curr.getChildren()){
                    if(!visited.contains(child)){
                        queue.offer(child);
                    }
                }
            }
            steps++;
        }

        return steps;
    }


    public static class Node {
        private int val;
        private List<Node> children;

        public Node(int val){
            this.val = val;
            this.children = new ArrayList<>();
        }

        public Node(int val, List<Node> children){
            this(val);
            this.children = children;
        }

        public int getVal(){ return val;}
        public List<Node> getChildren(){
            return children;
        }
    }
}
