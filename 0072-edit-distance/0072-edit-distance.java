class Solution {
    public int recurrsion(String word1 , String word2 , int i , int j){
        if(j==word2.length()) return word1.length() - i;
        if(i==word1.length()) return word2.length() - j;

        int match = Integer.MAX_VALUE , not_match = 0;
        if(word1.charAt(i)==word2.charAt(j)){
            match = recurrsion(word1 , word2 , i+1 , j+1);
        }

        int insert = 1 + recurrsion(word1 , word2 , i , j+1);
        int delete = 1 + recurrsion(word1 , word2 , i+1 , j);
        int replace = 1 + recurrsion(word1 , word2 , i+1 , j+1);
        not_match = Math.min(insert , Math.min(delete , replace));
        return Math.min(match , not_match);
    }

    public int memoization(String word1 , String word2 , int i , int j , int[][] dp){
        if(j==word2.length()) return word1.length() - i;
        if(i==word1.length()) return word2.length() - j;
        if(dp[i][j]!=-1) return dp[i][j];

        int match = Integer.MAX_VALUE , not_match = 0;
        if(word1.charAt(i)==word2.charAt(j)){
            match = recurrsion(word1 , word2 , i+1 , j+1);
        }

        int insert = 1 + recurrsion(word1 , word2 , i , j+1);
        int delete = 1 + recurrsion(word1 , word2 , i+1 , j);
        int replace = 1 + recurrsion(word1 , word2 , i+1 , j+1);
        not_match = Math.min(insert , Math.min(delete , replace));
        dp[i][j] = Math.min(match , not_match);
        return dp[i][j];
    }

    public int tabulation(String word1 , String word2 , int[][] dp){
        int m = word1.length();
        int n = word2.length();

        // if word2 is empty
        for(int i=0;i<=word1.length();i++){
            dp[i][word2.length()] = word1.length() - i;
        }

        // if word1 is empty
        for(int j=0;j<=word2.length();j++){
            dp[word1.length()][j] = word2.length() - j;
        }


        for(int i=word1.length()-1;i>=0;i--){
            for(int j=word2.length()-1;j>=0;j--){
                int match = Integer.MAX_VALUE , not_match = Integer.MAX_VALUE;

                if(word1.charAt(i)==word2.charAt(j)) match = dp[i+1][j+1];
                int insert = 1 + dp[i][j+1];
                int delete = 1 + dp[i+1][j];
                int replace = 1 + dp[i+1][j+1];
                not_match = Math.min(insert , Math.min(delete , replace));
                dp[i][j] = Math.min(match , not_match); 
            }
        }
        return dp[0][0];
    }

    public int minDistance(String word1, String word2) {
        // RECURRSION
        // return recurrsion(word1 , word2 , 0 , 0);

        // MEMOIZATION
        // int[][] dp = new int[word1.length()+1][word2.length()+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(word1 , word2 , 0 , 0 , dp);

        // TABULATION
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        return tabulation(word1 , word2 , dp);
    }
}