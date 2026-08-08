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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next;

        while(fast!=null){
            if(slow.val==fast.val){
                slow.next = fast.next;
                fast = fast.next;
            }
            else{
                fast = fast.next;
                slow = slow.next;
            }
            
        }
        return head;
    }
}