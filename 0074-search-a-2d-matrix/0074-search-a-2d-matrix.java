class Solution {
    public boolean find_ans(int[][] arr , int target , int row){
        int low = 0 , high = arr[0].length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[row][mid]==target) return true;
            else if(arr[row][mid] > target) high = mid - 1;
            else if(arr[row][mid] < target) low = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0 , high = matrix.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(matrix[mid][0] > target) high = mid - 1;
            else if(matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target){
                return find_ans(matrix , target , mid);

            }
            else if(matrix[mid][matrix[0].length-1] < target) low = mid + 1;
        }
        return false;
    }
}