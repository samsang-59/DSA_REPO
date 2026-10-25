class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int[] ans = new int[2];
       int i = 0 , j = numbers.length - 1 , sum = 0;
       while(i<j){
            sum = numbers[i] + numbers[j];
            if(sum > target) j--;
            else if(sum < target) i++;
            else if(sum == target) {
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
       }
       return ans;
    }
}