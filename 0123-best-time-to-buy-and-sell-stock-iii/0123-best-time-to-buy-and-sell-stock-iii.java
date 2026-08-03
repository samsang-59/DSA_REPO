class Solution {
    public int recurrsion(int[] prices , int index , int holding , int cap){
        if(index==prices.length) return 0;
        if(cap==0) return 0;

        int BuyStocks = Integer.MIN_VALUE , SellStocks = Integer.MIN_VALUE;
        
        // you need to buy here you can't sell
        if(holding==0){
            int buy = recurrsion(prices , index+1 , 1 , cap) - prices[index];
            int skip = recurrsion(prices , index+1 , 0 , cap);
            BuyStocks = Math.max(BuyStocks , Math.max(buy , skip));
        }

        // Selling part
        if(holding==1){
            int sell = recurrsion(prices , index+1 , 0 , cap-1) + prices[index];
            int skip = recurrsion(prices , index+1 , 1 , cap);
            SellStocks = Math.max(SellStocks , Math.max(sell , skip));
        }

        return Math.max(BuyStocks , SellStocks);
    }

    public int memoization(int[] prices , int index , int holding , int cap , int[][][] dp){
        if(index==prices.length) return 0;
        if(cap==0) return 0;
        if(dp[index][holding][cap]!=-1) return dp[index][holding][cap];

        int BuyStocks = Integer.MIN_VALUE , SellStocks = Integer.MIN_VALUE;
        
        // you need to buy here you can't sell
        if(holding==0){
            int buy = memoization(prices , index+1 , 1 , cap , dp) - prices[index];
            int skip = memoization(prices , index+1 , 0 , cap , dp);
            BuyStocks = Math.max(BuyStocks , Math.max(buy , skip));
        }

        // Selling part
        if(holding==1){
            int sell = memoization(prices , index+1 , 0 , cap-1 , dp) + prices[index];
            int skip = memoization(prices , index+1 , 1 , cap , dp);
            SellStocks = Math.max(SellStocks , Math.max(sell , skip));
        }
        dp[index][holding][cap] = Math.max(BuyStocks , SellStocks);
        return dp[index][holding][cap];
    }

    public int tabulation(int[] prices , int[][][] dp){
        for(int holding=0;holding<=1;holding++){
            for(int j=0;j<=2;j++){
                dp[prices.length][holding][j] = 0;
            }
        }

        for(int i=0;i<=prices.length;i++){
            for(int holding=0;holding<=1;holding++){
                dp[i][holding][0] = 0;
            }
        }

        for(int index=prices.length-1;index>=0;index--){
            for(int holding=0;holding<=1;holding++){
                for(int cap=1;cap<=2;cap++){
                    int BuyStocks = Integer.MIN_VALUE , SellStocks = Integer.MIN_VALUE;
        
                    // you need to buy here you can't sell
                    if(holding==0){
                        int buy = dp[index+1][1][cap] - prices[index];
                        int skip = dp[index+1][0][cap];
                        BuyStocks = Math.max(BuyStocks , Math.max(buy , skip));
                    }

                    // Selling part
                    if(holding==1){
                        int sell = dp[index+1][0][cap-1] + prices[index];
                        int skip = dp[index+1][1][cap];
                        SellStocks = Math.max(SellStocks , Math.max(sell , skip));
                    }
                    dp[index][holding][cap] = Math.max(BuyStocks , SellStocks);
                }
            }
        }

        return dp[0][0][2];
    }


    public int maxProfit(int[] prices) {
        // RECURRSION 
        // return recurrsion(prices , 0 , 0 , 2);

        // MEMOIZATION
        // int[][][] dp = new int[prices.length+1][2][3];
        // for(int i=0;i<prices.length;i++){
        //     for(int j=0;j<2;j++){
        //         for(int k=0;k<3;k++){
        //             dp[i][j][k] = -1;
        //         }
        //     }
        // }

        // return memoization(prices , 0 , 0 , 2 , dp);

        // TABULATION
        int[][][] dp = new int[prices.length+1][2][3];
        return tabulation(prices , dp);
    }
}