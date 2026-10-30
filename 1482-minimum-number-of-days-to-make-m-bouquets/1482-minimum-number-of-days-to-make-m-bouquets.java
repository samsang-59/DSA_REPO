class Solution {
    public boolean is_Feasible(int DAY , int[] bloomDay , int m ,int k){
        int flower_count = 0 , bouqet_count = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= DAY){
                flower_count++;
            }
            
            if(bloomDay[i] > DAY) {
                flower_count = 0;
            }
            
            if(flower_count==k) {
                bouqet_count++;
                flower_count = 0;
            }
            
        }
        if(bouqet_count >= m) return true;
        return false;
    }
    public int max(int[] bloomDay){
        int Max = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            Max = Math.max(Max , bloomDay[i]);
        }
        return Max;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
       int low = 1 , high = max(bloomDay);
       int res = -1;

       while(low<=high){
        int mid = (low+high)/2;

        boolean ans = is_Feasible(mid , bloomDay , m , k);
        if(ans){
            res = mid;
            high = mid - 1;
        } else{
            low = mid + 1;
        }
       }
       return res;
    }
}