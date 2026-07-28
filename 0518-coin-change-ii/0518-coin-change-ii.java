class Solution {
    public int recurrsion(int index, int amount , int[] coins){
        if(amount<0) return 0;
        if(index==coins.length){
            if(amount==0) return 1;
            else return 0;
        }

        int pick = recurrsion(index , amount - coins[index] , coins);
        int not_pick = recurrsion(index+1 , amount , coins);
        return pick + not_pick;
    }

    public int memoization(int index , int amount , int[] coins , int[][] dp){
        if(amount<0) return 0;
        if(index==coins.length){
            if(amount==0) return 1;
            else return 0;
        }
        if(dp[index][amount]!=-1) return dp[index][amount];

        int pick = memoization(index , amount - coins[index] , coins , dp);
        int not_pick = memoization(index+1 , amount , coins , dp);
        dp[index][amount] = pick + not_pick;
        return dp[index][amount];
    }

    public int tabulation(int[][] dp , int[] coins , int amount){
        for(int i=1;i<dp[0].length;i++){
            dp[coins.length][i] = 0;
        }

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i=coins.length-1;i>=0;i--){
            for(int j=0;j<amount+1;j++){
                int not_pick = dp[i+1][j];
                int pick = 0;
                if(j >= coins[i]) pick = dp[i][j-coins[i]];
                dp[i][j] = pick + not_pick;
            }
        }
        return dp[0][amount];
    }

    public int space_optimization(int[] coins , int amount){
        int[] next = new int[amount+1];
        next[0] = 1;
        for(int i=1;i<next.length;i++){
            next[i] = 0;
        }

        for(int i=coins.length-1;i>=0;i--){
            int[] curr = new int[amount+1];
            curr[0] = 1;
            for(int j=0;j<amount+1;j++){
                int not_pick = next[j];
                int pick = 0;
                if(j >= coins[i]) pick = curr[j-coins[i]];
                curr[j] = pick + not_pick;
            }
            next = curr;
        }
        return next[amount];


    }

    public int change(int amount, int[] coins) {
        // RECURRSION
        // return recurrsion(0 , amount , coins);

        // MEMOIZATION
        // int[][] dp = new int[coins.length+1][amount+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }

        // return memoization(0 , amount , coins , dp);

        // TABULATION
        // int[][] dp = new int[coins.length+1][amount+1];
        // return tabulation(dp , coins , amount);

        // SPACE-OPTIMIZATION
        return space_optimization(coins , amount);
    }
}