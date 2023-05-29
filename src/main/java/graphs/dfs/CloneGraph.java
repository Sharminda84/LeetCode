package graphs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
//[[2,4],[1,3],[2,4],[1,3]]

    public static void main(String[] args) {
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());

        n1.neighbors.add(n2); n1.neighbors.add(n4);
        n2.neighbors.add(n1); n2.neighbors.add(n3);
        n3.neighbors.add(n2); n3.neighbors.add(n4);
        n4.neighbors.add(n1); n4.neighbors.add(n1);

        Node result = new CloneGraph().cloneGraph(n1);
        System.out.println(result);
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(node.val == 0) return new Node();

        if(node.neighbors.isEmpty()) return new Node(node.val);
        Map<Integer, Node> nodeMap = new HashMap<>();
        clone(node, nodeMap);
        return nodeMap.get(node.val);
    }

    public void clone(Node original, Map<Integer, Node> nodeMap) {
          for (Node child : original.neighbors) {
              nodeMap.putIfAbsent(original.val, new Node(original.val));
              nodeMap.putIfAbsent(child.val, new Node(child.val));
              nodeMap.get(original.val).neighbors.add(nodeMap.get(child.val));
              if (!nodeMap.containsKey(original.val)) {
                  clone(child, nodeMap);
              }
          }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
