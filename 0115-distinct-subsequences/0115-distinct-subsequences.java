class Solution {
    public int recurrsion(String s , String t , int i , int j){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;

        int pick = 0 , not_pick = 0;
        if(s.charAt(i)==t.charAt(j)){
            pick = recurrsion(s , t , i+1 , j+1);
            not_pick = recurrsion(s , t , i+1 , j);
        }
        else{
            not_pick = recurrsion(s , t , i+1, j);
        }
        return pick + not_pick;
    }

    public int memoization(String s , String t , int i , int j , int[][] dp){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int pick = 0 , not_pick = 0;
        if(s.charAt(i)==t.charAt(j)) {
            pick = memoization(s , t , i+1 , j+1 , dp);
            not_pick = memoization(s , t , i+1 , j , dp);
        }
        else{
            not_pick = memoization(s , t , i+1 , j , dp);
        }

        dp[i][j] = pick + not_pick;
        return dp[i][j];
    }

    public int tabulation(String s , String t , int[][] dp){
        for(int i=0;i<dp[0].length;i++){
            dp[s.length()][i] = 0;
        }

        for(int j=0;j<dp.length;j++){
            dp[j][t.length()] = 1;
        }

        for(int i=s.length()-1;i>=0;i--){
            for(int j=t.length()-1;j>=0;j--){
                int pick = 0 , not_pick = 0;
                if(s.charAt(i)==t.charAt(j)){
                    pick = dp[i+1][j+1];
                    not_pick = dp[i+1][j];
                }
                else{
                    not_pick = dp[i+1][j];
                }
                dp[i][j] = pick + not_pick ;
            }
        }
        return dp[0][0];
    }

    public int space_optimization(String s , String t){
        int[] next = new int[t.length()+1];
        for(int i=0;i<next.length-1;i++){
            next[i] = 0;
        }

        next[t.length()] = 1;

        for(int i=s.length()-1;i>=0;i--){
            int[] curr = new int[t.length()+1];
            curr[t.length()] = 1;
            for(int j=t.length()-1;j>=0;j--){
                int pick = 0 , not_pick = 0;
                if(s.charAt(i)==t.charAt(j)){
                    pick = next[j+1];
                    not_pick = next[j];
                }
                else{
                    not_pick = next[j];
                }
                curr[j] = pick + not_pick ;
            }
            next = curr;
        }
        return next[0];
    }

    public int numDistinct(String s, String t) {
        
        // RECURRSION
        // return recurrsion(s , t , 0 , 0);

        // MEMOIZATION
        // int[][] dp = new int[s.length()+1][t.length()+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(s , t , 0 , 0 , dp);

        // TABULATION
        // int[][] dp = new int[s.length()+1][t.length()+1];
        // return tabulation(s , t , dp);

        // SPACE_OPTIMIZATION
        return space_optimization(s , t);
    }
}