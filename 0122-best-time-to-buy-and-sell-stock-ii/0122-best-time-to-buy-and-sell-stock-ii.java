class Solution {
    public int recurrsion(int[] prices , int index , int holding){
        if(index==prices.length) return 0;

        int BuyStocks = Integer.MIN_VALUE , SellStocks = Integer.MIN_VALUE;
        
        // you need to buy here you can't sell
        if(holding==0){
            int buy = recurrsion(prices , index+1 , 1) - prices[index];
            int skip = recurrsion(prices , index+1 , 0);
            BuyStocks = Math.max(BuyStocks , Math.max(buy , skip));
        }

        // Selling part
        if(holding==1){
            int sell = recurrsion(prices , index+1 , 0) + prices[index];
            int skip = recurrsion(prices , index+1 , 1);
            SellStocks = Math.max(SellStocks , Math.max(sell , skip));
        }

        return Math.max(BuyStocks , SellStocks);
    }

    public int memoization(int[] prices , int index , int holding , int[][] dp){
        if(index==prices.length) return 0;
        if(dp[index][holding]!=-1) return dp[index][holding];

        int BuyStocks = Integer.MIN_VALUE , SellStocks = Integer.MIN_VALUE;
        
        // you need to buy here you can't sell
        if(holding==0){
            int buy = memoization(prices , index+1 , 1 , dp) - prices[index];
            int skip = memoization(prices , index+1 , 0 , dp);
            BuyStocks = Math.max(BuyStocks , Math.max(buy , skip));
        }

        // Selling part
        if(holding==1){
            int sell = memoization(prices , index+1 , 0 , dp) + prices[index];
            int skip = memoization(prices , index+1 , 1 , dp);
            SellStocks = Math.max(SellStocks , Math.max(sell , skip));
        }

        dp[index][holding] = Math.max(BuyStocks , SellStocks);
        return dp[index][holding];
    }

    public int maxProfit(int[] prices) {
        
        // RECURRSION
        // return recurrsion(prices , 0 , 0);

        // MEMOIZATION
        int[][] dp = new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return memoization(prices , 0 , 0 , dp);
    }
}