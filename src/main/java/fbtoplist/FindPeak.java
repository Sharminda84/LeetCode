package fbtoplist;

public class FindPeak {

    public static void main(String[] args) {
        FindPeak fp = new FindPeak();
        System.out.println(fp.findPeakElement(new int[]{1,3,5,9,6,10,4}));
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public int findIterativePeak(int[] nums){
        int start = 0;int end = nums.length-1;

        while ( start < end) {
            int mid = (start + end)/2;
            if(nums[mid] > nums[mid + 1]){
                end  = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}
