class Solution {
    public int distance(int[][] points , int row){
        int x = points[row][0];
        int dist_x = x * x;
        int y = points[row][1];
        int dist_y = y * y;
        return dist_x + dist_y;
    }
    public int[][] kClosest(int[][] points, int k) {


        // APPROACH - I
        // HashMap<Integer , Integer> map = new HashMap<>();

        // for(int i=0;i<points.length;i++){
        //         int ans = distance(points , i);
        //         map.put(i , ans);
        // }

        // PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> map.get(a) - map.get(b));


        // for(int key: map.keySet()){
        //     pq.add(key);
        // }

        // int[][] ans = new int[k][2];

        // for(int i=0;i<k;i++){
        //     int row = pq.poll();
        //     ans[i][0] = points[row][0];
        //     ans[i][1] = points[row][1];
        // }
        // return ans;

        // APPROACH - II

        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> distance(points , b) - distance(points , a));

        for(int i=0;i<points.length;i++){
            int ans = distance(points , i);
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        for(int i=0;i<k;i++){
            int row = pq.poll();
            ans[i][0] = points[row][0];
            ans[i][1] = points[row][1];
        }
        return ans;
    }
}