class Solution {
    public boolean Mid_Row_Search(int row , int target , int[][] matrix){
        int low = 0 , high = matrix[0].length - 1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
       int low = 0 , high = matrix.length - 1;

       while(low<=high){
        int mid = (low+high)/2;
        if(target > matrix[mid][matrix[0].length-1]){
            low = mid + 1;
        } else if(target < matrix[mid][0]) {
            high = mid - 1;
        } else {
            return Mid_Row_Search(mid , target , matrix);
        }
       }
       return false;
    }
}