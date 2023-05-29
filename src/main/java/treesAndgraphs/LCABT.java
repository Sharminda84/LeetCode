package treesAndgraphs;

public class LCABT {

    public static void main(String[] args) {

        Node n0 = new Node(0, null, null, null);
        Node n1 = new Node(1, null, null, null);
        Node n2 = new Node(2, null, null, null);
        Node n3 = new Node(3, null, null, null);
        Node n4 = new Node(4, null, null, null);
        Node n5 = new Node(5, null, null, null);
        Node n6 = new Node(6, null, null, null);
        Node n7 = new Node(7, null, null, null);
        Node n8 = new Node(8, null, null, null);
        n7.parent = n2;n4.parent = n2;
        n2.left = n7;n2.right = n4;
        n6.parent = n5;n2.parent = n5;
        n5.left = n6; n5.right = n6;

        n0.parent = n1;n8.parent = n1;
        n1.left = n0;n1.right = n8;

        n5.parent = n3; n1.parent = n3;
        n3.left = n5;n3.right = n1;

        Node node = lowestCommonAncestor(n5,n4);
        System.out.println(node);
    }

    public static Node lowestCommonAncestor(Node p, Node q) {
         Node a = p, b = q;
         while (a != b) {
         	a = a == null? q : a.parent;
         	b = b == null? p : b.parent;
           // System.out.println(a.val + " "+ b.val);
         }
         return a;
    }



    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val,Node left, Node right, Node parent){
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

}


