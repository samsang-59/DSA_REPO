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

    public int numDistinct(String s, String t) {
        
        // RECURRSION
        // return recurrsion(s , t , 0 , 0);

        // MEMOIZATION
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return memoization(s , t , 0 , 0 , dp);
    }
}