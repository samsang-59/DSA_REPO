class Solution {
    public int[] sortedSquares(int[] nums) {
      int[] ans = new int[nums.length];
      int left = 0 , right = nums.length - 1;

        int i = 0;
      while(left <= right){
        if(nums[left] * nums[left] >= nums[right] * nums[right]){
            ans[ans.length - 1 - i] = nums[left] * nums[left];
            left++;
        }
        else{
            ans[ans.length - 1 - i] = nums[right] * nums[right];
            right--;
        }
        i++;
      }
      return ans;
    }
}