class Solution {
    public int max(int[] weights){
        int MAX = Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            MAX = Math.max(MAX , weights[i]);
        }
        return MAX;
    }
    public int SUM(int[] weights){
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            sum += weights[i];
        }
        return sum;
    }
    public boolean isFeasible(int mid , int[] weights , int days){
        int Days = 1 , capacity = 0;
        for(int i=0;i<weights.length;i++){
            capacity += weights[i];
            if(capacity > mid){
                capacity = weights[i];
                Days++;
            }
        }

        if(Days <= days) return true;
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights) , high = SUM(weights) , res = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            boolean ans = isFeasible(mid , weights , days);
            if(ans){
                res = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return res;
    }
}