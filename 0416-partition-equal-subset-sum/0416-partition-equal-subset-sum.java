class Solution {

    public boolean find_ans(int index , int[] nums , int target){
        if(target < 0) return false;
        if(target==0) return true;
        if(index==nums.length) return false;

        boolean pick = find_ans(index+1 , nums , target-nums[index]);
        boolean not_pick = find_ans(index+1 , nums , target);
        return pick || not_pick;
    }

    public int memoization(int[][] dp , int[] nums , int index , int target){
        if(target < 0) return 0;
        if(target==0) return 1;
        if(index==nums.length) return 0;
        if(dp[index][target]!=-1) return dp[index][target];

        int pick = memoization( dp  , nums , index+1 , target-nums[index]);
        int not_pick = memoization( dp  , nums , index+1 , target);
        if(pick==1 || not_pick==1) dp[index][target] = 1;
        else dp[index][target] = 0;
        return dp[index][target];
    }

    public int tabulation(int[][] dp , int[] nums , int target){
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<dp[0].length;i++){
            dp[nums.length][i] = 0;
        }

        for(int i=nums.length - 1;i>=0;i--){
            for(int j=0;j<target+1;j++){
                int not_pick = dp[i+1][j];
                int pick = 0;
                if(j >= nums[i]) pick = dp[i+1][j-nums[i]];
                if(pick==1 || not_pick==1) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }
        return dp[0][target];
    }

    public int find_sum(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }
    public boolean canPartition(int[] nums) {
        int sum = find_sum(nums);
        if(sum % 2 !=0) return false;
        int target = sum / 2;

        // RECURSION
        // return find_ans( 0 , nums , target);

        // MEMOIZATION
        // int[][] dp = new int[nums.length+1][target+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }

        // int ans = memoization(dp , nums , 0 , target);
        // if(ans==1) return true;
        // return false;

        // TABULATION
        int[][] dp = new int[nums.length+1][target+1];
        int ans = tabulation(dp , nums , target);
        if(ans==1) return true;
        return false;
    }
}