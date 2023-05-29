package fbtoplist;

import java.util.LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2); l1.next = l2;
        ListNode l3 = new ListNode(3); l2.next = l3;
        ListNode l4 = new ListNode(4); l3.next = l4;
        reverse(l1);
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


   public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

       public String toString(){
          return String.valueOf(this.val);
       }
  }
}
