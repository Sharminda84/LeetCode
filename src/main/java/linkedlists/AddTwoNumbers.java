package linkedlists;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        boolean check;
        System.out.println('a' - 'a');
        System.out.println('b' - 'a');
        System.out.println('c' - 'a');
        System.out.println('z' - 'a');
        System.out.println('1' - 'a');
        System.out.println('9' - 'a');
        System.out.println('#' - 'a');
        print(addTwoNumbers(add(Arrays.asList(9,9,9,9,9,9,9)), add(Arrays.asList(9,9,9,9))));
    }

    public static ListNode add(List<Integer> values){
        ListNode res = new ListNode();
        ListNode curr = res;

        for(int i = 0; i < values.size(); i++){
            curr.val = values.get(i);
            if(i + 1 < values.size()){
                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        return res;
    }

    public static void print(ListNode node){
        StringBuffer sb = new StringBuffer();
        while( node != null){
            sb.append(node.val);
            node = node.next;
        }

        System.out.println(sb.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode p1 = l1,q1 = l2;
        ListNode res = new ListNode();
        ListNode curr = res;

        while (p1 != null || q1 != null) {
          int p_val = p1 != null ? p1.val: 0;
          int q_val = q1 != null ? q1.val: 0;

          p1 = p1 != null && p1.next != null ? p1.next: null;
          q1 = q1 != null && q1.next != null ? q1.next: null;

          int sum = carryOver + p_val + q_val;
          carryOver = sum / 10;
          int add = sum % 10;

          curr.val = add;
          if(p1 != null || q1 != null) {
              curr.next = new ListNode();
              curr = curr.next;
          }
          else {
              curr.next = null;
          }
        }

        if (carryOver > 0) {
           curr.next = new ListNode();
           curr = curr.next;
           curr.val = carryOver;
           curr.next = null;
        }
        else {
            curr.next = null;
        }

        return res;
    }


    public static class ListNode {
     int val;
     ListNode next;
     boolean check;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
