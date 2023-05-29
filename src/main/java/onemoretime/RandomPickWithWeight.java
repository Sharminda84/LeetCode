package onemoretime;

public class RandomPickWithWeight {
    private int[] prefixSum;
    private int total;

    public static void main(String[] args) {

    }

    public RandomPickWithWeight(int[] w){
        prefixSum = new int[w.length];
        int sum = 0;
        for(int i=0;i < w.length; i++){
            sum += w[i];
            this.prefixSum[i] = sum;
        }
        this.total = sum;
    }

    public int pickIndex() {
        double target = this.total * Math.random();
        int start = 0;
        //binary search
        int end = prefixSum.length-1;
        while(start<end){
            int mid = (start + end) / 2;
            if(target < prefixSum[mid]){
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}
