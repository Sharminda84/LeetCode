package fbtoplist;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
      //  np.nextPermutation(new int [] {1,2,3});
        np.nextPermutation(new int [] {2,3,1});
    }

    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
        Arrays.stream(A).forEach(r -> System.out.print(r));
        System.out.println();
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
