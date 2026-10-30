class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0 , right = 0 , sum = 0 , minLength = Integer.MAX_VALUE;

        while(right < nums.length){
           sum += nums[right];

            while(sum >= target){
                minLength = Math.min(right - left + 1 , minLength);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        if(minLength==Integer.MAX_VALUE) return 0;
        return minLength;
    }
}