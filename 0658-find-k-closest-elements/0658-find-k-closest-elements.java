class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // MIN-HEAP approach
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> {
        //     int distA = Math.abs(a - x);
        //     int distB = Math.abs(b - x);

        //     if(distA == distB){
        //         return a - b;
        //     }
        //     return distA - distB;
        // });

        // for(int i=0;i<arr.length;i++){
        //     pq.add(arr[i]);
        // }

        // List<Integer> ans = new ArrayList<>();

        // for(int i=0;i<k;i++){
        //     ans.add(pq.poll());
        // }
        // Collections.sort(ans);
        // return ans;

        // MAX-HEAP approach
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> {
            int distA = Math.abs(a - x);
            int distB = Math.abs(b - x);

            if(distA == distB){
                return b - a;
            }
            return distB - distA;
        });

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }

        Collections.sort(ans);
        return ans;
    }
}