class Solution {
    public int findKthLargest(int[] nums, int k) {
        // APPROACH 1
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // build a max heap from the array given
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        // perform k deletions from the heap then you will get your Kth largest element
        for(int i=1;i<k;i++){
            pq.poll();
        }

        return pq.peek();
    }
}