class Solution {
    public int AtMost(int[] arr , int target){
        if(target < 0) return 0;
        int start = 0 , end = 0 , sum = 0 , count = 0;

        while(end < arr.length){
            sum += arr[end];

            while(sum > target) {
                sum -= arr[start];
                start++;
            }

            count += end - start + 1;
            end++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                nums[i] = 0;
            }else if(nums[i]%2!=0){
                nums[i] = 1;
            }
        }

        return AtMost(nums , k) - AtMost(nums , k - 1);
    }
}