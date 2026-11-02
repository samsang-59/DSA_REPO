class Solution {
    // public int Before_mid(int[][] matrix , int mid){
    //     int count = 0;
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[0].length;j++){
    //             if(matrix[i][j]<=mid) count++;
    //         }
    //     }
    //     return count;
    // }

    public int Before_mid(int[][] matrix , int mid){
        int count = 0;
        int row = matrix.length - 1 , col = 0;

        while(row >=0 && col < matrix[0].length){
            if(matrix[row][col] <= mid){
                count += (row+1);
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0] , high = matrix[matrix.length-1][matrix[0].length-1];
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int count = Before_mid(matrix , mid);

            if(count>=k){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}