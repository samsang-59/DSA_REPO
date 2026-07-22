class Solution {
    public int find_ans(int i , int j , int[][] obstacleGrid){
        if(i<0 || j<0) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        int down = find_ans(i-1 , j , obstacleGrid);
        int right = find_ans(i , j-1 , obstacleGrid);
        return down + right;
    }

    public int memoization(int i, int j, int[][] dp, int[][] obstacleGrid){
        if(i<0 || j<0) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int down = memoization(i-1 , j , dp , obstacleGrid);
        int right = memoization(i , j-1 , dp , obstacleGrid);
        dp[i][j] = down + right;
        return dp[i][j];
    }

    public int tabulation(int[][] dp,int m,int n,int[][] obstacleGrid){
        if(obstacleGrid[0][0]!=1) dp[0][0] = 1;
        else dp[0][0] = 0; 

        // row filling
        int i = 0;
        while(i < dp[0].length){
            if(obstacleGrid[0][i]==1) break;
            dp[0][i] = 1;
            i++;
        }
        // if you encountered an obstacle fill the rest with zeros
        while(i < dp[0].length){
            dp[0][i] = 0;
            i++;
        }
        // column filling
        int j = 0;
        while(j < dp.length){
            if(obstacleGrid[j][0]==1) break;
            dp[j][0] = 1;
            j++;
        }
        // if you encountered an obstacle fill the rest with zeros
        while(j < dp.length){
            dp[j][0] = 0;
            j++;
        }

        for(int r=1;r<dp.length;r++){
            for(int c=1;c<dp[0].length;c++){
                if(obstacleGrid[r][c]==1){
                    dp[r][c] = 0;
                    continue;
                }
                
                int down = dp[r-1][c];
                int right = dp[r][c-1];
                dp[r][c] = down + right;
            }
        }

        return dp[m-1][n-1];
    }

    public int space_optimization(int m , int n , int[][] obstacleGrid){
        int[] prev = new int[n];
        int i = 0;
        while(i < prev.length){
            if(obstacleGrid[0][i]==1) break;
            prev[i] = 1;
            i++;
        }

        while(i < prev.length){
            prev[i] = 0;
            i++;
        }

        for(int r=1;r<m;r++){
            int[] curr = new int[n];
            if(obstacleGrid[r][0]==1)curr[0] = 0;
            else curr[0] = prev[0];
            for(int c=1;c<n;c++){
                if(obstacleGrid[r][c]==1){
                    curr[c] = 0;
                    continue;
                }
                int down = prev[c];
                int right = curr[c-1];
                curr[c] = down + right;
            }
            prev = curr;
        }

        return prev[n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // RECCURENCE
        // return find_ans(m-1 , n-1 , obstacleGrid);

        // MEMOIZATION
        // int[][] dp = new int[m][n];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(m-1 , n-1 , dp , obstacleGrid);


        // TABULATION
        // int[][] dp = new int[m][n];
        // return tabulation(dp , m , n ,obstacleGrid);

        // SPACE OPTIMIZATION
        return space_optimization(m , n , obstacleGrid); 

    }
}