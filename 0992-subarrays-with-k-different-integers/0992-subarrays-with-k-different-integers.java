class Solution {
    public int AtMost(int[] nums , int target){
        int start = 0 , end = 0 , count = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        
        while(end < nums.length){
            map.put(nums[end] , map.getOrDefault(nums[end] , 0) + 1);
            
            while(map.size() > target){
                map.put(nums[start], map.get(nums[start]) - 1);
                if(map.get(nums[start])==0) map.remove(nums[start]);
                start++;
            }

            count += end - start + 1;
            end++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return AtMost(nums , k) - AtMost(nums , k-1);
    }
}