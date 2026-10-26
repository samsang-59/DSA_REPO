class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int low = 0 , high = nums.length - 1;

        while(low<=high){
            int mid = (low+high)/2;
            // edge cases
            if(mid==0){
                if(nums[mid] > nums[mid+1]){
                    return mid;
                } 
                else low = mid + 1;
            }
            
            else if(mid==nums.length - 1){
                if(nums[mid] > nums[mid-1]){
                    return mid;
                }
                else high = mid - 1;
            }

            else if(nums[mid-1] <= nums[mid] && nums[mid] >= nums[mid+1]){
                return mid;
            }
            else if(nums[mid-1]>nums[mid] && nums[mid+1]<nums[mid]){
                high = mid - 1;
            }
            else if(nums[mid-1] < nums[mid] && nums[mid+1] > nums[mid]){
                low = mid + 1;
            }
            else if(nums[mid-1] >= nums[mid] && nums[mid+1] >= nums[mid]){
                low = mid + 1;
            }
    }
    return -1;
    }
}