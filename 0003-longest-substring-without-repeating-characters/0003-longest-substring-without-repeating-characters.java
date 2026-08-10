class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
       HashMap<Character , Integer> map = new HashMap<>();
       int low = 0 , high = 0 , maxLen = Integer.MIN_VALUE;
       
       while(high < s.length()){
            map.put(s.charAt(high) , map.getOrDefault(s.charAt(high) , 0) + 1);

            while(map.get(s.charAt(high)) > 1) {
                map.put(s.charAt(low) , map.get(s.charAt(low))-1);
                low++;
            }

            maxLen = Math.max(maxLen , high - low + 1);
            high++;
       }
       if(maxLen==Integer.MIN_VALUE) return 0;
       return maxLen;
    }
}