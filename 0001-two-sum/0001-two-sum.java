class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer , Integer> map = new HashMap<>();
       int[] arr = new int[2];
       for(int i=0;i<nums.length;i++){
          int x = nums[i];
          if(!map.containsKey(target - x)){
                map.put(x , i);
          }
          else if(map.containsKey(target - x)){
                arr[0] = map.get(target- x);
                arr[1] = i;
                break;
          }
       } 
       return arr;
    }
}