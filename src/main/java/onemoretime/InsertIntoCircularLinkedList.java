package onemoretime;

public class InsertIntoCircularLinkedList {

    public Node insert(Node head, int insertVal){

        Node node = head;
        while(node.next != head){
            // 3-> 5
            if(node.val <= node.next.val){
                if(insertVal >= node.val && node.next.val >= insertVal){
                    break;
                }
            }
            else { // 4 -> 1
                if(insertVal < node.val || insertVal > node.next.val){
                    break;
                }
            }

            node = node.next;
        }

        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
