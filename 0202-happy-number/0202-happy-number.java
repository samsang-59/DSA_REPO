class Solution {
    public int find_square(int n){
        int square = 0;
        while(n!=0){
            int digit = n%10;
            square += digit*digit;
            n = n/10;
        }
        return square;
    }
    public boolean isHappy(int n) {
        int slow = n , fast = n;

        while(fast!=1){
            slow = find_square(slow);
            fast = find_square(fast);
            fast = find_square(fast);
            if(slow==fast && (slow!=1 && fast!=1)) return false;
        }
        return true;
    }
}