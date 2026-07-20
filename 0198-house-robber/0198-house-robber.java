class Solution {
    public int find_ans(int[] nums , int n , int[] dp){
        if(n==0) return nums[0];
        if(n==1) return Math.max(nums[n] , nums[n-1]);
        if(dp[n]!=-1) return dp[n];

        int pick = find_ans(nums , n-2 , dp) + nums[n];
        int not_pick = find_ans(nums , n-1 , dp) + 0;
        dp[n] = Math.max(pick , not_pick); 
        return dp[n];
    }
    public int tabulation(int[] dp , int[] nums){
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        for(int i=2;i<nums.length;i++){
            int pick = dp[i-2] + nums[i];
            int not_pick = dp[i-1] + 0;
            dp[i] = Math.max(pick , not_pick);
        }
        return dp[nums.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }

        // return find_ans(nums , nums.length-1 , dp);
        
        return tabulation(dp , nums);
    }
}