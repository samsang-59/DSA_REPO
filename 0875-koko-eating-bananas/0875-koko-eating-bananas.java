class Solution {
    public int max(int[] piles){
        int MAX = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            MAX = Math.max(MAX , piles[i]);
        }
        return MAX;
    }
    public boolean isFeasible(int mid , int h , int[] piles){
        int totalhours = 0;
        for(int i=0;i<piles.length;i++){
            totalhours += Math.ceil((double)piles[i]/mid);
        }
        if(totalhours <= h) return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 , high = max(piles) , res = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            boolean ans = isFeasible (mid , h , piles);
            if(ans){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
}