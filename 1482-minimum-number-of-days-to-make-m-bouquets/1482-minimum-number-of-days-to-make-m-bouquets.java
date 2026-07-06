class Solution {
    public int MIN(int[] bloomDay){
        int Min = Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            Min = Math.min(Min , bloomDay[i]);
        }
        return Min;
    }
    public int MAX(int[] bloomDay){
        int Max = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            Max = Math.max(Max , bloomDay[i]);
        }
        return Max;
    }
    public boolean isFeasible(int mid , int[] bloomDay , int m , int k){
        int consecutive = 0 , bouqet = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= mid) consecutive++;
            if(consecutive == k){
                consecutive = 0;
                bouqet++;
            }
            if(bloomDay[i]>mid) consecutive = 0;
        }

        if(bouqet >= m) return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long)m*k) return -1;
        int low = MIN(bloomDay) , high = MAX(bloomDay) , res = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            boolean ans = isFeasible(mid , bloomDay , m , k);
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