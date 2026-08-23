class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for(int i=1;i<s.length();i++){
            if(!st.isEmpty() && st.peek()==s.charAt(i)){
                while(!st.isEmpty() && st.peek()==s.charAt(i)){
                    st.pop();
                }
            }
            else if(st.isEmpty() || st.peek()!=s.charAt(i)){
                st.push(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}