class Solution {
    public int find_sum(int[] nums){
        int SUM = 0;
        for(int i=0;i<nums.length;i++){
            SUM += nums[i];
        }
        return SUM;
    }
    public int pivotIndex(int[] nums) {
        int sum = find_sum(nums);
        int left = 0 , right = 0;

        for(int i=0;i<nums.length;i++){
            right = sum-left-nums[i];

            if(left == right) return i;
            
            left += nums[i];
        }

        return -1;
    }
}