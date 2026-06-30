class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0 , end = 0 , zeroCount = 0 , maxLen = 0;

        while(end < nums.length){
            if(nums[end]==0) {
                zeroCount++;    
            }  
            if(zeroCount > k){
                if(nums[start]==0) zeroCount--;
                start++;
            }
            if(zeroCount<=k){
                maxLen = Math.max(maxLen , end - start + 1);
            }
            end++;
        }
        return maxLen;
    }
}