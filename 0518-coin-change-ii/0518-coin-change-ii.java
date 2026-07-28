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

    public int change(int amount, int[] coins) {
        // RECURRSION
        // return recurrsion(0 , amount , coins);

        // MEMOIZATION
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        return memoization(0 , amount , coins , dp);
    }
}