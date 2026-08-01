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

    public int space_optimization(String s , String rev){
        int[] next = new int[s.length()+1];

        for(int i=0;i<next.length;i++){
            next[i] = 0;
        }

        for(int i=s.length()-1;i>=0;i--){
            int[] curr = new int[rev.length()+1];
            curr[rev.length()] = 0;
            for(int j=rev.length()-1;j>=0;j--){
                int pick = 0 , not_pick = 0;
                if(s.charAt(i)==rev.charAt(j)){
                    pick = 1 + next[j+1];
                }
                else{
                    not_pick = Math.max(next[j] , curr[j+1]);
                }
                curr[j] = Math.max(pick , not_pick);
            }
            next = curr;
        }
        return next[0];
    }

    public int minDistance(String word1, String word2) {
        // RECURRSION
        // int LCS =  recurrsion(word1 , word2 , 0 , 0);
        // return word1.length() - LCS + word2.length() - LCS;

        // MEMOIZATION
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int LCS = memoization(word1 , word2 , 0 , 0 , dp);
        return word1.length() - LCS + word2.length() - LCS;

        // TABULATION
        // int[][] dp = new int[s.length()+1][rev.length()+1];
        // return tabulation(s , rev , dp);

        // SPACE_OPTIMIZATION
        // return space_optimization(s , rev);
    }
}