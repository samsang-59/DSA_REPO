class Solution {
    public int find_sum(int[] nums){
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }
        return total;
    }

    public int recurrsion(int index , int[] nums , int Target){
        if(index==nums.length){
            if(Target==0) return 1;
            else return 0;
        }

        int pick = recurrsion(index+1 , nums , Target - nums[index]);
        int not_pick = recurrsion(index+1 , nums , Target);
        return pick + not_pick;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int S = find_sum(nums);
        if(Math.abs(target) > S) return 0;
        if((target+S)%2!=0) return 0;
        int Target = (target+S)/2;
        

        return recurrsion(0 , nums , Target);
    }
}