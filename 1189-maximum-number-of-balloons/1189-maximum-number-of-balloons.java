class Solution {
    public int maxNumberOfBalloons(String text) {
        String original = "balloon";
        HashMap<Character , Integer> original_map = new HashMap<>();
        for(int i=0;i<original.length();i++){
            original_map.put(original.charAt(i) , original_map.getOrDefault(original.charAt(i) , 0)+1);
        }

        HashMap<Character , Integer> text_map = new HashMap<>();
        for(int i=0;i<text.length();i++){
            if(original_map.containsKey(text.charAt(i))){
                text_map.put(text.charAt(i) , text_map.getOrDefault(text.charAt(i) , 0)+1);
            }
        }

        boolean flag = true;
        int count = 0;
        while(flag){          
            // Iterate through every key in original_map
            for (Character key : original_map.keySet()) {
    
            // Check if the text_map contains this specific key
            if (text_map.containsKey(key)) {
            // Retrieve the values if needed
                int requiredCount = original_map.get(key);
                int availableCount = text_map.get(key);
                
            // Add your logic here
                if(availableCount >= requiredCount){
                    text_map.put(key , availableCount - requiredCount);
                }  
            // if the avialablecount < requiredcount 
                else {
                 flag = false;
                 break;
                }
            }
            else {
                flag = false;
                break;
            }
        }
            if(flag){
                count++;
            }
        }
        return count;
    }
}