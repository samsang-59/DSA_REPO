class Solution {
    public int recurrsion(String text1 , String text2 , int i , int j){
        if(i==text1.length() || j==text2.length()) return 0;

        int pick = 0 , not_pick = 0;
        if(text1.charAt(i)==text2.charAt(j)){
            pick = 1 + recurrsion(text1 , text2 , i+1 , j+1);
        }
        else{
            not_pick = Math.max(recurrsion(text1 , text2 , i+1 , j),recurrsion(text1 , text2 , i , j+1));
        }
        return Math.max(pick , not_pick);
    }

    public int memoization(String text1 , String text2 , int i , int j , int[][] dp){
        if(i==text1.length() || j==text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int pick = 0 , not_pick = 0;
        if(text1.charAt(i)==text2.charAt(j)) {
            pick = 1 + memoization(text1 , text2 , i+1 , j+1 , dp);
        }
        else{
            not_pick = Math.max(memoization(text1 , text2 , i+1 , j , dp),memoization(text1 , text2 , i , j+1 , dp));
        }
        dp[i][j] = Math.max(pick , not_pick);
        return dp[i][j];
    }

    public int tabulation(String text1 , String text2 , int[][] dp){
        for(int i=0;i<dp[0].length;i++){
            dp[text1.length()][i] = 0;
        }

        for(int j=0;j<dp.length;j++){
            dp[j][text2.length()] = 0;
        }

        for(int i = text1.length()-1;i>=0;i--){
            for(int j = text2.length()-1;j>=0;j--){
                int pick = 0 , not_pick = 0;
                if(text1.charAt(i)==text2.charAt(j)) {
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

    public int longestCommonSubsequence(String text1, String text2) {
        
        // RECURRSION
        // return recurrsion(text1 , text2 , 0 , 0);

        // MEMOIZATION
        // int[][] dp = new int[text1.length()+1][text2.length()+1];

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(text1 , text2 , 0 , 0 , dp);

        // TABULATION
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        return tabulation(text1 , text2 , dp);
    }
}