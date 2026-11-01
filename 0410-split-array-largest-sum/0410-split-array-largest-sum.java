class Solution {
    public int max(int[] nums){
        int Max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            Max = Math.max(Max , nums[i]);
        }
        return Max;
    }

    public int sum(int[] nums){
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
        }
        return total;
    }

    public boolean is_feasible(int[] nums , int mid , int k){
        int curr_sum = nums[0] , count = 1;

        for(int i=1;i<nums.length;i++){
            curr_sum += nums[i];

            if(curr_sum > mid){
                curr_sum = nums[i];
                count++;
            }
        }

        if(count <= k) return true;
        return false;
    }

    public int splitArray(int[] nums, int k) {
        if(nums.length < k) return -1;
        int low = max(nums) , high = sum(nums);
        int res = -1;
        while(low<=high){
            int mid = (low+high)/2;
            boolean ans = is_feasible(nums , mid , k);
            if(ans){
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }
}