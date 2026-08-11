class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0] , oneDelete = 0, ans = arr[0];

        for(int i=1;i<arr.length;i++){
            oneDelete = Math.max(oneDelete + arr[i] , noDelete);
            noDelete = Math.max(noDelete + arr[i] , arr[i]);
            ans = Math.max(ans , Math.max(noDelete , oneDelete));
        }
        return ans;
    }
}