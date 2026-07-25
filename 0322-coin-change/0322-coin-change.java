class Solution {
    public int find_ans(int[] coins , int amount , int index){
        if(index==coins.length){
            if(amount==0) return 0;
            else return (int)1e9;
        }
        int not_pick = find_ans(coins , amount , index + 1);
        int pick = Integer.MAX_VALUE;
        if(coins[index] <= amount) pick = 1 + find_ans(coins , amount - coins[index] , index);
        return Math.min(pick , not_pick);
    }

    public int memoization(int[] coins , int amount , int[][] dp , int index){
        if(index==coins.length){
            if(amount==0) return 0;
            else return (int)1e9;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];

        int not_pick = memoization(coins , amount , dp , index + 1);
        int pick = Integer.MAX_VALUE;
        if(coins[index] <= amount) pick = 1 + memoization(coins , amount - coins[index] , dp , index);
        dp[index][amount] = Math.min(pick , not_pick);
        return dp[index][amount];
    }

    public int coinChange(int[] coins, int amount) {

        // RECURRSION
        // int ans = find_ans(coins , amount , 0);
        // if(ans >= (int)1e9) return -1;
        // else return ans;

        // memoization
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = memoization(coins , amount , dp , 0);
        if(ans>=(int)1e9) return -1;
        else return ans;
    }
}