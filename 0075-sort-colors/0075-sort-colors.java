class Solution {
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
       int low = 0 , high = nums.length-1 , mid = 0;

       while(mid<=high){
          if(nums[mid]==0){
            swap(low , mid , nums);
            low++;
            mid++;
          }
          else if(nums[mid]==1) {
            mid++;
          }
          else if(nums[mid]==2){
            swap(high , mid , nums);
            high--;
          }
       }
    }
}