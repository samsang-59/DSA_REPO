class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int zero = 0 , one = 0 , maxLen = Integer.MIN_VALUE;
        

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zero++;
            if(nums[i]==1) one++;

            int diff = zero - one;

            if(diff==0) {
                maxLen = Math.max(maxLen , i+1);
            }

            if(map.containsKey(diff)){
                maxLen = Math.max(maxLen , i - map.get(diff));
            }

            else if(!map.containsKey(diff)){
                map.put(diff , i);
            }
        }

        if(maxLen==Integer.MIN_VALUE) return 0;
        return maxLen;
    }
}