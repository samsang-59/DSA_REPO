class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++){
            int left = i+1 , right = nums.length-1 , sum = 0;
            while(left<right){
                sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(closestSum - target) > Math.abs(sum - target)){
                    closestSum = sum;
                }
                if(sum == target) {
                    return sum;
                }
                else if(sum < target){
                    left++;
                }
                else if(sum > target){
                    right--;
                }
            }
        }   
        return closestSum;
    }
}