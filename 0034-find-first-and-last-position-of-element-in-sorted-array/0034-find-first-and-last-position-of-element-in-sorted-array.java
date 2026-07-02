class Solution {
    public int find_last_pos(int[] arr,int target){
        int low = 0 , high = arr.length - 1 , res = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid]==target){
                res = mid;
                low = mid + 1;
            }else if(arr[mid] > target){
                high = mid - 1;
            }else if(arr[mid] < target){
                low = mid + 1;
            }
    }
    if(res!=-1) return res;    
    return -1;
}
    public int find_first_pos(int[] arr , int target){
        int low = 0 , high = arr.length-1 , res = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid]==target){
                res = mid;
                high = mid - 1;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
        }
        if(res!=-1) return res;    
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        ans[0] = find_first_pos(nums , target);
        ans[1] = find_last_pos(nums , target);
        return ans;
    }
}