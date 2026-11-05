class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // heap approch using maxHeap + hashmap
        HashMap<Integer , Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> map.get(b) - map.get(a));

        for(int i=0;i<nums.length;i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }

        for(int key: map.keySet()){
            pq.add(key);
        }

        int[] arr = new int[k];

        for(int i=0;i<arr.length;i++){
            arr[i] = pq.poll();
        }
        return arr;
    }
}