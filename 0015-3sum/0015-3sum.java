class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int j = i+1 , k = nums.length - 1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    set.add(ans);
                    j++;
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k] < 0) j++;
                else {
                    k--;
                }
            }
        }

        for (List<Integer> a : set){
            res.add(a);
        }
        return res;
    }
}