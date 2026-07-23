class Solution {
    public int find_ans(int i , int j , int[][] grid){
        if(i<0 || j<0) return (int)1e9;
        if(i==0 && j==0) return grid[0][0];
        int DownSum = find_ans(i-1 , j , grid) + grid[i][j];
        int RightSum = find_ans(i , j-1 , grid) + grid[i][j];
        return Math.min(DownSum , RightSum);
    }

    public int memoization(int i , int j , int[][] grid , int[][] dp){
        if(i<0 || j<0) return (int)1e9;
        if(i==0 && j==0) return grid[0][0];
        if(dp[i][j]!=-1) return dp[i][j];
        int DownSum = memoization(i-1 , j , grid , dp) + grid[i][j];
        int RightSum = memoization(i , j-1 , grid , dp) + grid[i][j];
        return Math.min(DownSum , RightSum);
    }

    public int tabulation(int[][] dp , int[][] grid){

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else if(i==0 && j > 0) dp[i][j] = dp[i][j-1] + grid[i][j];
                else if(i > 0 && j==0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else{
                    int downSum = dp[i-1][j] + grid[i][j];
                    int rightSum = dp[i][j-1] + grid[i][j];
                    dp[i][j] = Math.min(downSum , rightSum);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public int space_optimization(int[][] grid){

        int[] prev = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            int[] curr = new int[grid[0].length];
            curr[0] = prev[0] + grid[i][0];
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) curr[j] = grid[i][j];
                else if(i==0 && j > 0) curr[j] = curr[j-1] + grid[i][j];
                else if(i > 0 && j==0) curr[j] = prev[j] + grid[i][j];
                else{
                    int downSum = prev[j] + grid[i][j];
                    int rightSum = curr[j-1] + grid[i][j];
                    curr[j] = Math.min(downSum , rightSum);
                }
            }
            prev = curr;
        }
        return prev[grid[0].length-1];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // RECCURSION
        // return find_ans(m-1 , n-1 , grid);

        // MEMOIZATION
        // int[][] dp = new int[m][n]; 
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(m-1 , n-1 , grid , dp);

        // TABULATION
        // int[][] dp = new int[m][n];
        // return tabulation(dp , grid);

        // SPACE_OPTIMIZATION
        return space_optimization(grid);
         
    }
}