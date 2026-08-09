class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i]==nums[i-1]) continue;
            int left = i+1 , right = nums.length - 1;
            int sum = 0;
            while(left<right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    res.add(ans);
                    left++;
                    right--;

                    while(left < right && nums[left]==nums[left-1]){
                        left++;
                    } 

                    while(left < right && nums[right]==nums[right+1]){
                        right--;
                    }
                
                }
                else if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
            }
        }
        return res;
    }
}