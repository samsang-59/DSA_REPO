class Solution {
    public int recurrsion(int[] prices , int index , int holding , int cap){
        if(index==prices.length) return 0;
        if(cap==0) return 0;

        int BuyStock = Integer.MIN_VALUE , SellStock = Integer.MIN_VALUE;
        if(holding==0){
            int buy = recurrsion(prices , index+1 , 1 , cap) - prices[index];
            int skip = recurrsion(prices , index+1 , 0 , cap);
            BuyStock = Math.max(BuyStock , Math.max(buy , skip));
        }
        if(holding==1){
            int sell = recurrsion(prices , index+1 , 0 , cap-1) + prices[index];
            int skip = recurrsion(prices , index + 1 , 1 , cap);
            SellStock = Math.max(SellStock , Math.max(sell , skip));
        }

        return Math.max(BuyStock , SellStock);
    }

    public int memoization(int[] prices , int index , int holding , int cap , int[][][] dp){
        if(index==prices.length) return 0;
        if(cap==0) return 0;
        if(dp[index][holding][cap]!=-1) return dp[index][holding][cap];

        int BuyStock = Integer.MIN_VALUE , SellStock = Integer.MIN_VALUE;
        if(holding==0){
            int buy = memoization(prices , index+1 , 1 , cap , dp) - prices[index];
            int skip = memoization(prices , index+1 , 0 , cap , dp);
            BuyStock = Math.max(BuyStock , Math.max(buy , skip));
        }
        if(holding==1){
            int sell = memoization(prices , index+1 , 0 , cap-1 , dp) + prices[index];
            int skip = memoization(prices , index + 1 , 1 , cap , dp);
            SellStock = Math.max(SellStock , Math.max(sell , skip));
        }

        dp[index][holding][cap] = Math.max(BuyStock , SellStock);
        return dp[index][holding][cap];
    }

    public int maxProfit(int k, int[] prices) {
        // RECURRSION
        // return recurrsion(prices , 0 , 0 , k);

        // MEMOIZATION
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int i=0;i<=prices.length;i++){
            for(int j=0;j<2;j++){
                for(int l=0;l<=k;l++){
                    dp[i][j][l] = -1;
                }
            }
        }
        return memoization(prices , 0 , 0 , k , dp);
    }
}