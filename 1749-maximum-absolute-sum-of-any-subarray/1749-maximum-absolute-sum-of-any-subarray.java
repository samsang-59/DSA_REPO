class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnding = nums[0] , minEnding = nums[0] , ans = nums[0];

        for(int i=1;i<nums.length;i++){
            maxEnding = Math.max(nums[i] , maxEnding + nums[i]);
            minEnding = Math.min(nums[i] , minEnding + nums[i]);
            ans = Math.max(ans , Math.max(maxEnding , Math.abs(minEnding)));
        }

        return Math.abs(ans);
    }
}