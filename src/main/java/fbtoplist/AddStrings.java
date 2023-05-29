package fbtoplist;

import java.util.LinkedList;

public class AddStrings {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(addStrings("11", "1"));
        System.out.println(addStrings("110", "12"));
        System.out.println(addStrings("11", "120"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        while(p1 >= 0 || p2 >= 0) {
            int num_1 = p1 >= 0 ? num1.charAt(p1) - '0': 0;
            int num_2 = p2 >= 0 ? num2.charAt(p2) - '0': 0;

            int value = (num_1 + num_2 + carry) % 10;
            carry = (num_1 + num_2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;
        }
        if(carry != 0) res.append(carry);

        return res.reverse().toString();
    }
}
