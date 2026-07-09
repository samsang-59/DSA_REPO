/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode slow){
        ListNode prev = null , curr = slow , Next = curr.next;

        while(Next!=null){
            curr.next = prev;
            prev = curr;
            curr = Next;
            Next = curr.next;
        }

        curr.next = prev;
        slow = curr;
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head , slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = reverse(slow);

        ListNode p1 = head , p2 = newHead;
        
        while(p1!=null && p2!=null){
            if(p1.val!=p2.val) return false;
            p1 = p1.next;
            p2 = p2.next; 
        }
        return true;
    }
}