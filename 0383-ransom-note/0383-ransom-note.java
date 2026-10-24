class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character , Integer> ransomNote_map = new HashMap<>();
        
        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            ransomNote_map.put(c , ransomNote_map.getOrDefault(c , 0)+1);
        }

        HashMap<Character , Integer> magazine_map = new HashMap<>();

        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            magazine_map.put(c , magazine_map.getOrDefault(c , 0)+1);
        }

        for(Character key : ransomNote_map.keySet()){

            if(magazine_map.containsKey(key)){
                int requiredCount = ransomNote_map.get(key);
                int availableCount = magazine_map.get(key);
                if(availableCount < requiredCount) return false;
            } else{
                return false;
            }


        }
        
        return true;

    }
}