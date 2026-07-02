class Solution {
    public int numberOfSubstrings(String s) {
        int[] cnt = new int[3]; 
        int start = 0 , end = 0 ,count = 0;

        while(end < s.length()){
            cnt[s.charAt(end) - 'a']++;
            
            while(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0){
                count += (s.length() - end);
                cnt[s.charAt(start)-'a']--;
                start++;
            }
            end++;
          
        }
        return count;
    }
}