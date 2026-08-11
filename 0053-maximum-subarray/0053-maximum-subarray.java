class Solution {
    public int maxSubArray(int[] nums) {
        int bestEnding = nums[0] , ans = nums[0];

        for(int i=1;i<nums.length;i++){
            bestEnding = Math.max(bestEnding+nums[i] , nums[i]);
            ans = Math.max(ans , bestEnding);
        }

        return ans;
    }
}