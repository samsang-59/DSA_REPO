class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0 , high = arr.length - 1;

        while(low<=high){
            int mid = (low+high)/2;
            // edge cases
            if(mid==0){
                if(arr[mid] > arr[mid+1]){
                    return mid;
                } 
                else low = mid + 1;
            }
            
            else if(mid==arr.length - 1){
                if(arr[mid] > arr[mid-1]){
                    return mid;
                }
                else high = mid - 1;
            }

            else if(arr[mid-1] <= arr[mid] && arr[mid] >= arr[mid+1]){
                return mid;
            }
            else if(arr[mid-1]>arr[mid] && arr[mid+1]<arr[mid]){
                high = mid - 1;
            }
            else if(arr[mid-1] < arr[mid] && arr[mid+1] > arr[mid]){
                low = mid + 1;
            }
    }
    return -1;
    }
}