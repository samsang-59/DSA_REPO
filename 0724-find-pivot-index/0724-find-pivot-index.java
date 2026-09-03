class Solution {
    public int find_sum(int[] nums){
        int add = 0;
        for(int i=0;i<nums.length;i++){
            add += nums[i];
        }
        return add;
    }
    public int pivotIndex(int[] nums) {
       int sum = find_sum(nums);

       int currentSum = 0;
       for(int i=0;i<nums.length;i++){
            currentSum += nums[i];

            if(sum - currentSum == currentSum - nums[i]){
                return i;
            } 
       }

      
       return -1;
    }
}