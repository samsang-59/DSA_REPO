class Solution {
    public int max(int[] weights){
        int Max = Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            Max = Math.max(Max , weights[i]);
        }
        return Max;
    }

    public int total(int[] weights){
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            sum += weights[i];
        }
        return sum;
    }

    public boolean is_feasible(int[] weights , int days , int mid){
        int curr_load = 0 , count = 1;
        
        for(int i=0;i<weights.length;i++){
            curr_load += weights[i];
            if(curr_load > mid){
                curr_load = weights[i];
                count++;
            }
        }
        if(count<=days) return true;
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {
       int low = max(weights) , high = total(weights);
       int res = -1; 
       while(low<=high){
        int mid = (low + high)/2;
        boolean ans = is_feasible(weights , days , mid);
        if(ans){
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