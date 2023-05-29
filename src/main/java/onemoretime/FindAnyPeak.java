package onemoretime;

public class FindAnyPeak {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }

    public static int findPeakElement(int[] nums){
        // using binary search
        int start = 0;
        int end = nums.length -1;
        while ( start < end ) {
            int mid = (start + end )  / 2;
            if ( nums[mid] < nums[mid+1] ) { // peak is ->
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return start;
    }
}
