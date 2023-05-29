package onemoretime;

public class ConvertBTToDoubleLL {

    private Node first;
    private Node last;

    public static void main(String[] args) {

    }

    public Node treeToDoubleLL(Node root){
        if(root == null) return null;

        helper(root);
        last.right = first;
        first.left = last;

        return first;
    }

    public void helper(Node node){
        if(node != null){
            // go left
            helper(node.left);
            // node
            if(last != null) { // for the first time it will be null
                last.right = node;
                node.left = last;
            }
            else {
                first = node; //First time
            }
            last = node;
            helper(node.right);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
