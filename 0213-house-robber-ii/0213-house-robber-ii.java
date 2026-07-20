class Solution {
    public int space_optimization_house_robber_I(int[] nums , int start , int end){
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start] , nums[start+1]);

        for(int i=start+2;i<end;i++){
            int pick = prev2 + nums[i];
            int not_pick = prev1 + 0;
            int curr = Math.max(pick , not_pick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0] , nums[1]);
        int answerA = space_optimization_house_robber_I(nums , 1 , nums.length);
        int answerB = space_optimization_house_robber_I(nums  , 0 , nums.length-1);
        return Math.max(answerA , answerB);
    }
}