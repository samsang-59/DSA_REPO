class Solution {
    public void moveZeroes(int[] nums) {
        int read = 0 , write = 0;
        while(read < nums.length){
           if(nums[read]!=0){
                int temp = nums[write];
                nums[write] = nums[read];
                nums[read] = temp;
                write++;
            }
           read++;
        }
    }
}