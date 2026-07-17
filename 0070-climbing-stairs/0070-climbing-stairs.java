class Solution {
    public int find_ans(int n , int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        dp[n] = find_ans(n-1 , dp) + find_ans(n-2 , dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        return find_ans(n,dp);
    }
}