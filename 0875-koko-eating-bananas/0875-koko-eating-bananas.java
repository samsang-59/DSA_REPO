class Solution {
    public boolean count_hours(int[] piles , int h , int mid){
        int total = 0;
        for(int i=0;i<piles.length;i++){
            total += Math.ceil((double)piles[i]/mid);
            if(total > h) return false;
        }
        return true;
    }
    public int max(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max , piles[i]);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 , high = max(piles);
        int res = -1;

        while(low <= high){
            int mid = (low + high)/2;
            

            boolean ans = count_hours(piles , h , mid);
            if(ans==true){
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }
}