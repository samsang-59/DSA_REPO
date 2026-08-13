class Solution {
    public int find_sum(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }

    public int find_maxSum(int[] nums){
        int maxEnd = nums[0] , ans = nums[0];

        for(int i=1;i<nums.length;i++){
            maxEnd = Math.max(nums[i] , maxEnd + nums[i]);
            ans = Math.max(ans , maxEnd);
        }
        return ans;
    }

    public int find_minSum(int[] nums){
        int minEnd = nums[0] , ans = nums[0];

        for(int i=1;i<nums.length;i++){
            minEnd = Math.min(nums[i] , minEnd + nums[i]);
            ans = Math.min(ans , minEnd);
        }
        return ans;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = find_maxSum(nums); 
        if(maxSum < 0) return maxSum; 
        int totalSum = find_sum(nums);
        int minSum = find_minSum(nums);

        return Math.max(totalSum - minSum , maxSum);

    }
}