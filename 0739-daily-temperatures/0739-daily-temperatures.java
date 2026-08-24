class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<int[]> st = new Stack<>();
        int[] ans = new int[temperatures.length];

        int[] temp = new int[2];
        ans[ans.length-1] = 0;
        temp[0] = temperatures[temperatures.length-1];
        temp[1] = temperatures.length-1;
        st.push(temp);
        
        for(int i=temperatures.length-2;i>=0;i--){

            while(!st.isEmpty() && st.peek()[0] <= temperatures[i] ){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = 0;
            }

            else if(st.peek()[0] > temperatures[i]){
                ans[i] = st.peek()[1] - i;
            }
            
            int[] Newtemp = new int[2];
            Newtemp[0] = temperatures[i];
            Newtemp[1] = i;
            st.push(Newtemp);
        }

        return ans;
    }
}