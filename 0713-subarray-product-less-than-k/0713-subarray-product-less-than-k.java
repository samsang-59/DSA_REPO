class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
      if(k==0) return 0;
      int count = 0;
      for(int i=0;i<nums.length;i++){
        int product = 1 , j = i;
        while(j<nums.length){
            product = product * nums[j];
            if(product<k) count++;
            else if(product>=k) break;
            j++;
        }
      }
      return count;
    }
}