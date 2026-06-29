class Solution {
    public int maxProfit(int[] prices) {
       int minPrice = Integer.MAX_VALUE , max_profit = 0;

       for(int i=0;i<prices.length;i++){
         max_profit = Math.max(max_profit , prices[i] - minPrice);
         minPrice = Math.min(minPrice , prices[i]);
       }
       return max_profit;
    }
}