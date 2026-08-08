class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i] * nums[i];
        }

        int left = 0 , right = nums.length - 1, temp = arr.length-1;

        while(left <= right){
            if(nums[left]<=nums[right]){
                arr[temp] = nums[right];
                temp--;
                right--;
            }
            else if(nums[left]>=nums[right]){
                arr[temp] = nums[left];
                temp--;
                left++;
            }
        }
        return arr;
        
    }
}