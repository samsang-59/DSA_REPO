class Solution {
    public int recurrsion(String s , String rev , int i , int j){
        if(i==s.length() || j==rev.length()) return 0;

        int pick = 0 , not_pick = 0;
        if(s.charAt(i)==rev.charAt(j)) {
            pick = 1 + recurrsion(s , rev , i+1 , j+1);
        }
        else{
            not_pick = Math.max(recurrsion(s , rev , i+1 , j),recurrsion(s , rev , i , j+1));
        }
        return Math.max(pick , not_pick);
    }

    public int memoization(String s , String rev , int i , int j , int[][] dp){
        if(i==s.length() || j==rev.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int pick = 0 , not_pick = 0;
        if(s.charAt(i)==rev.charAt(j)) {
            pick = 1 + memoization(s , rev , i+1 , j+1 , dp);
        }
        else{
            not_pick = Math.max(memoization(s , rev , i+1 , j , dp),memoization(s , rev , i , j+1 , dp));
        }
        dp[i][j] = Math.max(pick , not_pick);
        return dp[i][j];
    }

    public int tabulation(String s , String rev , int[][] dp){
        for(int i=0;i<dp[0].length;i++){
            dp[s.length()][i] = 0;
        }

        for(int j=0;j<dp.length;j++){
            dp[j][rev.length()] = 0;
        }

        for(int i=s.length()-1;i>=0;i--){
            for(int j=rev.length()-1;j>=0;j--){
                int pick = 0 , not_pick = 0;
                if(s.charAt(i)==rev.charAt(j)){
                    pick = 1 + dp[i+1][j+1];
                }
                else{
                    not_pick = Math.max(dp[i+1][j] , dp[i][j+1]);
                }
                dp[i][j] = Math.max(pick , not_pick);
            }
        }
        return dp[0][0];
    }

    public int longestPalindromeSubseq(String s) {
        
        String rev = new StringBuilder(s).reverse().toString();

        // RECURRSION
        // return recurrsion(s , rev , 0 , 0);

        // MEMOIZATION
        // int[][] dp = new int[s.length()+1][rev.length()+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp.length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(s , rev , 0 , 0 , dp);

        // TABULATION
        int[][] dp = new int[s.length()+1][rev.length()+1];
        return tabulation(s , rev , dp);
    }
}