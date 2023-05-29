package onemoretime;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {

        //[[7,null],[13,0],[11,4],[10,2],[1,0]]

        Node n_7 = new Node(7);
        Node n_13 = new Node(13);
        Node n_11 = new Node(11);
        Node n_10 = new Node(10);
        Node n_1 = new Node(1);

        n_7.next = n_13;
        n_7.random = null;
        n_13.next = n_11;
        n_13.random = n_7;
        n_11.next = n_10;
        n_11.random = n_1;
        n_10.next = n_1;
        n_10.random = n_11;
        n_1.next = null;
        n_1.random = n_7;

        CopyListWithRandomPointer copy_list = new CopyListWithRandomPointer();
        Node copy =  copy_list.copyRandomList(n_7);
    }

    public Node copyRandomList(Node head){
         if(head == null) return null;

         Node ptr = head;
         // interleaving nodes
         while ( ptr != null){ // to create the new nodes
             Node copy = new Node(ptr.val);
             copy.next = ptr.next;
             ptr.next = copy;
             ptr = copy.next;
         }
        ptr = head;
         // now set the random node
         while (ptr != null) {
             ptr.next.random = (ptr.random != null) ? ptr.random.next : null ;
             ptr = ptr.next.next;
         }

         // unweave nodes
        // A -> A' -> B -> B' -> C -> C'
        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_new = head.next;

        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = ptr_new_list.next != null ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }

        return head_new;
    }


   static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
