class Solution {
    public int maxProduct(int[] nums) {
        int  minEnding = nums[0] , maxEnding = nums[0] , ans = nums[0];

        for(int i=1;i<nums.length;i++){
            int choice1 = nums[i];
            int choice2 = maxEnding*nums[i];
            int choice3 = minEnding*nums[i];
            maxEnding = Math.max(choice1 , Math.max(choice2 , choice3));
            minEnding = Math.min(choice1 , Math.min(choice2 , choice3));
            ans = Math.max(ans , Math.max(maxEnding , minEnding));
        }

        return ans;
    }
}