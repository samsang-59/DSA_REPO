class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 , current = 0 , candidate = 0;
        for(int i=0;i<nums.length;i++){
            current = nums[i];
            if(count==0) {  // we are adopting here .
                candidate = current;
                count++;
            }
            else if(candidate==current) count++;
            else count--;
        }
        return candidate;
    }
}