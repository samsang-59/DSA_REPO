class Solution {
    public int max_frequency(int[] hash){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<hash.length;i++){
            max = Math.max(max , hash[i]);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
       
       int[] hash = new int[26];

       int low = 0 , high = 0 , maxLen = Integer.MIN_VALUE;

       while(high < s.length()){
           
           hash[s.charAt(high) - 'A']++;

          

           while((high - low + 1) - max_frequency(hash) > k){
                hash[s.charAt(low) - 'A']--;
                low++;
           }

           maxLen = Math.max(maxLen , high - low + 1);
           high++;
       }
       if(maxLen==Integer.MIN_VALUE) return 0;
       return maxLen;
    }
}