class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character , Integer> t_map = new HashMap<>();
        HashMap<Character , Integer> s_map = new HashMap<>();
        
        int low = 0 , high = 0 , min_low = 0 , min_high = 0 , need = 0 , have = 0 , minLen = Integer.MAX_VALUE;

        for(int i=0;i<t.length();i++){
            t_map.put(t.charAt(i) , t_map.getOrDefault(t.charAt(i) , 0) + 1);
        }

        need = t_map.size();

        while(high < s.length()){
            
            s_map.put(s.charAt(high) , s_map.getOrDefault(s.charAt(high) , 0)+1);

            if(t_map.containsKey(s.charAt(high)) && s_map.get(s.charAt(high)).equals(t_map.get(s.charAt(high)))) have++;

            while(have==need){
                if(high-low+1 < minLen){
                    minLen = high-low+1;
                    min_low = low;
                    min_high = high;
                }
                s_map.put(s.charAt(low) , s_map.get(s.charAt(low)) - 1);
                
                if(t_map.containsKey(s.charAt(low)) && s_map.get(s.charAt(low)) < t_map.get(s.charAt(low))){
                    have--;
                }

                if(s_map.get(s.charAt(low))==0) {
                    s_map.remove(s.charAt(low));
                }

                low++;
            }
            high++;
        }
    
        if(minLen == Integer.MAX_VALUE) return "";

        String ans = "";
        for(int i=min_low;i<=min_high;i++){
            ans += s.charAt(i);
        }

        return ans;


    }
}