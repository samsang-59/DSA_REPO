class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int low = 0 , high = nums.length - 1 ;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(mid==0 && nums[mid]>nums[mid+1]) return mid;
            else if(mid==0 && nums[mid]<nums[mid+1]) low = mid + 1;
            else if(mid==nums.length - 1 && nums[mid] > nums[mid - 1]) return mid;
            else if(mid==nums.length - 1 && nums[mid] < nums[mid - 1]) high = mid - 1;
            else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]) {
                low = mid + 1;
            }
            else if(nums[mid] > nums[mid+1] && nums[mid] < nums[mid - 1]){
                high = mid - 1;
            }
            else if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]){
                high = mid - 1;
                // can also write low = mid + 1 as it is the valley condition so both side has got peak
            }
        }
        return -1;
    }
}