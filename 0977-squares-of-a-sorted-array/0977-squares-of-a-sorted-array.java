class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        
        int neg = 0;
        while(neg<nums.length){
            if(nums[neg]>=0) break;
            neg++;
        }

        int right = neg , left = neg - 1;
        int i = 0;
        while(left >=0 && right < nums.length){

            if((nums[left]*nums[left])<=(nums[right]*nums[right])) {
                arr[i] = nums[left] * nums[left];
                left--;
            }
            else if((nums[left]*nums[left])>(nums[right]*nums[right])){
                arr[i] = nums[right] * nums[right];
                right++;
            }
            i++;
        }

        while(left>=0){
            arr[i] = nums[left] * nums[left];
            left--;
            i++;
        }

        while(right < nums.length){
            arr[i] = nums[right] * nums[right];
            right++;
            i++;
        }
        return arr;
    }
}