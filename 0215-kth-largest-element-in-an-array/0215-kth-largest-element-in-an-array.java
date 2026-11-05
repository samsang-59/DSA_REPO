class Solution {
    public int findKthLargest(int[] nums, int k) {
        // APPROACH 1
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // // build a max heap from the array given
        // for(int i=0;i<nums.length;i++){
        //     pq.add(nums[i]);
        // }

        // // perform k deletions from the heap then you will get your Kth largest element
        // for(int i=1;i<k;i++){
        //     pq.poll();
        // }

        // return pq.peek();

        // APPROACH - II

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int count = 0 , j = 0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            count++;
            if(count==k) {
                j = i + 1;
                break;
            }
        }

        while(j<nums.length){
            if(pq.peek() < nums[j]){
                pq.poll();
                pq.add(nums[j]);
            }
            j++;
        }

        return pq.peek();

    }
}