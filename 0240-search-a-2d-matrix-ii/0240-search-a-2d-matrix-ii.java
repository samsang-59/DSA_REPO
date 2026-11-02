class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
       int low = 0 , high = matrix[0].length-1;

        while(low < matrix.length && high >= 0){
            if(target==matrix[low][high]) return true;
            else if(target<matrix[low][high]){
                high = high - 1;
            }
            else if(target > matrix[low][high]){
                low = low + 1;
            }
        }
        return false;
    }
}