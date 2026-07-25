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

    public int tabulation(int[] coins , int amount , int[][] dp){
        for(int i=1;i<dp[0].length;i++){
            dp[coins.length][i] = (int)1e9;
        }

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        for(int i=coins.length-1;i>=0;i--){
            for(int j=0;j<amount+1;j++){
                int not_pick = dp[i+1][j];
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= j) pick = 1 + dp[i][j-coins[i]];
                dp[i][j] = Math.min(pick , not_pick);
            }
        }
            return dp[0][amount];
    }

    public int coinChange(int[] coins, int amount) {

        // RECURRSION
        // int ans = find_ans(coins , amount , 0);
        // if(ans >= (int)1e9) return -1;
        // else return ans;

        // MEMOIZATION
        // int[][] dp = new int[coins.length+1][amount+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // int ans = memoization(coins , amount , dp , 0);
        // if(ans>=(int)1e9) return -1;
        // else return ans;

        // TABULATION
        int[][] dp = new int[coins.length+1][amount+1];
        int ans = tabulation(coins , amount , dp);
        if(ans>=(int)1e9) return -1;
        else return ans;
    }
}