class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0 , minLength = Integer.MAX_VALUE;
        int low = 0 , high = 0;
        
        while(high < nums.length){
            while(sum < target && high < nums.length){
                sum += nums[high];
                high++;
            }
            while(sum >= target){
                minLength = Math.min(minLength , high-low);
                sum -= nums[low];
                low++;
            }
        }
        if(minLength==Integer.MAX_VALUE) return 0;
        return minLength;
    }
}