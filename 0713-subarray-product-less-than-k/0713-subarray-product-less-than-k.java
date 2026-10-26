class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
      if(k==0) return 0;
      int count = 0 , product = 1;
      int i = 0 , j = 0;
      while(j<nums.length){
        product = product * nums[j];
        while(product >= k && i<=j) {
            product = product/nums[i];
            i++;
        }
            count += j-i+1;
            j++;    
        
      }
      return count;
    }
}