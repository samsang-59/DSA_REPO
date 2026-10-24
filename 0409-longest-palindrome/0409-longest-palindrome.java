class Solution {
    public int find_palindrome_length(HashMap<Character , Integer> map , int length , boolean flag){
        for (Character key : map.keySet()){
            
            if(map.size()==1) return map.get(key);
            else if(map.get(key)%2==0) length += map.get(key);
            else if(map.get(key)%2!=0) length += map.get(key) - 1;
        }

        if(flag==true) return length + 1;
        return length;
    }
    public int longestPalindrome(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        int length = 0;
        boolean flag = false;

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0)+1);
        }

        for(Character key : map.keySet()){
            // checking if there is any odd number present
            if(map.get(key)%2!=0) flag = true;
        }        
        
        return find_palindrome_length(map , length , flag);
    }
}