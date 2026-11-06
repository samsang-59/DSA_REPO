class Solution {
    public int soldier_count(int[][] matrix , int row){
        int high = 0 , low = matrix[0].length - 1;
        int ans = matrix[0].length;

        while(high<=low){
            int mid = (high+low)/2;
            if(matrix[row][mid]==0){
                ans = mid;
                low = mid - 1;
            }
            else if(matrix[row][mid] > 0) {
                high = mid + 1;
            }
            else {
                low = mid - 1;
            }
        }
        return ans;
    }
    public int[] kWeakestRows(int[][] mat, int k) {

        int[] counts = new int[mat.length];
        for(int i=0;i<mat.length;i++){
            counts[i] = soldier_count(mat , i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> {
            if(counts[a]==counts[b]){
                return a - b;
            }
            else{
                return counts[a] - counts[b];
            }
        } );

        for(int i=0;i<mat.length;i++){
            pq.add(i);
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}