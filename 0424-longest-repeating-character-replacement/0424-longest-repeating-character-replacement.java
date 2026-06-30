class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0 , end = 0 , maxLen = 0 , maxFreq = 0;
        int[] counts = new int[26];

        while(end < s.length()){
           counts[s.charAt(end) - 'A']++;

           maxFreq = Math.max(maxFreq , counts[s.charAt(end) - 'A']);

            if((end - start + 1) - maxFreq  > k){
                counts[s.charAt(start) - 'A']--;
                start++;
            }

            if((end - start + 1) - maxFreq  <= k){
                maxLen = Math.max(maxLen , end - start + 1);
            }
            end++;
        }
        return maxLen;
    }
}