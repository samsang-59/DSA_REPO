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

    public int tabulation(int[] prices , int[][] dp){
        for(int i=0;i<dp[0].length;i++){
            dp[prices.length][i] = 0;
        }

        for(int index=prices.length-1;index>=0;index--){
            for(int holding = 0 ; holding<2;holding++){
                int BuyStocks = Integer.MIN_VALUE , SellStocks = Integer.MIN_VALUE;
        
                // you need to buy here you can't sell
                if(holding==0){
                    int buy = dp[index+1][1] - prices[index];
                    int skip = dp[index+1][0];
                    BuyStocks = Math.max(BuyStocks , Math.max(buy , skip));
                }

                // Selling part
                if(holding==1){
                    int sell = dp[index+1][0] + prices[index];
                    int skip = dp[index+1][1];
                    SellStocks = Math.max(SellStocks , Math.max(sell , skip));
                }

                dp[index][holding] = Math.max(BuyStocks , SellStocks);
            }
        }
        return dp[0][0];
    }

    public int space_optimization(int[] prices){
        int[] next = new int[2];
        for(int i=0;i<next.length;i++){
            next[i] = 0;
        }
        for(int index=prices.length-1;index>=0;index--){
            int[] curr = new int[2];
            for(int holding = 0 ; holding<2;holding++){
                int BuyStocks = Integer.MIN_VALUE , SellStocks = Integer.MIN_VALUE;
        
                // you need to buy here you can't sell
                if(holding==0){
                    int buy = next[1] - prices[index];
                    int skip = next[0];
                    BuyStocks = Math.max(BuyStocks , Math.max(buy , skip));
                }

                // Selling part
                if(holding==1){
                    int sell = next[0] + prices[index];
                    int skip = next[1];
                    SellStocks = Math.max(SellStocks , Math.max(sell , skip));
                }

                curr[holding] = Math.max(BuyStocks , SellStocks);
            }
            next = curr;
        }
        return next[0];



    }

    public int maxProfit(int[] prices) {
        
        // RECURRSION
        // return recurrsion(prices , 0 , 0);

        // MEMOIZATION
        // int[][] dp = new int[prices.length+1][2];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(prices , 0 , 0 , dp);

        // TABULATION
        // int[][] dp = new int[prices.length+1][2];
        // return tabulation(prices , dp);

        // SPACE OPTIMIZATION
        return space_optimization(prices);
    }
}