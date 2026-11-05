class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // approach using minHeap + hashmap
        HashMap<String , Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
            return b.compareTo(a); // Reverse alphabetical order for the min-heap
        }
        return map.get(a) - map.get(b); // Ascending order by frequency
        });

        for(int i=0;i<words.length;i++){
            map.put(words[i] , map.getOrDefault(words[i] , 0)+1);
        }

        for(String key: map.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<String> arr = new ArrayList<>();
        for(int i=0;i<k;i++){
            arr.add(pq.poll());
        }
        Collections.reverse(arr);
        return arr;
    }
}