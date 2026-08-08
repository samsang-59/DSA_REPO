class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0 , j = numbers.length - 1 , sum = 0;
        int[] ans = new int[2];
        while(i<j){
            sum = numbers[i] + numbers[j];
            if(sum==target){
                ans[0] = i+1;
                ans[1] = j+1;
                i++;
                j--;
            }
            else if(sum < target) i++;
            else if(sum > target) j--;
        }
        return ans;
    }
}