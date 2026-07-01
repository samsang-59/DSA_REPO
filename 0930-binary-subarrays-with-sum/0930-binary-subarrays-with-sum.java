class Solution {
    public int AtMost(int[] arr , int target){
        if(target<0) return 0;
        int start = 0 , end = 0 , sum = 0 , count = 0;
        while(end < arr.length){
            sum += arr[end];
            while(sum > target){
                sum -= arr[start];
                start++;
            }
            count += end - start + 1;
            end++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return AtMost(nums , goal) - AtMost(nums , goal-1);
    }
}