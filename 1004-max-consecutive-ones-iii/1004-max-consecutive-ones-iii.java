class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] hash = new int[2];

        int low = 0 , high = 0 , maxLen = Integer.MIN_VALUE;

        while(high < nums.length){
            hash[nums[high]]++;

            while((high - low + 1)- hash[1] > k){
                hash[nums[low]]--;
                low++;
            }

            maxLen = Math.max(maxLen , high - low + 1);
            high++;
        }

        if(maxLen==Integer.MAX_VALUE) return 0;
        return maxLen;
    }
}