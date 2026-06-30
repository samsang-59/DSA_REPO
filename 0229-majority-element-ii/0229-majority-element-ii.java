class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0 , c1 = Integer.MAX_VALUE , count2 = 0 , c2 = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=c2){
                c1 = nums[i];
                count1++;
            }else if(count2==0 && nums[i]!=c1){
                c2 = nums[i];
                count2++;
            }else if(c1!=nums[i] && c2!=nums[i]){
                count1--;
                count2--;
            }else if(nums[i]==c1){
                count1++;
            }else if(nums[i]==c2){
                count2++;
            }
        }

        int freq_c1 = 0 , freq_c2 = 0;
        for(int i=0;i<nums.length;i++){
            if(c1==nums[i]) freq_c1++;
            if(c2==nums[i]) freq_c2++;
        }

        if(freq_c1>(nums.length/3)) ans.add(c1);
        if(freq_c2>(nums.length/3)) ans.add(c2);
        return ans;
    }
}