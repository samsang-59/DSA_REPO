class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int product = 1 , count = 0;
        int left = 0 , right = 0;

        while(right < nums.length){

            product = product * nums[right];

            while(product >= k){
                product = product/ nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }

        // if(product < k) count += right - left - 1;

        return count;
    }
}