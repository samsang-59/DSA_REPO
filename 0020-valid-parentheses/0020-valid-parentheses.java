class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        if(s.charAt(0)=='}' || s.charAt(0)==']' || s.charAt(0)==')'){
            return false;
        }

        if(s.charAt(0)=='{' || s.charAt(0)=='[' || s.charAt(0)=='('){
            st.push(s.charAt(0));
        }

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                st.push(s.charAt(i));
            }

            else if(!st.isEmpty() && ((s.charAt(i)=='}' && st.peek()=='{') || (s.charAt(i)==']' && st.peek()=='[') || (s.charAt(i)==')' && st.peek()=='('))){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else {
                st.push(s.charAt(i));
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}