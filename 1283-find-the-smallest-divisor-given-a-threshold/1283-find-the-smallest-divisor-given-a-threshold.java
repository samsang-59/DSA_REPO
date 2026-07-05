class Solution {
    public int max(int[] nums){
        int MAX = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            MAX = Math.max(MAX , nums[i]);
        }
        return MAX;
    }

    public boolean isFeasible(int[] nums , int mid , int threshold){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += Math.ceil((double)nums[i]/mid);
            if(sum > threshold) return false;
        }
        return true;
    } 

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1 , high = max(nums) , res = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            boolean ans = isFeasible(nums , mid , threshold);
            if(ans){
                res = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return res;
    }
}