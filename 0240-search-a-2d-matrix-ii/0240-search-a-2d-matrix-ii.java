class Solution {
    public boolean find_ans(int[][] arr,int row , int target){
        int low  = 0 , high = arr[0].length - 1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[row][mid]==target) return true;
            else if(arr[row][mid]>target) high = mid - 1;
            else if(arr[row][mid]<target) low = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        for(int row=0;row<matrix.length;row++){
            ans = find_ans(matrix , row , target);
            if(ans==true) return true;
        }
        return ans;
    }
}