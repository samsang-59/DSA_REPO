class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i=2*nums.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= nums[i%nums.length]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i%nums.length] = -1;
            }

            else if(st.peek() > nums[i%nums.length]){
                ans[i%nums.length] = st.peek();
            }

            st.push(nums[i%nums.length]);
        }
        return ans;
    }
}