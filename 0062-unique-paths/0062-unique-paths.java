class Solution {
    public int find_ans(int i , int j){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        int down = find_ans(i-1 , j);
        int right = find_ans(i , j-1);
        return down + right;
    }

    public int memoization(int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int down = find_ans(i-1 , j);
        int right = find_ans(i , j-1);
        dp[i][j] = down + right;
        return dp[i][j];
    }

    public int tabulation(int[][] dp,int m,int n){
        dp[0][0] = 1;

        // row filling 
        for(int i=1;i<dp[0].length;i++){
            dp[0][i] = 1;
        }

        // column filling
        for(int i=1;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int down = dp[i-1][j];
                int right = dp[i][j-1];
                dp[i][j] = down + right;
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePaths(int m, int n) {
        // RECCURENCE
        // return find_ans(m-1 , n-1);

        // MEMOIZATION
        // int[][] dp = new int[m][n];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(m-1 , n-1 , dp);

        // TABULATION

        int[][] dp = new int[m][n];
        return tabulation(dp , m , n);

    }
}