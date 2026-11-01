class Solution {
    public long sum(int[] candies){
        long total = 0;
        for(int i=0;i<candies.length;i++){
            total += candies[i];
        }
        return total;
    }

    public int max(int[] candies){
        int Max = Integer.MIN_VALUE;

        for(int i=0;i<candies.length;i++){
            Max = Math.max(Max , candies[i]);
        }
        return Max;
    }

    public boolean is_feasible(int[] candies , long mid , long k){
        HashMap<Integer , Integer> map = new HashMap<>();
        long count = 0;

        for(int i=0;i<candies.length;i++){
           count += candies[i]/mid; 
        }

        if(count >= k) return true;
        return false;
    }

    public int maximumCandies(int[] candies, long k) {
        if(k > sum(candies)) return 0;

        long low = 1 , high = max(candies) ; 
        long res = -1;

        while(low<=high){
            long mid = (low+high)/2;
            boolean ans = is_feasible(candies , mid , k);
            if(ans){
                res = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return (int)res;
    }
}